package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/15.
 */
public interface UserManageService {

    DataWrapper<List<UserEntity>> list(Page page);

    DataWrapper<Void> role(UserEntity user);

    DataWrapper<List<UserEntity>> query(Map condition);

    DataWrapper<Void> status(UserEntity userEntity);

    DataWrapper<UserEntity> detail(int userId);
}
