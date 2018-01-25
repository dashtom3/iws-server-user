package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.LocationEntity;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.util.Limitation;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
public interface LocationService {

    DataWrapper<LocationEntity> add(LocationEntity locationEntity);

    DataWrapper<Void> delete(int locationId);

    DataWrapper<Void> update(LocationEntity locationEntity);

    DataWrapper<LocationEntity> detail(int locationId);

    DataWrapper<List<LocationEntity>> list(int id, List<Limitation> limitations, Page page);

    DataWrapper<List<LocationEntity>> query(Map<String, String> condition, List<Limitation> limitations, Page page);
}
