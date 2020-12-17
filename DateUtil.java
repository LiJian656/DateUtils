package com.tfswx.sms.utils;

import org.springframework.util.StringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    public static final String DEFAULT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String LONG_DEFAULT_DATE_TIME = "yyyy-MM-dd HH:mm:ss.SSSSSS";
    public static final String DEFAULT_DATE = "yyyy-MM-dd";
    public static final String DEFAULT_DATE_TIME2 = "yyyyMMddHHmmssSSS";
    public static final String DEFAULT_YEAR = "yyyy";
    public static final String DEFAULT_MONTH = "yyyy-MM";
    public static final String START_TIME = " 00:00:00";
    public static final String END_TIME = " 23:59:59";
    public static final String GET_CURRENT_MINUTE = "yyyy-MM-dd HH:mm";
    private static int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
    /**
     * 格式化日期为指定日期格式
     *
     * @param formate
     * @return
     */
    public static String getDate(String formate) {
        // 小写的hh取得12小时，大写的HH取的是24小时
        final SimpleDateFormat df = new SimpleDateFormat(formate);
        return df.format(new Date());
    }
    /**
     * 获得当前日期 yyyyMMddHHmmss
     *DateUtil.getCurrentTime1()
     * @return 20190827141240
     */
    public static String getCurrentTime() {
        // 小写的hh取得12小时，大写的HH取的是24小时
        final SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_TIME2);
        Date date = new Date();
        return df.format(date);
    }

    /**
     * 获得当前日期 yyyy-MM-dd HH:mm
     * @return
     */
    public static String getCurrentTime1() {
        // 小写的hh取得12小时，大写的HH取的是24小时
        final SimpleDateFormat df = new SimpleDateFormat(LONG_DEFAULT_DATE_TIME);
        Date date = new Date();
        return df.format(date);
    }
    public static String getCurrentDateStr() {
        final SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_TIME);
        Date date = new Date();
        return df.format(date);
    }
    public static String getCurrentDateStr(String format) {
        final SimpleDateFormat df = new SimpleDateFormat(format);
        Date date = new Date();
        return df.format(date);
    }
    /**
     * 获得当前日期 yyyy-MM-dd HH:mm:ss
     *
     * @return 2019-08-27 14:12:40
     */
    public static String getNormalCurrentTime() {
        // 小写的hh取得12小时，大写的HH取的是24小时
        final SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_TIME);
        Date date = new Date();
        return df.format(date);
    }
    /**
     * 获取系统当前时间戳
     *
     * @return 1566889186583
     */
    public static String getSystemTime() {
        String current = String.valueOf(System.currentTimeMillis());
        return current;
    }
    /**
     * 时间转化
     *
     * @return 1566889186583
     */
    public static String parseDateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_TIME);
        return sdf.format(date);
    }
    /**
     * 获取当前日期 yy-MM-dd
     *
     * @return 2019-08-27
     */
    public static String getDateByString() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE);
        return sdf.format(date);
    }
    /**
     * 获取系统当前年的第一天 yy-MM-dd
     *
     * @return 2019-01-01
     */
    public static String getYearFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, Integer.parseInt(getYear()));
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE);
        return sdf.format(date);
    }
    /**
     * 获取系统当前年的最后一天 yy-MM-dd
     *
     * @return 2019-12-31
     */
    public static String getYearLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, Integer.parseInt(getYear()));
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE);
        return sdf.format(date);
    }
    /**
     * 获取系统当前年的第一天 yy-MM-dd
     *
     * @return 2019-01-01
     */
    public static String getYear() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_YEAR);
        return sdf.format(date);
    }
    /**
     * 得到两个时间差  格式yyyy-MM-dd HH:mm:ss
     *
     * @param start 2019-06-27 14:12:40
     * @param end   2019-08-27 14:12:40
     * @return 5270400000
     */
    public static long dateSubtraction(String start, String end) {
        final SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_TIME);
        try {
            Date date1 = df.parse(start);
            Date date2 = df.parse(end);
            return date2.getTime() - date1.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
    /**
     * 得到两个时间差
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    public static long dateTogether(Date start, Date end) {
        return end.getTime() - start.getTime();
    }
    /**
     * 转化long值的日期为yyyy-MM-dd  HH:mm:ss.SSS格式的日期
     *
     * @param millSec 日期long值  5270400000
     * @return 日期，以yyyy-MM-dd  HH:mm:ss.SSS格式输出 1970-03-03  08:00:00.000
     */
    public static String transferLongToDate(String millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(LONG_DEFAULT_DATE_TIME);
        Date date = new Date(Long.parseLong(millSec));
        return sdf.format(date);
    }
    /**
     * 获得当前日期 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getOkDate(String date) {
        try {
            if (StringUtils.isEmpty(date)) {
                return null;
            }
            Date date1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH).parse(date);
            //格式化
            SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_TIME);
            return sdf.format(date1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 获取当前日期是一个星期的第几天
     *
     * @return 2
     */
    public static int getDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }
    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime     当前时间
     * @param dateSection 时间区间   2018-01-08,2019-09-09
     * @return
     * @author jqlin
     */
    public static boolean isEffectiveDate(Date nowTime, String dateSection) {
        try {
            String[] times = dateSection.split(",");
            String format = "yyyy-MM-dd";
            Date startTime = new SimpleDateFormat(format).parse(times[0]);
            Date endTime = new SimpleDateFormat(format).parse(times[1]);
            if (nowTime.getTime() == startTime.getTime()
                    || nowTime.getTime() == endTime.getTime()) {
                return true;
            }
            Calendar date = Calendar.getInstance();
            date.setTime(nowTime);
            Calendar begin = Calendar.getInstance();
            begin.setTime(startTime);
            Calendar end = Calendar.getInstance();
            end.setTime(endTime);
            if (isSameDay(date, begin) || isSameDay(date, end)) {
                return true;
            }
            if (date.after(begin) && date.before(end)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 != null && cal2 != null) {
            return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }
    public static long getTimeByDate(String time) {
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_TIME);
        try {
            Date date = format.parse(time);
            //日期转时间戳（毫秒）
            return date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    /**
     * 获取当前小时 ：2019-08-23 17
     *
     * @return 2019-08-27 17
     */
    public static String getCurrentHour() {
        GregorianCalendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour < 10) {
            return DateUtil.getCurrentTime() + " 0" + hour;
        }
        return DateUtil.getDateByString() + " " + hour;
    }
    /**
     * 获取当前时间一个小时前
     *
     * @return 2019-08-27 16
     */
    public static String getCurrentHourBefore() throws ParseException {
        GregorianCalendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour > 0) {
            hour = calendar.get(Calendar.HOUR_OF_DAY) - 1;
            if (hour < 10) {
                return DateUtil.getDateByString() + " 0" + hour;
            }
            return DateUtil.getDateByString() + " " + hour;
        }
        //获取当前日期前一天
        return DateUtil.getBeforeDay(getCurrentTime()) + " " + 23;
    }
    /**
     * 获取当前日期前一天
     *
     * @return 2019-08-26
     */
    public static String getBeforeDay(String currentDay) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE);
        Date date = getNowDate(currentDay);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return sdf.format(date);
    }
    /**
     * 获取最近七天
     *
     * @return 2019-08-20
     */
    public static String getServen() {
        return DateUtil.getSomeDayAge(6);
    }
    /**
     * 获取当前日期前指定天数日期
     *
     * @param dayNum
     * @return
     */
    public static String getSomeDayAge(int dayNum) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -dayNum);
        Date monday = c.getTime();
        String preMonday = sdf.format(monday);
        return preMonday;
    }
    /**
     * 获取当前日期前指定天数日期
     *
     * @param dayNum
     * @return
     */
    public static String getSomeYearAge(int dayNum) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_YEAR);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -dayNum);
        Date monday = c.getTime();
        String preMonday = sdf.format(monday);
        return preMonday;
    }
    /**
     * 获取当前日期前指定天数日期
     *
     * @param dayNum
     * @return
     */
    public static String getSomeMonthAge(int dayNum) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_MONTH);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -dayNum);
        Date monday = c.getTime();
        String preMonday = sdf.format(monday);
        return preMonday;
    }
    /**
     * 获取最近一个月
     *
     * @return 2019-07-27
     */
    public static String getOneMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        Date monday = c.getTime();
        String preMonday = sdf.format(monday);
        return preMonday;
    }
    /**
     * 获取最近三个月
     *
     * @return 2019-05-27
     */
    public static String getThreeMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -3);
        Date monday = c.getTime();
        String preMonday = sdf.format(monday);
        return preMonday;
    }
    /**
     * 获取最近一年
     *
     * @return 2018-08-27
     */
    public static String getOneYear() {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -1);
        Date start = c.getTime();
        String startDay = sdf.format(start);
        return startDay;
    }
    /**
     * 获取今年月份数据
     * 说明 有的需求前端需要根据月份查询每月数据，此时后台给前端返回今年共有多少月份
     *
     * @return [1, 2, 3, 4, 5, 6, 7, 8]
     */
    public static List getMonthList() {
        List list = new ArrayList();
        for (int i = 1; i <= month; i++) {
            list.add(i);
        }
        return list;
    }
    /**
     * 返回当前年度季度list
     * 本年度截止目前共三个季度，然后根据1,2,3分别查询相关起止时间
     *
     * @return [1, 2, 3]
     */
    public static List getQuartList() {
        int quart = month / 3 + 1;
        List list = new ArrayList();
        for (int i = 1; i <= quart; i++) {
            list.add(i);
        }
        return list;
    }
    /**
     * 获取现在时间
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    public static Date getNowDate(String strDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE);
        return simpleDateFormat.parse(strDate);
    }
    /**
     * 获取30分钟前数据
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm
     */
    public static String getBefore30minute() throws ParseException {
        Calendar nowAfter = Calendar.getInstance();
        nowAfter.add(Calendar.MINUTE, -30);
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_TIME);
        return sdf.format(nowAfter.getTimeInMillis());
    }
    /**
     * @Author：
     * @Description：更加输入日期，获取输入日期的前一天
     * @Date：
     * @strData：参数格式：yyyy-MM-dd
     * @return：返回格式：yyyy-MM-dd
     */
    public static String getPreDateByDate(String strData) {
        String preDate = "";
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE);
        Date date = null;
        try {
            date = sdf.parse(strData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day1 = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day1 - 1);
        preDate = sdf.format(c.getTime());
        return preDate;
    }
    public static String formatDate(Date date, String format) {
        final SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }
}