package com.xj.iws.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by tian on 16/10/18.
 */
public class TimeUtil {

    public static Date changeStringToDate(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.parse(time);
    }
    public static Long timeBetween(Date oldDate, Date nowDate){
        return Math.abs(nowDate.getTime()-oldDate.getTime());
    }

    /**
     * 获取日期
     * @param date 基准时间
     * @param skewing 偏移量, 0为当前日期
     * @return
     */
    public static String getDate(Date date, int skewing) {
        SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, skewing);
        return dateForm.format(calendar.getTime());
    }

    public static String getTime(Date date, int skewing){
        SimpleDateFormat dateForm = new SimpleDateFormat("HHmmss");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, skewing);
        return dateForm.format(calendar.getTime());
    }

    public static String getDateTime(Date date, int skewing){
        SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, skewing);
        return dateForm.format(calendar.getTime());
    }
}
