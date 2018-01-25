package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.dao.HikVisionDao;
import com.xj.iws.http.mvc.entity.HikVisionEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;
import com.xj.iws.http.mvc.service.HikVisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/5/27.
 */
@Service
public class HikVisionServiceImpl implements HikVisionService {

    @Autowired
    HikVisionDao hikVisionDao;

    @Override
    public DataWrapper<Void> add(HikVisionEntity hikVision) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = hikVisionDao.add(hikVision);
        if (i != 1){
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(int id) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = hikVisionDao.delete(id);
        if (i != 1){
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> update(HikVisionEntity hikVision) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = hikVisionDao.update(hikVision);
        if (i != 1){
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<HikVisionEntity> detail(int id) {
        DataWrapper<HikVisionEntity> dataWrapper = new DataWrapper<HikVisionEntity>();
        HikVisionEntity hikVision = hikVisionDao.detail(id);
        dataWrapper.setData(hikVision);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<HikVisionEntity>> list(int userId,Page page) {
        DataWrapper<List<HikVisionEntity>> dataWrapper = new DataWrapper<List<HikVisionEntity>>();
        List<HikVisionEntity> hikVisions = hikVisionDao.list(userId,page);
        int totalNumber = hikVisionDao.getListCount(userId);
        page.setTotalNumber(totalNumber);
        dataWrapper.setData(hikVisions);
        dataWrapper.setPage(page,totalNumber);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<HikVisionEntity>> query(Map<String, String> condition, Page page) {
        DataWrapper<List<HikVisionEntity>> dataWrapper = new DataWrapper<List<HikVisionEntity>>();
        List<HikVisionEntity> hikVisions = hikVisionDao.query(condition,page);
        int totalNumber = hikVisionDao.getCount(condition);
        dataWrapper.setPage(page,totalNumber);
        dataWrapper.setData(hikVisions);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> addHikToUser(int userId, String hikId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = hikVisionDao.addHikToUser(userId,hikId);
        if (i != 1){
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> deleteHikFormUser(int userId, String hikId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = hikVisionDao.deleteHikFormUser(userId,hikId);
        if (i != 1){
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

}
