package com.stonebridge.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    /**
     * 获取当前时间减  number 天前的时间
     *
     * @param number 数字
     * @param format 时间格式
     */
    public static String getCurrentSDateAddNum(int number, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        int j = 0 - number;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, j);
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取当前时间减  number 天前的时间
     *
     * @param number 数字
     * @param format 时间格式
     */
    public static String getCurrentSDateAddNum(Date date, int number, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        int j = 0 - number;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, j);
        return sdf.format(calendar.getTime());
    }
}
