package com.xj.iws.http.mvc.service;

import com.xj.iws.http.mvc.entity.SystemEntity;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.util.Limitation;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/2/24.
 */
public interface SystemService {

    DataWrapper<Void> add(SystemEntity systemEntity);

    DataWrapper<Void> delete(int systemId);

    DataWrapper<Void> update(SystemEntity system);

    DataWrapper<List<SystemEntity>> list(List<Limitation> limitations);

    DataWrapper<SystemEntity> detail(int systemId,List<Limitation> limitations);

    DataWrapper<List<String>> pic();

    DataWrapper<List<SystemEntity>> listPack(List<Limitation> limitations);

    DataWrapper<SystemEntity> detailPack(int systemId,List<Limitation> limitations);
}
