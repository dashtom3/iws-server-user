package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.utils.PackageUtil;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.dao.LocationDao;
import com.xj.iws.http.mvc.dao.SystemDao;
import com.xj.iws.http.mvc.entity.LocationEntity;
import com.xj.iws.http.mvc.entity.SystemEntity;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.http.mvc.entity.util.Limitation;
import com.xj.iws.http.mvc.service.SystemService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by XiaoJiang01 on 2017/2/24.
 */

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    SystemDao systemDao;
    @Autowired
    LocationDao locationDao;

    /**
     * 添加系统
     *
     * @param system
     * @return
     */
    @Override
    public DataWrapper<Void> add(SystemEntity system) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        system.setStrdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());
        int sign = systemDao.add(system);
        if (sign != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    /**
     * 删除系统
     *
     * @param systemId
     * @return
     */
    @Override
    public DataWrapper<Void> delete(int systemId) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int sign = systemDao.delete(systemId);
        //删除地点
        //删除泵房
        //删除设备组
        //删除设备
        if (sign != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    /**
     * 编辑系统
     *
     * @param system
     * @return
     */
    @Override
    public DataWrapper<Void> update(SystemEntity system) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        int sign = systemDao.update(system);
        if (sign != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    /**
     * 获取系统列表
     *
     * @return
     */
    @Override
    public DataWrapper<List<SystemEntity>> list(List<Limitation> limitations) {

        DataWrapper<List<SystemEntity>> dataWrapper = new DataWrapper<List<SystemEntity>>();
        //获取全部系统
        List<SystemEntity> systems = systemDao.list(limitations);
        //获取系统下全部地点
        for (SystemEntity system : systems) {
            List<LocationEntity> locations = locationDao.list(system.getId(),limitations,new Page());
            system.setLocation(locations);
        }
        dataWrapper.setData(systems);
        return dataWrapper;
    }

    /**
     * 获取系统详情
     *
     * @param systemId
     * @return
     */
    @Override
    public DataWrapper<SystemEntity> detail(int systemId,List<Limitation> limitations) {

        DataWrapper<SystemEntity> dataWrapper = new DataWrapper<SystemEntity>();

        //获取系统
        SystemEntity system = systemDao.detail(systemId);
        //获取系统下全部地点
        List<LocationEntity> locations = locationDao.list(systemId,limitations,new Page());
        system.setLocation(locations);
        dataWrapper.setData(system);
        return dataWrapper;
    }

    /**
     * 获取系统列表
     *
     * @return
     */
    @Override
    public DataWrapper<List<SystemEntity>> listPack(List<Limitation> limitations) {

        DataWrapper<List<SystemEntity>> dataWrapper = new DataWrapper<List<SystemEntity>>();
        //获取全部系统
        List<SystemEntity> systems = systemDao.list(limitations);
        //获取系统下全部地点
        for (SystemEntity system : systems) {
            List<LocationEntity> locations = locationDao.list(system.getId(),limitations,new Page());
            system.setLocationPack(PackageUtil.locationPack(locations));
        }
        dataWrapper.setData(systems);
        return dataWrapper;
    }

    /**
     * 获取系统详情
     *
     * @param systemId
     * @return
     */
    @Override
    public DataWrapper<SystemEntity> detailPack(int systemId,List<Limitation> limitations) {

        DataWrapper<SystemEntity> dataWrapper = new DataWrapper<SystemEntity>();

        //获取系统
        SystemEntity system = systemDao.detail(systemId);
        //获取系统下全部地点
        List<LocationEntity> locations = locationDao.list(systemId,limitations,new Page());

        system.setLocationPack(PackageUtil.locationPack(locations));
        dataWrapper.setData(system);

        return dataWrapper;
    }

    @Override
    public DataWrapper<List<String>> pic() {
        DataWrapper<List<String>> dataWrapper = new DataWrapper<List<String>>();
        List<String> pics = systemDao.pic();
        if (pics == null) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else {
            dataWrapper.setData(pics);
        }
        return dataWrapper;
    }
}
