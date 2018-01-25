package com.xj.iws.http.mvc.controller.user;

import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.HikVisionEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;
import com.xj.iws.http.mvc.service.HikVisionService;
import com.xj.iws.http.mvc.service.LimitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("api/hikvision")
public class UsHikVisionController {

    @Autowired
    HikVisionService hikVisionService;
    @Autowired
    LimitationService limitationService;

    @RequestMapping(value = "addHikToUser", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> add(
            @RequestParam("token") String token,
            @RequestParam("hikId") String hikId
    ) {
        UserEntity user = SessionManager.getSession(token);
        int userId = user.getId();
        return hikVisionService.addHikToUser(userId, hikId);
    }

    @RequestMapping(value = "deleteHikFromUser", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam("token") String token,
            @RequestParam("hikId") String hikId
    ) {
        UserEntity user = SessionManager.getSession(token);
        int userId = user.getId();
        return hikVisionService.deleteHikFormUser(userId, hikId);
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<HikVisionEntity> detail(
            @RequestParam("token") String token,
            @RequestParam("id") int id
    ) {
        return hikVisionService.detail(id);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<HikVisionEntity>> list(
            @RequestParam("token") String token,
            @ModelAttribute Page page
    ) {
        UserEntity user = SessionManager.getSession(token);
        int userId = user.getId();
        return hikVisionService.list(userId,page);
    }

    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<HikVisionEntity>> query(
            @RequestParam("token") String token,
            @RequestParam Map<String,String> condition,
            @ModelAttribute Page page
    ) {
        return hikVisionService.query(condition, page);
    }
}
