package com.xj.iws.http.mvc.service;

import com.xj.iws.http.mvc.entity.DeviceEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupEntity;
import com.xj.iws.http.mvc.entity.RoomEntity;
import com.xj.iws.common.utils.DataWrapper;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
public interface RoomService {

    DataWrapper<RoomEntity> add(RoomEntity roomEntity);

    DataWrapper<Void> delete(int roomId);

    DataWrapper<RoomEntity> update(RoomEntity roomEntity);

    DataWrapper<RoomEntity> detail(int roomId);

    DataWrapper<Void> addDevice(DeviceGroupEntity groupEntity, DeviceEntity[] devices);

    DataWrapper<Void> updateDevice(DeviceEntity deviceEntity);

    DataWrapper<Void> deleteDevice(int groupId);

    DataWrapper<List<DeviceGroupEntity>> groupList(int roomId);

    DataWrapper<DeviceGroupEntity> groupDetail(int groupId);

    DataWrapper<Void> start(String groupIds);

    DataWrapper<DeviceEntity> deviceDetail(int deviceId);

    DataWrapper<Void> close(String groupId);

    DataWrapper<Map<String,String>> test(DeviceGroupEntity groupEntity, DeviceEntity[] devices);

    DataWrapper<Void> turnPump(String deviceId, String number, String pumpStatus);


}
