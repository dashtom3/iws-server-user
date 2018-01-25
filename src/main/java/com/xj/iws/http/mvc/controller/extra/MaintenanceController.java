package com.xj.iws.http.mvc.controller.extra;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.Maintenance;
import com.xj.iws.http.mvc.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Administrator on 2017/12/14.
 */
@Controller
@RequestMapping("api/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;


    /**
     * 添加保养信息
     */
    @RequestMapping(value="add",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> add(
            @ModelAttribute Maintenance maintenance,
            @RequestParam(value="time") String time,
            @RequestParam("locationId") Integer locationId,
            @RequestParam("userId") Integer userId
    ) {
        return maintenanceService.add(maintenance,time,locationId,userId);
    }

    /**
     * 显示保养列表
     */
    @RequestMapping(value="list",method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<Maintenance>> list(
        @RequestParam(value="userId",required = false)Integer userId,
        @RequestParam(value="locationId",required = false)Integer locationId,
        @RequestParam(value="systemId",required = false)Integer systemId,
        @RequestParam(value="startTime",required = false) String startTime,
        @RequestParam(value="endTime",required = false) String endTime,
        @RequestParam(value="currentPage",required = false,defaultValue = "1") Integer currentPage,
        @RequestParam(value="numberPerPage",required = false,defaultValue = "10")Integer numberPerPage
    ){
        return maintenanceService.list(userId,locationId,systemId,startTime,endTime,currentPage,numberPerPage);
    }

    /**
     * 删除保养列表
     */
    @RequestMapping(value="delete",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value="maintenanceId",required = true) Integer maintenanceId
    ){
        return maintenanceService.delete(maintenanceId);
    }

    /**
     * 修改保养列表
     */
    @RequestMapping(value="update",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Maintenance> update(
            @RequestParam(value="userId",required = false) Integer userId,
            @RequestParam(value="locationId",required = false)Integer locationId,
            @RequestParam(value="time",required = false) String time,
            @ModelAttribute Maintenance maintenance
    ){
        return maintenanceService.update(maintenance,userId,locationId,time);
    }
}
