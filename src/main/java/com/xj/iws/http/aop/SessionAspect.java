package com.xj.iws.http.aop;


import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.service.LimitationService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by XiaoJiang01 on 2017/3/15.
 */
@Aspect
@Component
public class SessionAspect {
    @Autowired
    LimitationService limitationService;

    @Pointcut("execution(* com.xj.iws.http.mvc.controller.manager.DeviceController.*(..))")
    public void manager() {
    }

    @Around("manager()")
    public Object checkManager(ProceedingJoinPoint point) {

        DataWrapper<String> dataWrapper = new DataWrapper<String>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Limitation_error);

        Object[] param = point.getArgs();
        UserEntity user = AspectUtil.getUser(param);

        if (user == null) {
            return dataWrapper;
        } else {
            if (!limitationService.checkAdmin(user)) {
                return dataWrapper;
            } else {
                Object object = null;
                try {
                    object = point.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                return object;
            }
        }
    }

    @Pointcut("execution(* com.xj.iws.http.mvc.controller.user.AlarmController.*(..))")
    public void user() {
    }

    @Around("user()")
    public Object checkUser(ProceedingJoinPoint point) {

        DataWrapper<String> dataWrapper = new DataWrapper<String>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Limitation_error);

        Object[] param = point.getArgs();
        UserEntity user = AspectUtil.getUser(param);

        if (user == null) {
            return dataWrapper;
        } else {
            if (0 == user.getRoleId()){
                return dataWrapper;
            }else {
                Object object = null;
                try {
                    object = point.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                return object;
            }
        }
    }
}

