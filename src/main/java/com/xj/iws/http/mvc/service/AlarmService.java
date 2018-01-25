package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.AlarmEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/4/11.
 */
public interface AlarmService {
    DataWrapper<List<AlarmEntity>> list(List<Limitation> limit,Map<String, String> condition, Page page);

}
