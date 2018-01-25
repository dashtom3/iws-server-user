package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.DeviceTypeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
@Repository
public interface DeviceTypeDao {
    List<DeviceTypeEntity> list();

    int update(DeviceTypeEntity deviceTypeEntity);
}
