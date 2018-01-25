package com.xj.iws.http.mvc.dao;

import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.DataEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by Jo on 2017/4/6.
 */
@Repository
public interface DataDao {
    List<DataEntity> query(Map<String, String> condition);

    List<Map<String,String>> pumpStatus(@Param("deviceId") int deviceId, @Param("tableName")String tableName);

    int getCount(Map<String, String> condition);

    String getStartIdByTime(Map<String,String> condition);

    String getEndIdByTime(Map<String,String> condition);

    DataEntity getTCPPresentData(@Param("tableName")String tableName,@Param("deviceId")Integer deviceId);
}
