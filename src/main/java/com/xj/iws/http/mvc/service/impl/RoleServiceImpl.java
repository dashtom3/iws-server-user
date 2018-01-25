package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.dao.AreaDao;
import com.xj.iws.http.mvc.dao.RoleDao;
import com.xj.iws.http.mvc.entity.RoleEntity;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.http.mvc.entity.RoleSubEntity;
import com.xj.iws.http.mvc.service.RoleService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by XiaoJiang01 on 2017/3/10.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;
    @Autowired
    AreaDao areaDao;

    @Override
    public DataWrapper<RoleEntity> add(RoleEntity roleEntity, RoleSubEntity[] subitem) {
        DataWrapper<RoleEntity> dataWrapper = new DataWrapper<RoleEntity>();

        int i = roleDao.addRole(roleEntity);
        // TODO: 2017/6/26  事务管理测试
//        if (i == 1) {
//            return null;
//        }
        int j = roleDao.addSub(roleEntity.getId(), subitem);
        if (i != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else {
            dataWrapper = detail(roleEntity.getId());
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(int roleId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        if (roleId == 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
            return dataWrapper;
        }
        int i = roleDao.deleteSub(roleId, 0);
        int j = roleDao.delete(roleId);
        if (j != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

//    @Override
//    public DataWrapper<Void> addSub(int roleId, RoleSubEntity subitem) {
//        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
//        RoleSubEntity[] subitems = new RoleSubEntity[1];
//        subitems[0] = subitem;
//        int i = roleDao.addSub(roleId, subitems);
//        if (i != 1) {
//            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
//        }
//        return dataWrapper;
//    }

//    @Override
//    public DataWrapper<Void> deleteSub(int id) {
//        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
//        int i = roleDao.deleteSub(0, id);
//        if (i != 1) {
//            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
//        }
//        return dataWrapper;
//    }

    @Override
    public DataWrapper<RoleEntity> update(RoleEntity roleEntity, RoleSubEntity[] subitem) {
        DataWrapper<RoleEntity> dataWrapper = new DataWrapper<RoleEntity>();
        int id = roleEntity.getId();
        if (id == 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
            return dataWrapper;
        }
        int i = roleDao.update(roleEntity);
        int j = roleDao.deleteSub(id, 0);
        int k = roleDao.addSub(id, subitem);

        if (i != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else {
            dataWrapper = detail(roleEntity.getId());
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<RoleEntity>> list(int except, Page page) {
        DataWrapper<List<RoleEntity>> dataWrapper = new DataWrapper<List<RoleEntity>>();
        List<RoleEntity> roles = roleDao.list(except, page);
        for (RoleEntity role : roles) {
            List<RoleSubEntity> roleSubs = roleDao.getSub(role.getId());
            role.setSubitem(roleSubs);
        }
        int totalNumber = roleDao.getCount(except);
        dataWrapper.setPage(page, totalNumber);
        dataWrapper.setData(roles);
        return dataWrapper;
    }

    @Override
    public DataWrapper<RoleEntity> detail(int roleId) {
        DataWrapper<RoleEntity> dataWrapper = new DataWrapper<RoleEntity>();
        RoleEntity role = roleDao.detail(roleId);
        List<RoleSubEntity> roleSubs = roleDao.getSub(roleId);
        role.setSubitem(roleSubs);
        dataWrapper.setData(role);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<RoleEntity>> query(Map<String, String> condition) {
        DataWrapper<List<RoleEntity>> dataWrapper = new DataWrapper<List<RoleEntity>>();
        List<RoleEntity> roles = roleDao.query(condition);
        //遍历roleId获取其名称和系统、地区、权限
        for (RoleEntity role : roles) {
            role.setSubitem(roleDao.getSub(role.getId()));
        }
        if (roles == null) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else {
            dataWrapper.setData(roles);
        }
        return dataWrapper;
    }
}
