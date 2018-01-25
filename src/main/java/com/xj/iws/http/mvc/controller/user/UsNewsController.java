package com.xj.iws.http.mvc.controller.user;

import com.xj.iws.common.data.DataProcess;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.NewsEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.service.LimitationService;
import com.xj.iws.http.mvc.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理全部消息请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/news")
public class UsNewsController {
    @Autowired
    NewsService newsService;
    @Autowired
    LimitationService limitationService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<NewsEntity>> list(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "startTime", required = false) String startTime,
            @RequestParam(value = "endTime", required = false) String endTime,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "systemId", required = false) String systemId,
            @RequestParam(value = "describes", required = false) String describes,
            @ModelAttribute Page page
    ) {
        UserEntity user = SessionManager.getSession(token);
        Map<String, String> condition = new HashMap<String, String>();
        if (!limitationService.checkAdmin(user)) {
            condition.put("userId", String.valueOf(user.getId()));
        }
        condition.put("startTime", startTime);
        condition.put("endTime", endTime);
        condition.put("status", status);
        condition.put("systemId", systemId);
        condition.put("describes", describes);
        return newsService.list(condition,page);
    }

}
