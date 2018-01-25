package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.PointFieldEntity;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/7/7.
 */
public interface ModelService {
    DataWrapper<Void> add(String fieldId);

    DataWrapper<Void> delete(int termId);

    DataWrapper<Void> update(String fieldId);

    DataWrapper<PointFieldEntity> detail(int termId);

    DataWrapper<List<PointFieldEntity>> list(int termId);
}
