package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.LogEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/4/26.
 */
public interface LogService {
    DataWrapper<List<LogEntity>> list(Map<String, String> condition);

    DataWrapper<Void> delete(int[] logId);
}
