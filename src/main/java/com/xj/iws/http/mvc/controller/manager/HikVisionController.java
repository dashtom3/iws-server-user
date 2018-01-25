package com.xj.iws.http.mvc.controller.manager;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.dao.UserDao;
import com.xj.iws.http.mvc.entity.HikVisionEntity;
import com.xj.iws.http.mvc.entity.SystemEntity;
import com.xj.iws.http.mvc.service.HikVisionService;
import com.xj.iws.http.mvc.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理全部系统请求
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/hikvision")
public class HikVisionController {

    @Autowired
    HikVisionService hikVisionService;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> add(
            @RequestParam("token") String token,
            @ModelAttribute HikVisionEntity hikVision
    ){
        return hikVisionService.add(hikVision);
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam("token") String token,
            @RequestParam("id") int id
    ){
        return hikVisionService.delete(id);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> update(
            @RequestParam("token") String token,
            @ModelAttribute HikVisionEntity hikVision
    ){
        return hikVisionService.update(hikVision);
    }


}
