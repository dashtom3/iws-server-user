package com.xj.iws.common.enums;

import java.io.Serializable;

/**
 *
 * Created by Jo on 2017/7/20.
 */
public enum ErrorCodeEnum implements Serializable {

    No_Error("No Error!", 0),
    Error("Unknown Error!", 1),
    Login_Error("用户名或者密码错误",2),
    Username_Already_Exist("用户名已存在",3),
    Register_Error("注册失败",4),
    Verify_Code_Error("验证码错误",5),
    Verify_Code_5min("验证码5分钟",6),
    Verify_Code_notExist("验证码不存在",7),
    Username_NOT_Exist("用户不存在",8),
    Password_error("密码错误",9),
    Limitation_error("无操作权限",10),
    Already_Exist_Error("已存在",11);

    private String label;
    private Integer code;

    ErrorCodeEnum() {
    }

    ErrorCodeEnum(String label, Integer code) {
        this.label = label;
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ErrorCode#"+code.toString()+":"+label;
    }

    public static ErrorCodeEnum parse(int code) {
        for (ErrorCodeEnum theEnum : ErrorCodeEnum.values()) {
            if (theEnum.getCode() == code) {
                return theEnum;
            }
        }
        return No_Error;
    }
}
