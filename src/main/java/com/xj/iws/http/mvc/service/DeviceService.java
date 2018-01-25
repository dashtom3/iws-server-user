package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.DeviceEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupInfoEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupTypeEntity;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/14.
 */
public interface DeviceService {

    DataWrapper<DeviceGroupInfoEntity> addGroup(DeviceGroupInfoEntity deviceGroup);

    DataWrapper<Void> delete(int deviceGroupId);

    DataWrapper<DeviceEntity> update(DeviceGroupInfoEntity deviceGroup);

    DataWrapper<List<DeviceGroupInfoEntity>> groupList(Page page);

    DataWrapper<DeviceGroupInfoEntity> groupDetail(int groupId);

    DataWrapper<List<DeviceGroupTypeEntity>> groupType();

}
