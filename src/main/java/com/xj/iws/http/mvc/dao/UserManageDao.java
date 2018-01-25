package com.xj.iws.http.mvc.dao;

import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
@Repository
public interface UserManageDao {
    List<UserEntity> query(Map condition);

    int role(UserEntity userEntity);

    List<UserEntity> list(Page page);

    int status(UserEntity userEntity);

    UserEntity detail(int userId);

    int getCount();
}
