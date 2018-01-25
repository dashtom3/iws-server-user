package com.xj.iws.http.mvc.controller.user;

import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.service.UserService;
import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理全部用户请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 查看个人资料
     *
     * @return user
     */
    @RequestMapping(value = "detail", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<UserEntity> detail(
            @RequestParam(value = "token", required = true) String token
    ) {
        UserEntity user = SessionManager.getSession(token);
        int userId = user.getId();
        return userService.detail(userId);
    }

    /**
     * 个人资料编辑
     *
     * @return boolean
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<UserEntity> update(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "describes", required = false) String describes,
            @RequestParam(value = "pic", required = false) String pic,
            @RequestParam(value = "token", required = true) String token
    ) {
        UserEntity user = SessionManager.getSession(token);
        user.setName(name);
        user.setAddress(address);
        user.setDescribes(describes);
        user.setPic(pic);
        return userService.update(user);
    }

    /**
     * 修改密码
     *
     * @return boolean
     */
    @RequestMapping(value = "changePwd", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> changePwd(
            @RequestParam(value = "oldPwd", required = true) String oldPwd,
            @RequestParam(value = "newPwd", required = true) String newPwd,
            @RequestParam(value = "token", required = true) String token
    ) {
        UserEntity user = SessionManager.getSession(token);
        int userId = user.getId();
        return userService.changePwd(userId, oldPwd, newPwd);
    }

    /**
     * 退出登录
     *
     * @return boolean
     */
    @RequestMapping(value = "reLogin", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> reLogin(
            @RequestParam(value = "token", required = true) String token
    ) {
        return userService.reLogin(token);
    }

    @RequestMapping(value = "getGroupMember", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<UserEntity>> getGroupMember(
            @RequestParam(value = "token", required = true) String token
    ) {
        UserEntity user = SessionManager.getSession(token);
        return userService.getGroupMember(user);
    }
}
