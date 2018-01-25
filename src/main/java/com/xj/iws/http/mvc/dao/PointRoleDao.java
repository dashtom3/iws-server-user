package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.PointRoleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/27.
 */
@Repository
public interface PointRoleDao {

    List<PointRoleEntity> list();

    List<Map<String,String>> getStatus(int i);
}
