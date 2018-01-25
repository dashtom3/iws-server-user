package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.PointFieldEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/7/7.
 */
@Repository
public interface ModelDao {
    int add(@Param("fieldId")String fieldId,@Param("modelNum") int modelNum);

    int delete(int termId);

    int getTermByField(String fieldId);

    PointFieldEntity detail(int fieldId);

    List<PointFieldEntity> list(int termId);
}
