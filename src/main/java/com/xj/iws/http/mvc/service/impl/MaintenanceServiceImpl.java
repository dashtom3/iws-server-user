package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.dao.MaintenanceDao;
import com.xj.iws.http.mvc.entity.Maintenance;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/12/14.
 */
@Service
public class MaintenanceServiceImpl implements MaintenanceService{
    @Autowired
    private MaintenanceDao maintenanceDao;

    @Override
    public DataWrapper<Void> add(Maintenance maintenance,String time,Integer locationId,Integer userId)  {
        DataWrapper<Void> dataWrapper=new DataWrapper<Void>();
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date=sdf.parse(time);
            Date nextTime=date;
            int i=maintenanceDao.addMaintenance(maintenance,userId,time,locationId,nextTime);
            if(i==0){
                dataWrapper.setErrorCode(ErrorCodeEnum.Error);
                return dataWrapper;
            }
        }catch (Exception e){
            e.printStackTrace();
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<Maintenance>> list(Integer userId,Integer locationId,Integer systemId,String startTime,String endTime,Integer currentPage,Integer numeberPerPage) {
        DataWrapper<List<Maintenance>> dataWrapper=new DataWrapper<List<Maintenance>>();
        Page page=new Page();
        page.setNumberPerPage(numeberPerPage);
        page.setCurrentPage(currentPage);
        Integer totalNumber=maintenanceDao.getTotalNumber(userId,locationId,systemId,startTime,endTime);
        List<Maintenance> maintenanceList= maintenanceDao.list(userId,locationId,systemId,startTime,endTime,page);
        dataWrapper.setData(maintenanceList);
        dataWrapper.setPage(page,totalNumber);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(Integer maintenanceId) {
        DataWrapper<Void> dataWrapper=new DataWrapper<Void>();
        int i=maintenanceDao.delete(maintenanceId);
        if(i==0){
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return null;
    }

    @Override
    public DataWrapper<Maintenance> update(Maintenance maintenance,Integer userId,Integer locationId,String time) {
        DataWrapper<Maintenance> dataWrapper=new DataWrapper<Maintenance>();
        Date datetime=null;
        if(time!=null&&!"".equals(time)){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                datetime=sdf.parse(time);
            } catch (ParseException e) {
                dataWrapper.setErrorCode(ErrorCodeEnum.Error);
                e.printStackTrace();
                return dataWrapper;
            }
        }
        int i=maintenanceDao.update(maintenance,userId,locationId,datetime);
        if(i==0){
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }
}
