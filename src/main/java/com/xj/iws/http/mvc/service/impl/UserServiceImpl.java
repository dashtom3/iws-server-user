package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.utils.ParamUtil;
import com.xj.iws.http.mvc.dao.UserDao;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.http.mvc.service.LimitationService;
import com.xj.iws.http.mvc.service.UserService;
import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.sessionManager.VerifyCodeManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.HttpUtil;
import com.xj.iws.common.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    LimitationService limitationService;

    /**
     *
     * @param username
     * @param password
     * @param status 为0表示请求登录管理员页面
     *
     * @return
     */
    @Override
    public DataWrapper<Map<String,String>> login(String username, String password, String status) {
        DataWrapper<Map<String,String>> dataWrapper = new DataWrapper<Map<String,String>>();
        UserEntity user = userDao.getUserByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(MD5Util.getMD5String(MD5Util.prePassword(password)))) {
                if ("0".equals(status)){
                    if (!limitationService.checkAdmin(user)){
                        dataWrapper.setErrorCode(ErrorCodeEnum.Limitation_error);
                        return dataWrapper;
                    }
                }
                String token = SessionManager.newSession(user);
                Map<String,String> data = ParamUtil.objToMap(user);
                data.put("token",token);
                dataWrapper.setData(data);
                dataWrapper.setToken(token);
                return dataWrapper;
            } else {
                dataWrapper.setErrorCode(ErrorCodeEnum.Login_Error);
            }
        } else {
            dataWrapper.setErrorCode(ErrorCodeEnum.Username_NOT_Exist);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<UserEntity> register(UserEntity user, String code) {
        DataWrapper<UserEntity> dataWrapper = new DataWrapper<UserEntity>();
        String username = user.getUsername();
        if (userDao.getUserByUsername(username) == null) {
            //验证码服务
            String serverCode = VerifyCodeManager.getPhoneCode(username);
            if (serverCode.equals("noCode")) {
                dataWrapper.setErrorCode(ErrorCodeEnum.Verify_Code_notExist);
            } else if (serverCode.equals("overdue")) {
                dataWrapper.setErrorCode(ErrorCodeEnum.Verify_Code_5min);
            } else if (serverCode.equals(code)) {
                UserEntity newUser = new UserEntity();
                newUser.setUsername(username);
                newUser.setPassword(MD5Util.getMD5String(MD5Util.prePassword(user.getPassword())));
                newUser.setName(user.getName() == null ? user.getUsername() : user.getName());
                newUser.setAddress(user.getAddress());
                newUser.setDescribes(user.getDescribes());
                if (1 == userDao.register(newUser)) {
                    //移除验证码
                    VerifyCodeManager.removePhoneCodeByPhoneNum(username);
                    dataWrapper.setData(newUser);
                    dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
                    return dataWrapper;
                } else {
                    dataWrapper.setErrorCode(ErrorCodeEnum.Register_Error);
                }
            } else {
                System.out.println("code:" + code);
                System.out.println("VerifyCode:" + VerifyCodeManager.getPhoneCode(username));
                dataWrapper.setErrorCode(ErrorCodeEnum.Verify_Code_Error);
            }
        } else {
            dataWrapper.setErrorCode(ErrorCodeEnum.Username_Already_Exist);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> getVerifyCode(String phoneNum) {
        //五分钟之内不能再发短信
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        String code = VerifyCodeManager.newPhoneCode(phoneNum);
        if (code == null) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Verify_Code_5min);
            return dataWrapper;
        }
        boolean result = HttpUtil.sendPhoneVerifyCode(code, phoneNum);
        if (result) {
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        } else {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<UserEntity> detail(int userId) {
        DataWrapper<UserEntity> dataWrapper = new DataWrapper<UserEntity>();
        UserEntity user = userDao.getUserById(userId);
        if (user != null) {
            dataWrapper.setData(user);
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        } else {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<UserEntity> update(UserEntity user) {
        DataWrapper<UserEntity> dataWrapper = new DataWrapper<UserEntity>();
        if (1 == userDao.updateUser(user)) {
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
            user=userDao.getUserById(user.getId());
            dataWrapper.setData(user);
        } else {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> changePwd(int userId, String oldPwd, String newPwd) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        UserEntity user = userDao.getUserById(userId);
        if (user.getPassword().equals(MD5Util.getMD5String(MD5Util.prePassword(oldPwd)))) {
            user.setPassword(MD5Util.getMD5String(MD5Util.prePassword(newPwd)));
            if (1 == userDao.updatePwd(user)) {
                dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
            } else {
                dataWrapper.setErrorCode(ErrorCodeEnum.Error);
            }
        } else {
            dataWrapper.setErrorCode(ErrorCodeEnum.Password_error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> forgetPwd(String username, String password, String code) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        //验证码服务
        String serverCode = VerifyCodeManager.getPhoneCode(username);
        if (serverCode.equals("noCode")) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Verify_Code_notExist);
        } else if (serverCode.equals("overdue")) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Verify_Code_5min);
        } else if (serverCode.equals(code)) {
            UserEntity user;
            if ((user = userDao.getUserByUsername(username)) != null){
                user.setPassword(MD5Util.getMD5String(MD5Util.prePassword(password)));
                userDao.updatePwd(user);
                VerifyCodeManager.removePhoneCodeByPhoneNum(username);
            }else {
                dataWrapper.setErrorCode(ErrorCodeEnum.Username_NOT_Exist);
            }
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> reLogin(String token) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        SessionManager.removeSession(token);
        dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<UserEntity>> getGroupMember(UserEntity user) {
        DataWrapper<List<UserEntity>> dataWrapper = new DataWrapper<List<UserEntity>>();
        List<UserEntity> userEntities = userDao.getUsersByRole(user.getRoleId());
        dataWrapper.setData(userEntities);
        return dataWrapper;
    }
}
