package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.util.DataField;
import com.xj.iws.http.mvc.entity.util.ViewDataEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/31.
 */
public interface DataService {

    DataWrapper<List<ViewDataEntity>> query(Map<String, String> condition,Page page);

    DataWrapper<ViewDataEntity> presentData(int deviceId);

    DataWrapper<List<DataField>> pumpStatus(int deviceId);

    DataWrapper<ViewDataEntity> pointData(String termId,String port,String number);

    DataWrapper<List<ViewDataEntity>> dataAtPresentDate(Map<String, String> conditions, Page page);

    DataWrapper<ViewDataEntity> modelData(int deviceId);
}
