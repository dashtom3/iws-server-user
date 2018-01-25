package com.xj.iws.http.aop;

import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.http.mvc.entity.UserEntity;

/**
 *
 * Created by Jo on 2017/4/27.
 */
public class AspectUtil {

    public static UserEntity getUser(Object[] param){
        String token = null;
        for (int i = 0; i <param.length ; i++) {
            if(param[i] != null && param[i].toString().length() > 1){
                if ("SK".equals(param[i].toString().substring(0,2))){
                    token = param[i].toString();
                    break;
                }
            }
        }
        return SessionManager.getSession(token);
    }
}
