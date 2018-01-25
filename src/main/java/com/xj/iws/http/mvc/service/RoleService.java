package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.RoleEntity;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.RoleSubEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/10.
 */
public interface RoleService {

    DataWrapper<RoleEntity> add(RoleEntity roleEntity, RoleSubEntity[] subitem);

    DataWrapper<Void> delete(int roleId);

//    DataWrapper<Void> addSub(int roleId, RoleSubEntity subitem);

//    DataWrapper<Void> deleteSub(int subId);

    DataWrapper<RoleEntity> update(RoleEntity roleEntity,RoleSubEntity[] subitem);

    DataWrapper<List<RoleEntity>> list(int except,Page page);

    DataWrapper<RoleEntity> detail(int roleId);

    DataWrapper<List<RoleEntity>> query(Map<String, String> condition);
}
