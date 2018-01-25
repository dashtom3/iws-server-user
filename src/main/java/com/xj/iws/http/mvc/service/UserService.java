package com.xj.iws.http.mvc.service;

import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.common.utils.DataWrapper;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
public interface UserService {

    DataWrapper<Map<String,String>> login(String username, String password, String status);

    DataWrapper<UserEntity> register(UserEntity user, String code);

    DataWrapper<Void> getVerifyCode(String phone);

    DataWrapper<UserEntity> detail(int userId);

    DataWrapper<UserEntity> update(UserEntity user);

    DataWrapper<Void> changePwd(int userId, String oldPwd, String newPwd);

    DataWrapper<Void> forgetPwd(String username, String password, String code);

    DataWrapper<Void> reLogin(String token);

    DataWrapper<List<UserEntity>> getGroupMember(UserEntity user);
}
