package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.HikVisionEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/5/27.
 */
public interface HikVisionService {
    DataWrapper<Void> add(HikVisionEntity hikVision);

    DataWrapper<Void> delete(int id);

    DataWrapper<Void> update(HikVisionEntity hikVision);

    DataWrapper<HikVisionEntity> detail(int id);


    DataWrapper<List<HikVisionEntity>> query(Map<String, String> condition, Page page);

    DataWrapper<Void> addHikToUser(int userId, String hikId);

    DataWrapper<List<HikVisionEntity>> list(int userId, Page page);

    DataWrapper<Void> deleteHikFormUser(int userId, String hikId);
}
