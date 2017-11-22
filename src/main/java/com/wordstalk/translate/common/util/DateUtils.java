package com.wordstalk.translate.common.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtils {

    private static final String[] CN_MM = {"", "\u4e00\u6708", "\u4e8c\u6708", "\u4e09\u6708", "\u56db\u6708", "\u4e94\u6708", "\u516d\u6708", "\u4e03\u6708", "\u516b\u6708", "\u4e5d\u6708", "\u5341\u6708", "\u5341\u4e00\u6708",
            "\u5341\u4e8c\u6708"};

    private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获取格式化今天的日期字符串
     */
    public static String getCurDayDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date());
    }

    /**
     * 转换字符串为日期(只支持到yyyy-MM-dd)
     */
    public static Date getFormatDateOnDay(String s) {
        Date date = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = simpleDateFormat.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获得指定格式的日期字符串
     */
    public static String getCurrentDate(String format) {
        String dateString = "";
        try {
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format);
            java.util.Date currentTime_1 = new java.util.Date();
            dateString = formatter.format(currentTime_1);
        } catch (Exception e) {
        }
        return dateString;
    }
}
