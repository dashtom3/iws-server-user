package com.xj.iws.http.mvc.dao;

import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
@Repository
public interface DeviceInfoDao {

    List<DeviceGroupInfoEntity> deviceGroupList(Page page);

    DeviceGroupInfoEntity groupDetail(int groupId);

    int addGroup(DeviceGroupInfoEntity deviceGroup);

    int deleteGroup(int deviceGroupId);

    int updateGroup(DeviceGroupInfoEntity deviceGroup);

    List<DeviceGroupTypeEntity> groupTypes();

    int getCount();
}
