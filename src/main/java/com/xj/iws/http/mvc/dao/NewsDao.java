package com.xj.iws.http.mvc.dao;

import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.NewsEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/4/11.
 */
@Repository
public interface NewsDao {

    List<NewsEntity> list(@Param("condition") Map<String,String> condition, @Param("page")Page page);

    int confirm(@Param("newsId") int newsId,@Param("userId") int userId);

    int getCount(@Param("condition") Map<String,String> condition);

    NewsEntity detail(int newsId);
}
