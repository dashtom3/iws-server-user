package com.xj.iws.http.mvc.dao;

import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.Maintenance;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/12/14.
 */
public interface MaintenanceDao {
    int addMaintenance(@Param("maintenance")Maintenance maintenance,@Param("id") Integer id,@Param("time") String time,@Param("locationId")Integer locationId,@Param("nextTime")Date date);

    List<Maintenance> list(@Param("userId")Integer userId,@Param("locationId") Integer locationId,@Param("systemId") Integer systemId,@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("page")Page page);

    Integer getTotalNumber(@Param("userId")Integer userId,@Param("locationId") Integer locationId,@Param("systemId") Integer systemId,@Param("startTime") String startTime,@Param("endTime") String endTime);

    int delete(Integer maintenanceId);

    int update(@Param("maintenance")Maintenance maintenance,@Param("userId")Integer userId,@Param("locationId")Integer locationId,@Param("date")Date date);
}
