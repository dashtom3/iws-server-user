package com.xj.iws.common.sessionManager;

import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.common.utils.UUIDGenerator;

import java.util.*;

/**
 * Created by tian on 16/9/27.
 */
public class SessionManager {
    private static int KEY_COUNT = 0;
    private static final int KEY_TIME = 2 * 3600 * 1000;
    public static HashMap<String, UserEntity> USER_SESSION_MAP = new HashMap<String, UserEntity>();

    public static String newSession(UserEntity user) {

        String sessionKey = UUIDGenerator.getCode("SK");

        ++KEY_COUNT;
        if (KEY_COUNT >= 10000000) {
            KEY_COUNT = 0;
        }

        USER_SESSION_MAP.put(sessionKey, user);
        System.out.println(USER_SESSION_MAP);
//        System.out.println("#####"+user.getUsername()+"login success,token:"+sessionKey);
        //此处即设置超时时间的地方
//        new Timer().schedule(new Task(sessionKey), KEY_TIME);
        return sessionKey;
    }

    public static UserEntity getSession(String key) {
        if (USER_SESSION_MAP.containsKey(key))
            return USER_SESSION_MAP.get(key);
        else
            return null;
    }

    public static String getSessionByUserID(Long userId) {
        Set<String> set = USER_SESSION_MAP.keySet();
        for (String key : set) {
            if (USER_SESSION_MAP.get(key).getId() == userId)
                return key;
        }
        return null;
    }

    public static void removeSession(String key) {
        if (USER_SESSION_MAP.containsKey(key)) {
            //log.info("Session Destroyed! Key:" + key);
            USER_SESSION_MAP.remove(key);
        }
    }

    /**
     * 删除某用户的Session
     *
     * @param userId
     */
    public static void removeSessionByUserId(Long userId) {
        Iterator<Map.Entry<String, UserEntity>> iter = USER_SESSION_MAP.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, UserEntity> entry = iter.next();
            String key = entry.getKey();
            UserEntity value = entry.getValue();
            if (value != null && value.getId() == userId) {
                removeSession(key);
                break;
            }
        }
    }

    /**
     * 自执行删除
     */
    private static class Task extends TimerTask {
        private String key;

        public Task(String key) {
            this.key = key;
        }

        @Override
        public void run() {
            removeSession(key);
        }
    }
}
