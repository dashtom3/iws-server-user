package com.xj.iws.http.mvc.controller.user;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.AlarmEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;
import com.xj.iws.http.mvc.service.AlarmService;
import com.xj.iws.http.mvc.service.LimitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理全部数据请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/alarm")
public class AlarmController {

    @Autowired
    AlarmService alarmService;
    @Autowired
    LimitationService limitationService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<AlarmEntity>> list(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "systemId", required = false) String systemId,
            @RequestParam(value = "provinceId", required = false) String provinceId,
            @RequestParam(value = "cityId", required = false) String cityId,
            @RequestParam(value = "areaId", required = false) String areaId,
            @RequestParam(value = "locationId", required = false) String locationId,
            @RequestParam(value = "roomId", required = false) String roomId,
            @RequestParam(value = "groupId", required = false) String groupId,
            @RequestParam(value = "deviceId", required = false) String deviceId,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "startTime", required = false) String startTime,
            @RequestParam(value = "endTime", required = false) String endTime,
            @ModelAttribute Page page
            ) {
        UserEntity user = SessionManager.getSession(token);
        List<Limitation> limit =null;
        if(user!=null){
            limit=limitationService.getLimit(user);
        }
        Map<String, String> condition = new HashMap<String, String>();
        condition.put("systemId", systemId);
        condition.put("provinceId", provinceId);
        condition.put("cityId", cityId);
        condition.put("areaId", areaId);
        condition.put("locationId", locationId);
        condition.put("roomId", roomId);
        condition.put("groupId", groupId);
        condition.put("deviceId", deviceId);
        condition.put("status", status);
        condition.put("startTime", startTime);
        condition.put("endTime", endTime);
        return alarmService.list(limit,condition,page);
    }
}
