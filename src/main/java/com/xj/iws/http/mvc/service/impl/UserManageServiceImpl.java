package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.dao.UserManageDao;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/15.
 */
@Service
public class UserManageServiceImpl implements UserManageService {

    @Autowired
    UserManageDao userManageDao;

    @Override
    public DataWrapper<List<UserEntity>> list(Page page) {
        DataWrapper<List<UserEntity>> dataWrapper = new DataWrapper<List<UserEntity>>();
        List<UserEntity> users = userManageDao.list(page);
        int totalNumber = userManageDao.getCount();
        dataWrapper.setPage(page,totalNumber);
        dataWrapper.setData(users);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> role(UserEntity userEntity) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        int i = userManageDao.role(userEntity);
        if (i != 1){
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> status(UserEntity userEntity) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        int i = userManageDao.status(userEntity);
        if (i != 1){
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<UserEntity> detail(int userId) {
        DataWrapper<UserEntity> dataWrapper = new DataWrapper<UserEntity>();
        UserEntity user = userManageDao.detail(userId);
        dataWrapper.setData(user);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<UserEntity>> query(Map condition) {
        DataWrapper<List<UserEntity>> dataWrapper = new DataWrapper<List<UserEntity>>();
        List<UserEntity> users = userManageDao.query(condition);
        dataWrapper.setData(users);
        return dataWrapper;
    }
}
