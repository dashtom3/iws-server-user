package com.xj.iws.http.mvc.controller.manager;

import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.NewsEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.service.LimitationService;
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
@RequestMapping("api/news")
public class NewsController {
    @Autowired
    NewsService newsService;
    @Autowired
    LimitationService limitationService;

    @RequestMapping(value = "confirm", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> confirm(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "userId", required = true) int userId,
            @RequestParam(value = "newsId", required = true) int newsId
    ) {
        return newsService.confirm(newsId, userId);
    }

    @RequestMapping(value = "sendMassage", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> sendMassage(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "userId", required = true) int userId,
            @RequestParam(value = "newsId", required = true) int newsId
    ) {
        return newsService.sendMassage(newsId, userId);
    }
}
