package com.xj.iws.http.mvc.service.impl;

import com.sun.tools.javac.comp.Todo;
import com.xj.iws.common.communication.ServerRequest;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.utils.Page;
import com.xj.iws.common.utils.ParamUtil;
import com.xj.iws.http.mvc.dao.DeviceDao;
import com.xj.iws.http.mvc.dao.DeviceInfoDao;
import com.xj.iws.http.mvc.dao.DeviceTermDao;
import com.xj.iws.http.mvc.entity.*;
import com.xj.iws.http.mvc.service.DeviceService;
import com.xj.iws.common.utils.DataWrapper;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/14.
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceInfoDao deviceInfoDao;
    @Autowired
    DeviceTermDao deviceTermDao;


    @Override
    public DataWrapper<DeviceGroupInfoEntity> addGroup(DeviceGroupInfoEntity deviceGroup) {
        DataWrapper<DeviceGroupInfoEntity> dataWrapper = new DataWrapper<DeviceGroupInfoEntity>();
        int i = deviceInfoDao.addGroup(deviceGroup);
        if (i == -1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else {
            dataWrapper.setData(deviceGroup);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(int deviceGroupId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int j = deviceInfoDao.deleteGroup(deviceGroupId);

        if (j != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<DeviceEntity> update(DeviceGroupInfoEntity deviceGroup) {
        DataWrapper<DeviceEntity> dataWrapper = new DataWrapper<DeviceEntity>();
        int i = deviceInfoDao.updateGroup(deviceGroup);

        if (i != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<DeviceGroupInfoEntity>> groupList(Page page) {
        DataWrapper<List<DeviceGroupInfoEntity>> dataWrapper = new DataWrapper<List<DeviceGroupInfoEntity>>();
        List<DeviceGroupInfoEntity> deviceGroups = deviceInfoDao.deviceGroupList(page);
        for (DeviceGroupInfoEntity group : deviceGroups) {
            String[] terms = group.getTerms().split(",");
            List<DeviceTermEntity> deviceTerms = deviceTermDao.deviceTermByIds(terms);
            group.setDeviceTerms(deviceTerms);
        }
        int totalNumber = deviceInfoDao.getCount();
        dataWrapper.setPage(page, totalNumber);
        dataWrapper.setData(deviceGroups);
        return dataWrapper;
    }

    @Override
    public DataWrapper<DeviceGroupInfoEntity> groupDetail(int groupId) {
        DataWrapper<DeviceGroupInfoEntity> dataWrapper = new DataWrapper<DeviceGroupInfoEntity>();
        DeviceGroupInfoEntity group = deviceInfoDao.groupDetail(groupId);
        String[] terms = group.getTerms().split(",");
        List<DeviceTermEntity> deviceTerms = deviceTermDao.deviceTermByIds(terms);
        group.setDeviceTerms(deviceTerms);
        dataWrapper.setData(group);
        return dataWrapper;
    }


    @Override
    public DataWrapper<List<DeviceGroupTypeEntity>> groupType() {
        DataWrapper<List<DeviceGroupTypeEntity>> dataWrapper = new DataWrapper<List<DeviceGroupTypeEntity>>();
        List<DeviceGroupTypeEntity> groupTypes = deviceInfoDao.groupTypes();
        dataWrapper.setData(groupTypes);
        return dataWrapper;
    }

}
