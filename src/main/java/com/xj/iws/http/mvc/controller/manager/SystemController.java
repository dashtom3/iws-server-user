package com.xj.iws.http.mvc.controller.manager;

import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.http.mvc.dao.UserDao;
import com.xj.iws.http.mvc.entity.SystemEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.service.SystemService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理全部系统请求
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/system")
public class SystemController {

    @Autowired
    SystemService systemService;
    @Autowired
    UserDao userDao;

    /**
     * 添加系统
     * @param systemEntity
     * @param token
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> add(
            @ModelAttribute SystemEntity systemEntity,
            @RequestParam(value = "token",required = true) String token
    ){
        return systemService.add(systemEntity);
    }

    /**
     * 删除系统
     * @param systemId
     * @param token
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "systemId",required = true) int systemId,
            @RequestParam(value = "token",required = true) String token
    ){
        return systemService.delete(systemId);
    }

    /**
     * 编辑系统
     * @param systemEntity
     * @param token
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> update(
            @ModelAttribute SystemEntity systemEntity,
            @RequestParam(value = "token",required = true) String token
    ){
        return systemService.update(systemEntity);
    }

    /**
     * 获取系统图标
     * @return
     */
    @RequestMapping(value = "pic",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<String>> pic(
            @RequestParam(value = "token",required = true) String token
    ){
        return systemService.pic();
    }
}
