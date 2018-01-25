package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.dao.AlarmDao;
import com.xj.iws.http.mvc.entity.AlarmEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;
import com.xj.iws.http.mvc.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/4/11.
 */
@Service
public class AlarmServiceImpl implements AlarmService {
    @Autowired
    AlarmDao alarmDao;

    @Override
    public DataWrapper<List<AlarmEntity>> list(List<Limitation> limit,Map<String, String> condition, Page page) {
        DataWrapper<List<AlarmEntity>> dataWrapper = new DataWrapper<List<AlarmEntity>>();
        List<AlarmEntity> alarms = alarmDao.list(limit,condition,page);
        int totalNumber = alarmDao.getCount(limit,condition);
        dataWrapper.setPage(page,totalNumber);
        dataWrapper.setData(alarms);
        return dataWrapper;
    }
}
