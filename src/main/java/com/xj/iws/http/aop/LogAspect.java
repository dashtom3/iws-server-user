package com.xj.iws.http.aop;

import com.xj.iws.http.mvc.dao.LogDao;
import com.xj.iws.http.mvc.entity.LogEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.transform.impl.AddDelegateTransformer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by XiaoJiang01 on 2017/4/26.
 */
@Aspect
@Component
public class LogAspect {
    @Autowired
    LogDao logDao;

    @Pointcut("execution(* com.xj.iws.http.mvc.controller.*.*Controller.*(..))")
    public void pointCut() {
    }

    @After("pointCut()")
    public void afterMethod(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object[] param = joinPoint.getArgs();
        UserEntity user = AspectUtil.getUser(param);
        String IP = request.getRemoteAddr();

        String[] URI = request.getRequestURI().split("/");
        String method = null;
        String handle = null;

        for (int i = URI.length - 1; i > -1; i--) {
            if (URI[i].indexOf("add") != -1) {
                method = "添加";
            } else if (URI[i].indexOf("update") != -1) {
                method = "编辑";
            } else if (URI[i].indexOf("delete") != -1) {
                method = "删除";
            } else {
                break;
            }
            if ("system".equals(URI[i])) {
                handle = method + "系统";
                break;
            } else if ("location".equals(URI[i])) {
                handle = method + "地点";
                break;
            } else if ("room".equals(URI[i])) {
                if (URI[i + 1].indexOf("Device") != -1) {
                    handle = "泵房" + method + "控制器实例";
                } else {
                    handle = method + "泵房";
                }
                break;
            } else if ("device".equals(URI[i])) {
                handle = method + "控制器组";
                break;
            } else if ("deviceTerm".equals(URI[i])) {
                handle = method + "控制器";
                break;
            } else if ("role".equals(URI[i])) {
                handle = method + "角色";
                break;
            } else if ("userManage".equals(URI[i])) {
                if(URI[i + 1].indexOf("role") != -1){
                    handle = "编辑用户角色";
                }
                break;
            }
        }
        if (null != handle){
            LogEntity log = new LogEntity(user.getId(),handle,IP);
            logDao.addHandle(log);
        }
    }
}
