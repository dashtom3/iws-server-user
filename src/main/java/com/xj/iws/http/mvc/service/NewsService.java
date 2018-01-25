package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.NewsEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/4/7.
 */
public interface NewsService {
    DataWrapper<List<NewsEntity>> list(Map<String,String> condition,Page page);


    DataWrapper<Void> confirm(int newsId, int userId);

    DataWrapper<Void> sendMassage(int newsId, int userId);
}
