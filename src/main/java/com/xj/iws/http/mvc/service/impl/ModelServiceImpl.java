package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.dao.ModelDao;
import com.xj.iws.http.mvc.entity.PointFieldEntity;
import com.xj.iws.http.mvc.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/7/7.
 */
@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    ModelDao modelDao;

    @Override
    public DataWrapper<Void> add(String fieldId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        String[] fieldArray = fieldId.split(",");
        for (int i = 0; i < fieldArray.length; i++) {
            modelDao.add(fieldArray[i], i + 1);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(int termId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = modelDao.delete(termId);
        if (i == -1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> update(String fieldId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        String[] fieldArray = fieldId.split(",");
        int termId = modelDao.getTermByField(fieldArray[0]);
        modelDao.delete(termId);
        for (int i = 0; i < fieldArray.length; i++) {
            modelDao.add(fieldArray[i], i + 1);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<PointFieldEntity> detail(int fieldId) {
        DataWrapper<PointFieldEntity> dataWrapper = new DataWrapper<PointFieldEntity>();
        PointFieldEntity field = modelDao.detail(fieldId);
        dataWrapper.setData(field);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<PointFieldEntity>> list(int termId) {
        DataWrapper<List<PointFieldEntity>> dataWrapper = new DataWrapper<List<PointFieldEntity>>();
        List<PointFieldEntity> fields = modelDao.list(termId);
        dataWrapper.setData(fields);
        return dataWrapper;
    }
}
