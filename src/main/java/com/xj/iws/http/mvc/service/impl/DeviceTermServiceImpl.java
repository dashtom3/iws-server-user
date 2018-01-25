package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.communication.ServerRequest;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.PackageUtil;
import com.xj.iws.common.utils.Page;
import com.xj.iws.common.utils.ParamUtil;
import com.xj.iws.http.mvc.dao.PointRoleDao;
import com.xj.iws.http.mvc.dao.DeviceTermDao;
import com.xj.iws.http.mvc.entity.DeviceTermEntity;
import com.xj.iws.http.mvc.entity.DeviceTypeEntity;
import com.xj.iws.http.mvc.entity.PointFieldEntity;
import com.xj.iws.http.mvc.entity.PointRoleEntity;
import com.xj.iws.http.mvc.service.DeviceTermService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by XiaoJiang01 on 2017/3/24.
 */
@Service
public class DeviceTermServiceImpl implements DeviceTermService {
    @Autowired
    DeviceTermDao deviceTermDao;
    @Autowired
    PointRoleDao pointRoleDao;

    @Override
    public DataWrapper<DeviceTermEntity> add(DeviceTermEntity deviceTermEntity, PointFieldEntity[] fields) {
        DataWrapper<DeviceTermEntity> dataWrapper = new DataWrapper<DeviceTermEntity>();
        deviceTermEntity.setCount(fields.length);
        int i = deviceTermDao.addDevice(deviceTermEntity);
        for (int j = 0; j < fields.length; j++) {
            fields[j].setNumber(j + 1);
        }
        int j = deviceTermDao.addField(deviceTermEntity.getId(), fields);
        if (i != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else {
            List<PointFieldEntity> list = new ArrayList<PointFieldEntity>();
            Collections.addAll(list, fields);

            deviceTermEntity.setFields(list);
            dataWrapper.setData(deviceTermEntity);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<DeviceTypeEntity>> typeList() {
        DataWrapper<List<DeviceTypeEntity>> dataWrapper = new DataWrapper<List<DeviceTypeEntity>>();
        List<DeviceTypeEntity> types = deviceTermDao.typeList();
        dataWrapper.setData(types);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<PointRoleEntity>> pointRole() {
        DataWrapper<List<PointRoleEntity>> dataWrapper = new DataWrapper<List<PointRoleEntity>>();
        dataWrapper.setData(pointRoleDao.list());
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(int pointTableId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = deviceTermDao.deleteDevice(pointTableId);
        if (i != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<DeviceTermEntity> update(DeviceTermEntity deviceTermEntity) {
        DataWrapper<DeviceTermEntity> dataWrapper = new DataWrapper<DeviceTermEntity>();
        int i = deviceTermDao.update(deviceTermEntity);
        dataWrapper.setData(deviceTermEntity);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<DeviceTermEntity>> list(String type, Page page) {
        DataWrapper<List<DeviceTermEntity>> dataWrapper = new DataWrapper<List<DeviceTermEntity>>();
        List<DeviceTermEntity> devices = deviceTermDao.deviceTermList(type, page);
        for (DeviceTermEntity deviceTerm : devices) {
            List<PointFieldEntity> fields = deviceTermDao.fieldList(deviceTerm.getId());
            deviceTerm.setFields(fields);
        }
        int totalNumber = deviceTermDao.getCount(type);
        dataWrapper.setPage(page, totalNumber);
        dataWrapper.setData(devices);
        return dataWrapper;
    }

    @Override
    public DataWrapper<DeviceTermEntity> detail(int deviceTermId) {
        DataWrapper<DeviceTermEntity> dataWrapper = new DataWrapper<DeviceTermEntity>();
        DeviceTermEntity device = deviceTermDao.detail(deviceTermId);
        device.setFields(deviceTermDao.fieldList(deviceTermId));
        dataWrapper.setData(device);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<DeviceTermEntity>> query(Map<String, String> condition) {
        DataWrapper<List<DeviceTermEntity>> dataWrapper = new DataWrapper<List<DeviceTermEntity>>();
        List<DeviceTermEntity> devices = deviceTermDao.query(condition);
        dataWrapper.setData(devices);
        return dataWrapper;
    }

    @Override
    public DataWrapper<String> check(int type, PointFieldEntity[] fields, String port, String number) {
        DataWrapper<String> dataWrapper = new DataWrapper<String>();
        int count = fields.length;
        String[] address = new String[count];
        if (type == 2)
            for (int i = 0; i < fields.length; i++) {
                address[i] = fields[i].getAddress();
            }
        String strAddress = ParamUtil.arrayToString(address);
        String param = ParamUtil.stringify("type:" + type, "count:" + count, "address:" + strAddress, "port:" + port, "number:" + number);
        Map<String, Object> response = ServerRequest.send("http://localhost:8180/iws_data/api/device/checkTable", param);
        if (null != response && "SUCCEED".equals(response.get("callStatus"))) {
            dataWrapper.setData((String) response.get("data"));
        } else {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }


}
