package com.xj.iws.http.mvc.controller.customer;

import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 管理全部用户请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/user")
public class CuUserController {

    @Autowired
    UserService userService;

    /**
     * 用户登录
     *
     * @return boolean
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Map<String,String>> login(
            @RequestParam(value = "status",required = false) String status,
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password
    ) {
        return userService.login(username, password, status);
    }

    /**
     * 用户注册
     *
     * @return boolean
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<UserEntity> register(
            @ModelAttribute UserEntity user,
            @RequestParam(value = "code", required = true) String code
    ) {
        return userService.register(user, code);
    }

    //获取验证码
    @RequestMapping(value = "getVerifyCode")
    @ResponseBody
    public DataWrapper<Void> getVerifyCode(
            @RequestParam(value = "username", required = true) String username
    ) {
        return userService.getVerifyCode(username);
    }

    /**
     * 忘记密码
     *
     * @return boolean
     */
    @RequestMapping(value = "forgetPwd", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> forgetPwd(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "code", required = true) String code
    ) {
        return userService.forgetPwd(username, password, code);
    }
}
