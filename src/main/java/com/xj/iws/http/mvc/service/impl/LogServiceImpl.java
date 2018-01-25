package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.dao.LogDao;
import com.xj.iws.http.mvc.entity.LogEntity;
import com.xj.iws.http.mvc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/4/26.
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogDao logDao;

    @Override
    public DataWrapper<List<LogEntity>> list(Map<String, String> condition) {
        DataWrapper<List<LogEntity>> dataWrapper = new DataWrapper<List<LogEntity>>();
        List<LogEntity> logs = logDao.list(condition);
        dataWrapper.setData(logs);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(int[] logId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = logDao.delete(logId);
        return dataWrapper;
    }
}
