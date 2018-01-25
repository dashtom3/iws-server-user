package com.xj.iws.http.mvc.service.impl;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.sessionManager.VerifyCodeManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.HttpUtil;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.dao.AlarmDao;
import com.xj.iws.http.mvc.dao.NewsDao;
import com.xj.iws.http.mvc.dao.UserDao;
import com.xj.iws.http.mvc.entity.NewsEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.service.AlarmService;
import com.xj.iws.http.mvc.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/4/7.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;
    @Autowired
    UserDao userDao;
    @Autowired
    AlarmDao alarmDao;

    @Override
    public DataWrapper<List<NewsEntity>> list(Map<String, String> condition, Page page) {
        DataWrapper<List<NewsEntity>> dataWrapper = new DataWrapper<List<NewsEntity>>();
        List<NewsEntity> news = newsDao.list(condition, page);
        int totalNumber = newsDao.getCount(condition);
        dataWrapper.setPage(page, totalNumber);
        dataWrapper.setData(news);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> confirm(int newsId, int userId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = newsDao.confirm(newsId, userId);
        int j = alarmDao.confirm(newsDao.detail(newsId).getAlarmId());
        if (i != 1) dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> sendMassage(int newsId, int userId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        NewsEntity news = newsDao.detail(newsId);
        UserEntity user = userDao.getUserById(userId);
        String phone = user.getUsername();
        String massage = news.getDescribes();
        boolean result = HttpUtil.sendMassage(massage, phone);
        if (!result) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }
}
