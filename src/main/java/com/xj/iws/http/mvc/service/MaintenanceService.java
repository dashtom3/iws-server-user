package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.Maintenance;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Administrator on 2017/12/14.
 */
public interface MaintenanceService {
    DataWrapper<Void> add(Maintenance maintenance,String time,Integer locationId,Integer userId) ;

    DataWrapper<List<Maintenance>> list(Integer userId,Integer locationId,Integer systemId,String startTime,String endTime,Integer currentPage,Integer numberPerPage);

    DataWrapper<Void> delete(Integer maintenanceId);

    DataWrapper<Maintenance> update(Maintenance maintenance,Integer userId,Integer locationId,String time);
}
