package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.SystemEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/6.
 */
@Repository
public interface SystemDao {

    int add(SystemEntity system);

    int delete(int systemId);

    int update(SystemEntity system);

    List<SystemEntity> list(List<Limitation> limitations);

    SystemEntity detail(int systemId);

    List<String> pic();
}
