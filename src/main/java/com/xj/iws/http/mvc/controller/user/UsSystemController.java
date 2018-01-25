package com.xj.iws.http.mvc.controller.user;

import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.SystemEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;
import com.xj.iws.http.mvc.service.LimitationService;
import com.xj.iws.http.mvc.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理全部系统请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/system")
public class UsSystemController {

    @Autowired
    SystemService systemService;
    @Autowired
    LimitationService limitationService;

    /**
     * 获取全部系统及系统下全部地点
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<SystemEntity>> list(
            @RequestParam(value = "token", required = true) String token
    ) {
        UserEntity user = SessionManager.getSession(token);
        List<Limitation> limitations = limitationService.getLimit(user);
        return systemService.list(limitations);
    }

    /**
     * 获取某一系统及系统下全部地点
     *
     * @param systemId
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<SystemEntity> detail(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "systemId", required = true) int systemId
    ) {
        UserEntity user = SessionManager.getSession(token);
        List<Limitation> limitations = limitationService.getLimit(user);
        return systemService.detail(systemId, limitations);
    }

    /**
     * 获取全部系统及系统下全部地点封装
     *
     * @return
     */
    @RequestMapping(value = "listPack", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<SystemEntity>> listPack(
            @RequestParam(value = "token", required = true) String token
    ) {
        UserEntity user = SessionManager.getSession(token);
        List<Limitation> limitations = limitationService.getLimit(user);
        return systemService.listPack(limitations);
    }

    /**
     * 获取某一系统及系统下全部地点封装
     *
     * @param systemId
     * @return
     */
    @RequestMapping(value = "detailPack", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<SystemEntity> detailPack(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "systemId", required = true) int systemId
    ) {
        UserEntity user = SessionManager.getSession(token);
        List<Limitation> limitations = limitationService.getLimit(user);
        return systemService.detailPack(systemId, limitations);
    }
}
