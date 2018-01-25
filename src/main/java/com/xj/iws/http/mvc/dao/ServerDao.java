package com.xj.iws.http.mvc.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by XiaoJiang01 on 2017/4/18.
 */
@Repository
public interface ServerDao {
    String getIP();

    String getServerPort();
}
