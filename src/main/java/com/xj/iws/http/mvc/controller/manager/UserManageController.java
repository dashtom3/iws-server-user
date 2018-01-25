package com.xj.iws.http.mvc.controller.manager;

import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
@Controller
@RequestMapping("api/userManage")
public class UserManageController {

    @Autowired
    UserManageService userManageService;

    /**
     * 获取用户列表
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<UserEntity>> list(
            @RequestParam(value = "token", required = true) String token,
            @ModelAttribute Page page
            ) {
        return userManageService.list(page);
    }

    /**
     * 分配角色
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "role", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<Void> role(
            @RequestParam(value = "userId", required = true) int userId,
            @RequestParam(value = "roleId", required = true) int roleId,
            @RequestParam(value = "token", required = true) String token
    ) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        userEntity.setRoleId(roleId);
        return userManageService.role(userEntity);
    }

    /**
     * 修改用户状态
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "status", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<Void> status(
            @RequestParam(value = "userId", required = true) int userId,
            @RequestParam(value = "status", required = true) int status,
            @RequestParam(value = "token", required = true) String token
    ) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        userEntity.setStatus(status);
        return userManageService.status(userEntity);
    }

    /**
     * 查询用户
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<UserEntity>> query(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "token", required = true) String token
    ) {
        Map<String, String> condition = new HashMap<String, String>();
        if (username != null && !username.equals("")) {
            condition.put("username", username);
        }
        if (name != null && !name.equals("")) {
            condition.put("name", name);
        }
        if (address != null && !address.equals("")) {
            condition.put("address", address);
        }
        return userManageService.query(condition);
    }


    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<UserEntity> detail(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "userId",required = true) int userId
    ) {
        return userManageService.detail(userId);
    }
}
