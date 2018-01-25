package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.communication.ServerRequest;
import com.xj.iws.common.utils.ParamUtil;
import com.xj.iws.http.mvc.dao.*;
import com.xj.iws.http.mvc.entity.*;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.http.mvc.service.RoomService;
import com.xj.iws.common.utils.DataWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomDao roomDao;
    @Autowired
    DeviceDao deviceDao;
    @Autowired
    LocationDao locationDao;
    @Autowired
    ServerDao serverDao;

    @Override
    public DataWrapper<RoomEntity> add(RoomEntity roomEntity) {
        DataWrapper<RoomEntity> dataWrapper = new DataWrapper<RoomEntity>();

        int id = roomDao.add(roomEntity);
        roomEntity.setId(id);
        dataWrapper.setData(roomEntity);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(int roomId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        int sign = roomDao.delete(roomId);
        if (sign == -1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<RoomEntity> update(RoomEntity roomEntity) {
        DataWrapper<RoomEntity> dataWrapper = new DataWrapper<RoomEntity>();
        int sign = roomDao.update(roomEntity);
        if (sign == -1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else {
            dataWrapper.setData(roomEntity);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<RoomEntity> detail(int roomId) {
        DataWrapper<RoomEntity> dataWrapper = new DataWrapper<RoomEntity>();

        //获取泵房详情
        RoomEntity room = roomDao.detail(roomId);
        //获取泵房所属地点
        LocationEntity location = locationDao.detail(room.getLocationId());
        //获取泵房内所有控制器
        List<DeviceGroupEntity> groups = deviceDao.groupList(roomId);

        room.setLocation(location);
        room.setDeviceGroups(groups);

        if (room == null) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else {
            dataWrapper.setData(room);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> addDevice(DeviceGroupEntity groupEntity, DeviceEntity[] devices) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = deviceDao.checkDevice(groupEntity.getPort());
        if (i != 0){
            dataWrapper.setErrorCode(ErrorCodeEnum.Already_Exist_Error);
        }else {
            int j = deviceDao.addGroup(groupEntity);
            if (j == 1){
                deviceDao.addDevice(groupEntity, devices);
                createTable(groupEntity.getGroupId());
            }
        }
        return dataWrapper;
    }

    private void createTable(int groupId) {
        List<DeviceEntity> devices = deviceDao.deviceList(groupId);
        String IP = serverDao.getIP();
        for (DeviceEntity device : devices) {
            String port = deviceDao.getPort(device.getId());
            int i = deviceDao.createDataTable(IP, port, device);
        }
    }

    @Override
    public DataWrapper<Void> updateDevice(DeviceEntity deviceEntity) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = deviceDao.updateGroup(deviceEntity);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> deleteDevice(int groupId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = deviceDao.deleteDevice(groupId);
        int j = deviceDao.deleteGroup(groupId);
        return dataWrapper;
    }
    private void dropTable(int groupId){
        List<DeviceEntity> devices = deviceDao.deviceList(groupId);
        String IP = serverDao.getIP();
        for (DeviceEntity device : devices) {
            String port = deviceDao.getPort(device.getId());
            int i = deviceDao.dropDataTable(IP, port, device);
        }
    }

    @Override
    public DataWrapper<List<DeviceGroupEntity>> groupList(int roomId) {
        DataWrapper<List<DeviceGroupEntity>> dataWrapper = new DataWrapper<List<DeviceGroupEntity>>();
        List<DeviceGroupEntity> groups = deviceDao.groupList(roomId);
        dataWrapper.setData(groups);
        return dataWrapper;
    }

    @Override
    public DataWrapper<DeviceGroupEntity> groupDetail(int groupId) {
        DataWrapper<DeviceGroupEntity> dataWrapper = new DataWrapper<DeviceGroupEntity>();
        DeviceGroupEntity group = deviceDao.groupDetail(groupId);
        group.setDevices(deviceDao.deviceList(groupId));
        dataWrapper.setData(group);
        return dataWrapper;
    }

    @Override
    public DataWrapper<DeviceEntity> deviceDetail(int deviceId) {
        DataWrapper<DeviceEntity> dataWrapper = new DataWrapper<DeviceEntity>();
        DeviceEntity device = deviceDao.deviceDetail(deviceId);
        dataWrapper.setData(device);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> start(String groupId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        String param = ParamUtil.stringify("groupId:" + groupId);
        Map<String, Object> response = ServerRequest.send("http://localhost:8180/iws_data/api/device/startDevice", param);

        if (null != response && "SUCCEED".equals(response.get("callStatus"))) {
            deviceDao.runGroup(groupId, 1);
            deviceDao.runDevice(groupId, 1);
        } else {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> close(String groupId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        String param = ParamUtil.stringify("groupId:" + groupId);
        Map<String, Object> response = ServerRequest.send("http://localhost:8180/iws_data/api/device/closeDevice", param);

        if (null != response && "SUCCEED".equals(response.get("callStatus"))) {
            deviceDao.runGroup(groupId, 0);
            deviceDao.runDevice(groupId, 0);
        } else {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Map<String, String>> test(DeviceGroupEntity groupEntity, DeviceEntity[] devices) {
        DataWrapper<Map<String, String>> dataWrapper = new DataWrapper<Map<String, String>>();
        Map<String, String> data = new HashMap<String, String>();
        String port = groupEntity.getPort();
        String[] arrayDevices = new String[devices.length];
        for (int i = 0; i < devices.length; i++) {
            DeviceEntity device = devices[i];
            int termId = device.getTermId();
            String number = device.getNumber();
            arrayDevices[i] = ParamUtil.stringify("termId:" + termId, "number:" + number);
        }
        String strDevices = ParamUtil.arrayToString(arrayDevices);
        String param = ParamUtil.stringify("port:" + port, "devices:" + strDevices);

        Map<String, Object> response = ServerRequest.send("http://localhost:8180/iws_data/api/device/testDevice", param);
        if (null != response && "SUCCEED".equals(response.get("callStatus"))) {
            String result = (String) response.get("data");
            String status;
            String massage = "终端控制器组# " + port + " : ";
            if (0 == result.length()) {
                status = "1";
                massage += "已成功连接!";
            } else {
                status = "0";
                massage += "控制器# " + result + " 连接有误,请检查以上控制器是否正确安装";
            }

            data.put("status", status);
            data.put("massage", massage);

            dataWrapper.setData(data);
        } else {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> turnPump(String deviceId, String number, String pumpStatus) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        String param = ParamUtil.stringify("deviceId:" + deviceId, "fieldNum:" + number, "pumpStatus:" + pumpStatus);
        Map<String, Object> response = ServerRequest.send("http://localhost:8180/iws_data/api/device/turnPump", param);

        if (null != response && "SUCCEED".equals(response.get("callStatus"))) {
        } else {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }


}
