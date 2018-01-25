package com.xj.iws.http.mvc.dao;


import com.xj.iws.http.mvc.entity.DeviceEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupEntity;
import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/4/19.
 */
@Repository
public interface DeviceDao {

    int addGroup(DeviceGroupEntity groupEntity);

    int addDevice(@Param("device") DeviceGroupEntity groupEntity, @Param("terms") DeviceEntity[] deviceEntities);

    int updateGroup(DeviceEntity deviceEntity);

    int deleteDevice(int groupId);

    int deleteGroup(int groupId);

    List<DeviceGroupEntity> groupList(int roomId);

    DeviceGroupEntity groupDetail(int groupId);

    List<DeviceEntity> deviceList(int groupId);

    DeviceEntity deviceDetail(int deviceId);

    int createDataTable(@Param("IP") String IP,@Param("port") String port,@Param("device") DeviceEntity device);

    int dropDataTable(@Param("IP") String IP,@Param("port") String port,@Param("device") DeviceEntity device);

    String getPort(int deiceId);

    String getNumber(int deviceId);

    int runGroup(@Param("groupId") String groupId,@Param("status") int i);

    int runDevice(@Param("groupId") String groupId,@Param("status") int i);

    int checkDevice(String port);
}
