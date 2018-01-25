package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.utils.PackageUtil;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.dao.*;
import com.xj.iws.http.mvc.entity.*;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.http.mvc.entity.util.Limitation;
import com.xj.iws.http.mvc.service.LocationService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationDao locationDao;
    @Autowired
    SystemDao systemDao;
    @Autowired
    RoomDao roomDao;
    @Autowired
    DeviceDao deviceDao;
    @Autowired
    AreaDao areaDao;

    @Override
    public DataWrapper<LocationEntity> add(LocationEntity locationEntity) {

        DataWrapper<LocationEntity> dataWrapper = new DataWrapper<LocationEntity>();
        int i = locationDao.add(locationEntity);
        dataWrapper.setData(locationEntity);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(int locationId) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        int sign = locationDao.delete(locationId);

        if (sign != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> update(LocationEntity locationEntity) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        int sign = locationDao.update(locationEntity);

        if (sign != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<LocationEntity> detail(int locationId) {

        DataWrapper<LocationEntity> dataWrapper = new DataWrapper<LocationEntity>();

        //获取地点
        LocationEntity location = locationDao.detail(locationId);
        //获取地点所属系统
        SystemEntity system = systemDao.detail(location.getSystemId());
        //获取地点下所有泵房
        List<RoomEntity> rooms = roomDao.list(locationId);
        //获取泵房内全部控制器组
        for (RoomEntity room : rooms) {
            List<DeviceGroupEntity> groups = deviceDao.groupList(room.getId());
            room.setDeviceGroups(groups);
        }

        location.setSystem(system);
        location.setRoom(rooms);
        if (location == null) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else {
            dataWrapper.setData(location);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<LocationEntity>> list(int id, List<Limitation> limitations, Page page) {
        DataWrapper<List<LocationEntity>> dataWrapper = new DataWrapper<List<LocationEntity>>();
        List<LocationEntity> locations = locationDao.list(id,limitations,page);
        List<SystemEntity> systems = systemDao.list(limitations);

        int totalNumber = locationDao.getListCount(id,limitations);
        dataWrapper.setPage(page,totalNumber);

        dataWrapper.setData(PackageUtil.locationSetSystem(locations, systems));
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<LocationEntity>> query(Map<String, String> condition, List<Limitation> limitations, Page page) {
        DataWrapper<List<LocationEntity>> dataWrapper = new DataWrapper<List<LocationEntity>>();
        List<LocationEntity> locations = locationDao.query(condition,limitations,page);
        int totalNumber = locationDao.getCount(condition);
        dataWrapper.setPage(page,totalNumber);
        dataWrapper.setData(locations);
        return dataWrapper;
    }


}
