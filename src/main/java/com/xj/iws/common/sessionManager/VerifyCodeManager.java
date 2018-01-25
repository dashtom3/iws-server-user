package com.xj.iws.common.sessionManager;

import com.xj.iws.common.utils.TimeUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by tian on 16/10/10.
 */
public class VerifyCodeManager {
    private static int minute = 5;
    private static HashMap<String, String> USER_CODE_MAP = new HashMap<String, String>();
    public static String newPhoneCode(String phoneNum) {
        Random random = new Random();
        int a = random.nextInt(8999)+1000;
        String code = String.valueOf(a);
        String oldCode = getPhoneCode(phoneNum);

        if(oldCode.equals("overdue")||oldCode.equals("noCode")){
            USER_CODE_MAP.put(phoneNum,code+ TimeUtil.getDateTime(new Date(),0));
            return code;
        }
        else
            return null;
    }

    public static String getPhoneCode(String phoneNum){
        try {
//            System.out.println("contain:"+USER_CODE_MAP.containsKey(phoneNum));
            if(USER_CODE_MAP.containsKey(phoneNum)){
                if (TimeUtil.timeBetween(TimeUtil.changeStringToDate(USER_CODE_MAP.get(phoneNum).substring(4)), new Date()) / (60 * 1000) > minute){
                    VerifyCodeManager.removePhoneCodeByPhoneNum(phoneNum);
                    return "overdue";
                }else{
                    return  USER_CODE_MAP.get(phoneNum).substring(0,4);
                }
            }
            else return "noCode";

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 删除某用户的验证码Code
     */
    public static void removePhoneCodeByPhoneNum(String phoneNum) {
        if (USER_CODE_MAP.containsKey(phoneNum)) {
            USER_CODE_MAP.remove(phoneNum);
        }
    }

}
