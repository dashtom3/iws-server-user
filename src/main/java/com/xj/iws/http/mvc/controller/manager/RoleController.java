package com.xj.iws.http.mvc.controller.manager;

import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.RoleEntity;
import com.xj.iws.http.mvc.entity.RoleSubEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;
import com.xj.iws.http.mvc.service.LimitationService;
import com.xj.iws.http.mvc.service.RoleService;
import com.xj.iws.common.utils.DataWrapper;
import org.apache.http.io.SessionOutputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理全部角色请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/role")
public class RoleController {

    @Autowired
    RoleService roleService;
    @Autowired
    LimitationService limitationService;


    /**
     * 添加角色
     * @param roleEntity
     * @param subitem
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<RoleEntity> add(
            @RequestParam(value = "token", required = true) String token,
            @ModelAttribute RoleEntity roleEntity,
            @RequestBody RoleSubEntity[] subitem
    ) {
        return roleService.add(roleEntity, subitem);
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @param token
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "roleId", required = true) int roleId
    ) {
        return roleService.delete(roleId);
    }


    /**
     * 编辑角色
     * @param roleEntity
     * @param subitem
     * @param token
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<RoleEntity> update(
            @RequestParam(value = "token", required = true) String token,
            @ModelAttribute RoleEntity roleEntity,
            @RequestBody RoleSubEntity[] subitem
    ) {
        return roleService.update(roleEntity,subitem);
    }

    /**
     * 获取角色列表
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<RoleEntity>> list(
            @RequestParam(value = "token", required = true) String token,
            @ModelAttribute Page page
    ) {
        UserEntity user = SessionManager.getSession(token);
        int except = 0;
        if (!limitationService.checkMaintainer(user)) except = 1;
        return roleService.list(except,page);
    }

    /**
     * 获取某一角色
     *
     * @param roleId
     * @param token
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<RoleEntity> detail(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "roleId", required = true) int roleId
    ) {
        return roleService.detail(roleId);
    }

    /**
     * 查询角色
     *
     * @param systemId
     * @param areaId
     * @param limitation
     * @param name
     * @param token
     * @return
     */
    @RequestMapping(value = "query", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<RoleEntity>> query(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "systemId", required = true) String systemId,
            @RequestParam(value = "areaId", required = false) String areaId,
            @RequestParam(value = "limitation", required = false) String limitation,
            @RequestParam(value = "name", required = false) String name
    ) {
        //创建查询条件
        Map<String, String> condition = new HashMap<String, String>();

        if (systemId != null && !"".equals(systemId)) {
            condition.put("systemId", systemId);
        }
        if (areaId != null && !"".equals(areaId)) {
            if ("00".equals(areaId.substring(4, 6))) {
                if ("0000".equals(areaId.substring(2, 6))) {
                    condition.put("provinceId", areaId);
                } else {
                    condition.put("cityId", areaId);
                }
            } else {
                condition.put("areaId", areaId);
            }
        }
        if (limitation != null && !"".equals(limitation)) {
            condition.put("limitation", limitation);
        }
        if (name != null && !"".equals(name)) {
            condition.put("name", name);
        }
        return roleService.query(condition);
    }
}
