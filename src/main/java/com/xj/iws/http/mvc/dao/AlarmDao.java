package com.xj.iws.http.mvc.dao;

import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.AlarmEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/4/11.
 */
@Repository
public interface AlarmDao {
    List<AlarmEntity> list(@Param("limit") List<Limitation> limit, @Param("condition") Map<String,String> condition, @Param("page") Page page);

    int getCount(@Param("limit") List<Limitation> limit,@Param("condition") Map<String, String> condition);

    int confirm(int alarmId);
}
