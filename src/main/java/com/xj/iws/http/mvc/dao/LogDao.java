package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.LogEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/4/26.
 */
@Repository
public interface LogDao {
    List<LogEntity> list(Map<String, String> condition);

    int addHandle(LogEntity log);

    int delete(int[] logId);
}
