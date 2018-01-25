package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
@Repository
public interface UserDao {

    UserEntity getUserByUsername(String username);

    UserEntity getUserById(int id);

    int updateUser(UserEntity user);

    int updatePwd(UserEntity user);

    int register(UserEntity newUser);

    List<UserEntity> getUsersByRole(int roleId);
}
