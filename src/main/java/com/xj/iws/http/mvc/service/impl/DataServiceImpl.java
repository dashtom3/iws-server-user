package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.Variables;
import com.xj.iws.common.communication.ServerRequest;
import com.xj.iws.common.data.DataProcess;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.common.utils.ParamUtil;
import com.xj.iws.common.utils.TimeUtil;
import com.xj.iws.http.mvc.dao.*;
import com.xj.iws.http.mvc.dao.redis.RedisBase;
import com.xj.iws.http.mvc.entity.DataEntity;
import com.xj.iws.http.mvc.entity.DeviceEntity;
import com.xj.iws.http.mvc.entity.DeviceTermEntity;
import com.xj.iws.http.mvc.entity.PointFieldEntity;
import com.xj.iws.http.mvc.entity.util.DataField;
import com.xj.iws.http.mvc.entity.util.ViewDataEntity;
import com.xj.iws.http.mvc.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

/**
 * Created by XiaoJiang01 on 2017/3/31.
 */
@Service
public class DataServiceImpl implements DataService {

    private static final int MODUS_TYPE=2;

    private static final int TCP_TYPE=1;

    @Autowired
    DataDao dataDao;
    @Autowired
    DeviceTermDao deviceTermDao;
    @Autowired
    DataProcess dataProcess;
    @Autowired
    DeviceDao deviceDao;
    @Autowired
    RedisBase redisBase;


    @Override
    public DataWrapper<List<ViewDataEntity>> query(Map<String, String> conditions, Page page) {
        DataWrapper<List<ViewDataEntity>> dataWrapper = new DataWrapper<List<ViewDataEntity>>();

        DeviceEntity device = deviceDao.deviceDetail(Integer.parseInt(conditions.get("deviceId")));
        System.out.println("device"+device);
        String port = device.getPort();
        String number = device.getNumber();
        preConditions(device);
        System.out.println("device1"+device);
        List<ViewDataEntity> viewDatas =new ArrayList<ViewDataEntity>();
        int type=0;
        if("TCP".equals(device.getProtocol())){//S7协议
            type=TCP_TYPE;
            conditions.put("tableName", "data_tcp_"+device.getId());
            conditions.put("timeStep",Integer.parseInt(conditions.get("timeStep"))/ Variables.TIMESTEP+"");
        }else{
            type=MODUS_TYPE;
            conditions.put("tableName", "data_" + port + "#" + number);
        }
        String startId = dataDao.getStartIdByTime(conditions);
        String endId = dataDao.getEndIdByTime(conditions);

        conditions.put("startId", startId);
        conditions.put("endId", endId);
        conditions.put("dataId", getDataId(conditions, page));
        int totalNumber = dataDao.getCount(conditions);

        List<DataEntity> datas = dataDao.query(conditions);
        for (DataEntity data : datas) {
            ViewDataEntity viewData = dataProcess.process(data,type);
            viewDatas.add(viewData);
        }
        dataWrapper.setPage(page, totalNumber);

        dataWrapper.setData(viewDatas);
        return dataWrapper;
    }

    public DataWrapper<List<ViewDataEntity>> dataAtPresentDate(Map<String, String> conditions, Page page) {
        DataWrapper<List<ViewDataEntity>> dataWrapper = new DataWrapper<List<ViewDataEntity>>();
        String date = TimeUtil.getDate(new Date(), 0);
        int deviceId = Integer.parseInt(conditions.get("deviceId"));
        DeviceEntity device = deviceDao.deviceDetail(deviceId);

        String port = device.getPort();
        String number = device.getNumber();
        int count = device.getCount();
        int bit = device.getBit();

        String tableName = "data_" + date + "_" + port + "#" + number;
        preConditions(device);
        String startTime = conditions.get("startTime").split(" ")[1].replaceAll(":", "");
        String endTime = conditions.get("endTime").split(" ")[1].replaceAll(":", "");
        int timeStep = Integer.parseInt(conditions.get("timeStep"));

        Object[] dataSet = redisBase.zSetOps().rangeByScoreWithScores(tableName, Double.valueOf(startTime), Double.valueOf(endTime)).toArray();
        List<String> tempList = new ArrayList<String>();
        for (int i = 0; i < dataSet.length; i++) {
            ZSetOperations.TypedTuple<String> ops = (ZSetOperations.TypedTuple<String>) dataSet[i];
            if (ops.getScore() % timeStep == 0) {
                tempList.add(ops.getValue());
            }
        }
        int totalNumber = tempList.size();

        List<String> dataList = new ArrayList<String>();
        for (int i = page.getCurrentNumber(); i < page.getNumberPerPage(); i++) {
            try {
                dataList.add(tempList.get(i));
            } catch (Exception e) {
                break;
            }
        }

        List<ViewDataEntity> viewDatas = new ArrayList<ViewDataEntity>();
        for (String temp : dataList) {
            String[] arrayTemp = temp.split(":");
            String strTime = date + arrayTemp[0];
            Date time = null;
            try {
                time = TimeUtil.changeStringToDate(strTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String data = arrayTemp[1];
            String exception = arrayTemp[2];

            DataEntity dataEntity = new DataEntity(0, deviceId, port, number, time, exception, count, bit, data);
            ViewDataEntity viewData = dataProcess.process(dataEntity,MODUS_TYPE);
            viewDatas.add(viewData);
        }

        dataWrapper.setData(viewDatas);
        dataWrapper.setPage(page, totalNumber);
        return dataWrapper;
    }

    @Override
    public DataWrapper<ViewDataEntity> presentData(int deviceId) {
        synchronized (this){
            DataWrapper<ViewDataEntity> dataWrapper = new DataWrapper<ViewDataEntity>();
            DeviceEntity device = deviceDao.deviceDetail(deviceId);
            preConditions(device);
            System.out.println("device"+device);
            if("TCP".equals(device.getProtocol())){//S7协议
                DataEntity dataEntity=dataDao.getTCPPresentData("data_tcp_"+device.getId(),device.getId());
                System.out.println(dataEntity);
                ViewDataEntity viewData=null;
                if(dataEntity!=null){
                    viewData = dataProcess.process(dataEntity,TCP_TYPE);
                }
                System.out.println("viewData");
                dataWrapper.setData(viewData);
                return dataWrapper;

            }

            DataEntity dataEntity = getPresentData(device);
            System.out.println(dataEntity);
            ViewDataEntity viewData=null;
            if(dataEntity!=null){
                viewData = dataProcess.process(dataEntity,MODUS_TYPE);
            }
            System.out.println("viewData");
            dataWrapper.setData(viewData);
            return dataWrapper;
        }
//        DataWrapper<ViewDataEntity> dataWrapper = new DataWrapper<ViewDataEntity>();
//        DeviceEntity device = deviceDao.deviceDetail(deviceId);
//        preConditions(device);
//
//        DataEntity dataEntity = getPresentData(device);
//        ViewDataEntity viewData = dataProcess.process(dataEntity);
//
//        dataWrapper.setData(viewData);
//        return dataWrapper;
    }

    @Override
    public DataWrapper<List<DataField>> pumpStatus(int deviceId) {
        DataWrapper<List<DataField>> dataWrapper = new DataWrapper<List<DataField>>();
        DeviceEntity device = deviceDao.deviceDetail(deviceId);

        DataEntity dataEntity = getPresentData(device);
        List<PointFieldEntity> pointFields = deviceTermDao.fieldList(device.getTermId());
        dataProcess.enable(pointFields);
        List<DataField> pumpStatus = dataProcess.pumpStatus(dataEntity);

        dataWrapper.setData(pumpStatus);
        return dataWrapper;
    }

    @Override
    public DataWrapper<ViewDataEntity> pointData(String termId, String port, String number) {
        DataWrapper<ViewDataEntity> dataWrapper = new DataWrapper<ViewDataEntity>();
        DeviceTermEntity deviceTerm = deviceTermDao.detail(Integer.parseInt(termId));

        String param = ParamUtil.stringify("termId:" + termId, "port:" + port, "number" + number);
        Map<String, Object> response = ServerRequest.send("http://localhost:8180/iws_data/api/device/pointData", param);

        String data = null;
        if (null != response && "SUCCEED".equals(response.get("callStatus"))) {
            data = (String) response.get("data");
        } else {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        if (null != data) {
            int count = deviceTerm.getCount();
            int length = deviceTermDao.getBit(Integer.parseInt(termId));

            DataEntity dataEntity = new DataEntity(0, 0, port, number, new Date(), "ER", count, length, data);

            List<PointFieldEntity> pointFields = deviceTermDao.fieldList(Integer.parseInt(termId));
            dataProcess.enable(pointFields);

            ViewDataEntity viewData = dataProcess.process(dataEntity,MODUS_TYPE);
            dataWrapper.setData(viewData);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<ViewDataEntity> modelData(int deviceId) {
        DataWrapper<ViewDataEntity> dataWrapper = new DataWrapper<ViewDataEntity>();
        DeviceEntity device = deviceDao.deviceDetail(deviceId);
        String date = TimeUtil.getDate(new Date(), 0);
        int termId = device.getTermId();
        List<PointFieldEntity> pointFields = deviceTermDao.modelFieldList(termId);
        dataProcess.enable(pointFields);

        DataEntity dataEntity = getPresentData(device);
        ViewDataEntity viewData = dataProcess.process(dataEntity,MODUS_TYPE);

        dataWrapper.setData(viewData);
        return dataWrapper;
    }

    private void preConditions(DeviceEntity device) {
        int termId = device.getTermId();
        List<PointFieldEntity> pointFields = deviceTermDao.fieldList(termId);
        dataProcess.enable(pointFields);
    }

    private DataEntity getPresentData(DeviceEntity device) {
        String date = TimeUtil.getDate(new Date(), 0);
        String port = device.getPort();
        String number = device.getNumber();
        int count = device.getCount();
        int bit = device.getBit();

        String tableName = "data_" + date + "_" + port + "#" + number;
        String now = TimeUtil.getTime(new Date(), -1);

        Object[] dataList = redisBase.zSetOps().rangeByScore(tableName, Double.parseDouble(now), Double.parseDouble(now)).toArray();
        if (dataList.length == 0) {
            return null;
        }

        String temp = (String) dataList[0];
        String[] arrayTemp = temp.split(":");
        String strTime = date + arrayTemp[0];
        Date time = null;
        try {
            time = TimeUtil.changeStringToDate(strTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String data = arrayTemp[1];
        String exception = arrayTemp[2];

        return new DataEntity(0, device.getId(), port, number, time, exception, count, bit, data);
    }

    private String getDataId(Map<String, String> conditions, Page page) {
        StringBuilder dataId = new StringBuilder();
        int step = Integer.parseInt(conditions.get("timeStep"));
        int startId;
        int endId;
        try{
            startId = Integer.parseInt(conditions.get("startId"));
            endId = Integer.parseInt(conditions.get("endId"));
        }catch (Exception e){
            return "0";
        }
        for (int i = page.getCurrentNumber(); ; i++) {
            int a = startId + step * i;
            dataId.append(a);
            if (a <= endId && i < page.getCurrentNumber() + page.getNumberPerPage() - 1) {
                dataId.append(",");
            } else {
                return dataId.toString();
            }
        }
    }
}
