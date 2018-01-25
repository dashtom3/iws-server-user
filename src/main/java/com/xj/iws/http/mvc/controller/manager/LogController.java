package com.xj.iws.http.mvc.controller.manager;

import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.LogEntity;
import com.xj.iws.http.mvc.entity.NewsEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.service.LimitationService;
import com.xj.iws.http.mvc.service.LogService;
import com.xj.iws.http.mvc.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理全部消息请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/log")
public class LogController {
    @Autowired
    LogService logService;
    @Autowired
    LimitationService limitationService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<LogEntity>> list(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "startTime", required = false) String startTime,
            @RequestParam(value = "endTime", required = false) String endTime,
            @RequestParam(value = "type", required = false) String type
    ) {
        Map<String, String> condition = new HashMap<String, String>();
        condition.put("startTime", startTime);
        condition.put("endTime", startTime);
        condition.put("type", type);
        return logService.list(condition);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "logId", required = true) int[] logId

    ) {
        return logService.delete(logId);
    }
}
