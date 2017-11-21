package com.wordstalk.translate.common.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtils {

	private static final String[] CN_MM = { "", "\u4e00\u6708", "\u4e8c\u6708", "\u4e09\u6708", "\u56db\u6708", "\u4e94\u6708", "\u516d\u6708", "\u4e03\u6708", "\u516b\u6708", "\u4e5d\u6708", "\u5341\u6708", "\u5341\u4e00\u6708",
			"\u5341\u4e8c\u6708" };

	/**
	 * 得到月份的中文名
	 * 
	 * @param myDate
	 * @return
	 */
	public static String formatDateCN(Date myDate) {
		String strDate = CN_MM[getMonth(myDate)];
		return strDate;
	}

	/**
	 * 得到日期对应的月份数
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(Calendar.MONTH) + 1;
	}

	public static int getYear(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(Calendar.YEAR);
	}
	
	 /**
     * 返回某天是星期几：1表示星期一,7表示星期日;
     * @param date yyyy-MM-dd格式
     * @return
     */
    public static int getWeekdayStartFromOne(String date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateUtils.getFormatDateOnDay(date));
        int week_day = cal.get(Calendar.DAY_OF_WEEK);
        return week_day==1 ? 7 : week_day-1;
    }

	/**
	 * 得到本月对应的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonthFristDay() {
		Date date = new Date();
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		int day = cld.get(Calendar.DAY_OF_MONTH) - 1;
		return getPriorDayDateStr(day);
	}
	
	  private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	    /**
	     * 二个日期之间的天数:dateString1-dateString2
	     * 
	     * @param dateString1
	     *            格式yyyy-MM-dd
	     * @param dateString2
	     *            格式yyyy-MM-dd
	     * @return
	     */
	    public static int date_diff(String dateString1, String dateString2) {
	        try {
	            long diffInMilliSeconds = formatter.parse(dateString1.toString()).getTime()//
	                    - formatter.parse(dateString2.toString()).getTime();
	            return (int) (diffInMilliSeconds / 86400000L);
	        } catch (ParseException e) {
	        }
	        return 0;
	    }

    public static String getDateStr(Date d) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(d);
    }
    
	public static String getAnyMonthFristDay(String cDate, int num) {
		for (int i = 0; i < num; i++) {
			cDate = getPriorDayDateStr(getMonthFristDay(cDate), 1);
		}
		return getMonthFristDay(cDate);
	}

	public static String getAnyNextMonthFristDay(String cDate, int num) {
		for (int i = 0; i < num; i++) {
			cDate = getMonthNextDay(cDate);
		}
		return getMonthFristDay(cDate);
	}

	public static String getAnyNextMonthLastDay(String cDate, int num) {
		for (int i = 0; i < num; i++) {
			cDate = getMonthNextDay(cDate);
		}
		return getMonthLastDay(cDate);
	}

	public static String getAnyMonthLastDay(String cDate, int num) {
		for (int i = 0; i < num; i++) {
			cDate = getPriorDayDateStr(getMonthFristDay(cDate), 1);
		}
		return cDate;
	}

	public static String getMonthFristDay(String cDate) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = Calendar.getInstance();
		try {
			date.setTime(getFormatDateOnDay(cDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int minDate = date.getActualMinimum(Calendar.DATE);
		date.set(Calendar.DATE, minDate);
		String beforeDate = dft.format(date.getTime());
		return beforeDate;
	}

	public static String getMonthNextDay(String cDate) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = Calendar.getInstance();
		try {
			date.setTime(getFormatDateOnDay(cDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int minDate = date.getActualMaximum(Calendar.DATE) + 1;
		date.set(Calendar.DATE, minDate);
		String beforeDate = dft.format(date.getTime());
		return beforeDate;
	}

	public static String getMonthLastDay(String cDate) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = Calendar.getInstance();
		try {
			date.setTime(getFormatDateOnDay(cDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int minDate = date.getActualMaximum(Calendar.DATE);
		date.set(Calendar.DATE, minDate);
		String beforeDate = dft.format(date.getTime());
		return beforeDate;
	}

	/**
	 * 获取当前月份的日期
	 * 
	 * @return
	 */
	public static String getCurMonthDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		return simpleDateFormat.format(new Date());
	}

	public static String getPriorMonthStr(Date cDate, int num) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM");
		Calendar date = Calendar.getInstance();
		try {
			date.setTime(cDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		date.add(Calendar.MONTH, -num);
		return dft.format(date.getTime());
	}

	/**
	 * 获取格式化今天的日期字符串
	 * 
	 * @return
	 */
	public static String getCurDayDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(new Date());
	}

	public static String getTimeStr(Date d) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return simpleDateFormat.format(d);
	}

	/**
	 * 得到今天的长整型时间since January 1, 1970, 00:00:00 GMT represented by this Date object.
	 * 
	 * @return
	 */
	public static long getTodayTime() {
		Calendar cld = Calendar.getInstance();
		// cld.setTime(new Date());
		int year = cld.get(Calendar.YEAR);
		int month = cld.get(Calendar.MONTH);
		int day = cld.get(Calendar.DAY_OF_MONTH);
		Calendar todaycld = Calendar.getInstance();
		todaycld.set(year, month, day, 0, 0, 0);
		return todaycld.getTime().getTime();
	}

	/**
	 * 判断是否今天
	 * 
	 * @param atime
	 * @return
	 */
	public static boolean isTodayTime(long atime) {
		Calendar cld = Calendar.getInstance();
		// cld.setTime(new Date());
		int year = cld.get(Calendar.YEAR);
		int month = cld.get(Calendar.MONTH);
		int day = cld.get(Calendar.DAY_OF_MONTH);
		Calendar todaycld = Calendar.getInstance();
		todaycld.set(year, month, day, 0, 0, 0);
		if (atime + 1000l >= todaycld.getTime().getTime()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否昨天
	 * 
	 * @param atime
	 * @return
	 */
	public static boolean isLastdayTime(long atime) {
		Calendar cld = Calendar.getInstance();
		// cld.setTime(new Date());
		cld.add(Calendar.DAY_OF_MONTH, -1);
		int year = cld.get(Calendar.YEAR);
		int month = cld.get(Calendar.MONTH);
		int day = cld.get(Calendar.DAY_OF_MONTH);
		Calendar lastdaycld = Calendar.getInstance();
		lastdaycld.set(year, month, day, 0, 0, 0);
		if (atime + 1000l >= lastdaycld.getTime().getTime() && atime + 1000l <= lastdaycld.getTime().getTime() + 86400000l) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 转换字符串为日期(只支持到yyyy-MM-dd)
	 * 
	 * @param s
	 * @return
	 * @throws Exception
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
	 * 转换字符串为日期,精确到时分秒
	 * 
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static Date getFormatDateOnDay(String s, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = simpleDateFormat.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/*
	 * 转换为中文日期
	 */
	public static String getFormatZHDay(String s) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat sf = new SimpleDateFormat();
		sf.applyPattern("yyyy\u5E74MM\u6708dd\u65E5");
		return sf.format(date);
	}

	/**
	 * 转换字符串为日期和时间
	 * 
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static Date getFormatDateOnDayAndTime(String s) {
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = simpleDateFormat.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 转换时间字符串为日期和时间
	 * 
	 * @param s
	 * @return
	 */
	public static Date getFormatTime(String s) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
			return simpleDateFormat.parse(s);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取前几天的日期字符串(yyyy-MM-dd)格式;
	 * 
	 * @param num
	 * @return
	 * @throws Exception
	 */
	public static String getPriorDayDateStr(int num) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = Calendar.getInstance();
		date.set(Calendar.DATE, date.get(Calendar.DATE) - num);
		String beforeDate = dft.format(date.getTime());
		return beforeDate;
	}
	
	
	public static String getPriorMinuteDateStr(int num) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = Calendar.getInstance();
		date.set(Calendar.MINUTE, date.get(Calendar.MINUTE) - num);
		String beforeDate = dft.format(date.getTime());
		return beforeDate;
	}

	/**
	 * 返回 yyyy-MM-dd格式的cDate的前num
	 * 
	 * @param cDate
	 *            yyyy-MM-dd
	 * @param num
	 * @return
	 */
	public static String getPriorDayDateStr(String cDate, int num) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = Calendar.getInstance();
		try {
			date.setTime(getFormatDateOnDay(cDate));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		date.set(Calendar.DATE, date.get(Calendar.DATE) - num);
		String beforeDate = dft.format(date.getTime());
		return beforeDate;
	}
	
	/**
	 * 获取前num天的日期（时间格式为：yyyy-MM-dd HH:mm:ss）
	 * @param cDate
	 * @param num
	 * @return
	 */
	public static Date getPriorDayTime(String cDate, int num) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar date = Calendar.getInstance();
		try {
			date.setTime(dft.parse(cDate));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		date.set(Calendar.DATE, date.get(Calendar.DATE) - num);
		return date.getTime();
	}

	/**
	 * 获取前num天的日期(time限定为:00:00:00)
	 * 
	 * @param num
	 * @return
	 */
	public static Date getPriorDayDate(int num) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = Calendar.getInstance();
		date.set(Calendar.DATE, date.get(Calendar.DATE) - num);
		String beforeDate = dft.format(date.getTime()) + " 00:00:00";
		Date fdate = null;
		try {
			fdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(beforeDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fdate;
	}

	public static Date getPriorDayLastTime(int num) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = Calendar.getInstance();
		date.set(Calendar.DATE, date.get(Calendar.DATE) - num);
		String beforeDate = dft.format(date.getTime()) + " 23:59:59";
		Date fdate = null;
		try {
			fdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(beforeDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fdate;
	}

	/**
	 * 获取后几天的日期
	 * 
	 * @param num
	 * @return
	 */
	public static Date getNextDayDate(int num) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = Calendar.getInstance();
		date.set(Calendar.DATE, date.get(Calendar.DATE) + num);
		String nextDate = dft.format(date.getTime()) + " 00:00:00";
		Date ndate = null;
		try {
			ndate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(nextDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ndate;
	}

	/**
	 * 获取cDate后num天的日期(time为:00:00:00)
	 * 
	 * @param num
	 * @return
	 */
	public static Date getNextDayDate(Date cDate, int num) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = Calendar.getInstance();
		try {
			date.setTime(cDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		date.set(Calendar.DATE, date.get(Calendar.DATE) + num);
		String nextDate = dft.format(date.getTime()) + " 00:00:00";
		Date ndate = null;
		try {
			ndate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(nextDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ndate;
	}
	
	/**
	 * 获取cDate后num天的日期(time为:00:00:00)
	 * 
	 * @param num
	 * @return
	 */
	public static String getNextDayDate(String cDate, int num) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = Calendar.getInstance();
		try {
			date.setTime(getFormatDateOnDay(cDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		date.set(Calendar.DATE, date.get(Calendar.DATE) + num);
		String beforeDate = dft.format(date.getTime());
		return beforeDate;
	}

	/**
	 * 获取今年第一天的日期
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Date getCurYearFristDate() throws Exception {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar date = Calendar.getInstance();
		String beforeDate = date.get(Calendar.YEAR) + "-01-01 00:00:00";
		return dft.parse(beforeDate);
	}

	/**
	 * 时间转换
	 * 
	 * @param year
	 * @param month
	 * @param date
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	public static long Time2Long(int year, int month, int date, int hour, int minute, int second) {
		Calendar cld = Calendar.getInstance();
		month = month - 1;
		cld.set(year, month, date, hour, minute, second);
		return cld.getTime().getTime();
	}

	/**
	 * 格式化日期(返回yyyy-MM-dd)
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String getFormatDate(Date date) {
		String formatDate = "";
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			formatDate = simpleDateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formatDate;
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getFormatDate(Date date, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}

	/**
	 * 返回两个日期相差的天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static int getDistDates(Date startDate, Date endDate) {
		long totalDate = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		long timestart = calendar.getTimeInMillis();
		calendar.setTime(endDate);
		long timeend = calendar.getTimeInMillis();
		totalDate = Math.abs((timeend - timestart)) / (1000 * 60 * 60 * 24);
		return (int) totalDate;
	}
	
	/**
	 * 返回两个日期相差的小时
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static int getDistHours(Date startDate, Date endDate) {
		long totalDate = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		long timestart = calendar.getTimeInMillis();
		calendar.setTime(endDate);
		long timeend = calendar.getTimeInMillis();
		totalDate = Math.abs((timeend - timestart)) / (1000 * 60 * 60);
		return (int) totalDate;
	}

	/**
	 * 获得指定格式的日期字符串
	 * 
	 * @return
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

	/**
	 * 给指定的时间串 time 加 mm 分钟 返回 fmt 的串
	 * 
	 * @param time
	 * @param mm
	 * @return
	 */
	public static String getAddMinutes(String time, String mm, String fmt) {

		String sTime = "";
		SimpleDateFormat formatter = new SimpleDateFormat(fmt);
		SimpleDateFormat sdf = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
		Date d1 = null;
		try {
			int iAdd = Integer.parseInt(mm);
			d1 = formatter.parse(time);
			long lRst = d1.getTime() + iAdd * 60 * 1000;
			sdf.applyPattern(fmt);
			sTime = sdf.format(new Date(lRst));

		} catch (ParseException e) {
			System.out.println("unparseable using " + formatter);
		}
		return sTime;
	}

	/**
	 * 根据endDate是在startDate之后、同一天、之前,返回正整数、0、负整数; <br/>
	 * 计算方式:(eDate.getTime() - sDate.getTime()) / (1000 * 60 * 60 * 24);<br/>
	 * 
	 * @param startDate
	 *            格式yyyy-MM-dd
	 * @param endDate
	 *            格式 yyyy-MM-dd
	 * @return
	 */
	public static int getDistDates(String startDate, String endDate) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Date sDate = null;
		Date eDate = null;
		try {
			sDate = dft.parse(startDate);
			eDate = dft.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long num = (eDate.getTime() - sDate.getTime()) / (1000 * 60 * 60 * 24);
		return (int) num;
	}

	public static int getDistDateSecs(String startDate, String endDate) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date sDate = null;
		Date eDate = null;
		try {
			sDate = dft.parse(startDate);
			eDate = dft.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long num = (eDate.getTime() - sDate.getTime()) / (1000);
		return (int) num;
	}
	
	public static int getDistDateHours(String startDate, String endDate) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH");
		Date sDate = null;
		Date eDate = null;
		try {
			sDate = dft.parse(startDate);
			eDate = dft.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long num = (eDate.getTime() - sDate.getTime()) / (1000 * 60 * 60);
		return (int) num;
	}

	/**
	 * 根据startDate得到num小时之前的开始时间;XX:00:00
	 * 
	 * @param num
	 * @param startDate
	 *            格式:yyyy-MM-dd HH
	 * @return
	 */
	public static Date getPriorHourStartTime(int num, String startDate) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH");
		Calendar date = Calendar.getInstance();
		date.setTime(getFormatDateOnDay(startDate, "yyyy-MM-dd HH"));
		date.add(Calendar.HOUR_OF_DAY, -num);
		String beforeDate = dft.format(date.getTime()) + ":00:00";
		Date fdate = null;
		try {
			fdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(beforeDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fdate;
	}
	
	
	/**
	 * 根据startDate得到num小时之前的开始时间;XX:00:00
	 * 
	 * @param num
	 * @param startDate
	 *            格式:yyyy-MM-dd HH
	 * @return
	 */
	public static String getPriorHourDateTime(int num, String startDate) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar date = Calendar.getInstance();
		date.setTime(getFormatDateOnDay(startDate, "yyyy-MM-dd HH:mm:ss"));
		date.add(Calendar.HOUR_OF_DAY, -num);
		String beforeDate = dft.format(date.getTime());
		return beforeDate;
	}
	
	/**
	 * 根据startDate得到num小时之前的开始时间;XX:00:00
	 * 
	 * @param num
	 * @param startDate
	 *            格式:yyyy-MM-dd HH
	 * @return
	 */
	public static String getPriorDayDateTime(int num, String startDate) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar date = Calendar.getInstance();
		date.setTime(getFormatDateOnDay(startDate, "yyyy-MM-dd HH:mm:ss"));
		date.add(Calendar.DAY_OF_MONTH, -num);
		String beforeDate = dft.format(date.getTime());
		return beforeDate;
	}
	

	/**
	 * 根据startDate得到num小时之前的结束时间;XX:59:59
	 * 
	 * @param num
	 * @param startDate
	 *            格式:yyyy-MM-dd HH
	 * @return
	 */
	public static Date getPriorHourEndTime(int num, String startDate) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH");
		Calendar date = Calendar.getInstance();
		date.setTime(getFormatDateOnDay(startDate, "yyyy-MM-dd HH"));
		date.add(Calendar.HOUR_OF_DAY, -num);
		String beforeDate = dft.format(date.getTime()) + ":59:59";
		Date fdate = null;
		try {
			fdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(beforeDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fdate;
	}

	public static Date getPriorHourStartTime(int num) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH");
		Calendar date = Calendar.getInstance();
		date.add(Calendar.HOUR_OF_DAY, -num);
		String beforeDate = dft.format(date.getTime()) + ":00:00";
		Date fdate = null;
		try {
			fdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(beforeDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fdate;
	}

	public static Date getPriorHourEndTime(int num) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH");
		Calendar date = Calendar.getInstance();
		date.add(Calendar.HOUR_OF_DAY, -num);
		String beforeDate = dft.format(date.getTime()) + ":59:59";
		Date fdate = null;
		try {
			fdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(beforeDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fdate;
	}

	/**
	 * 得到startTime的num天前的日期：yyyy-MM-dd 00:00:00
	 * 
	 * @param num
	 * @param startTime
	 * @return
	 */
	public static Date getPriorDayStartTime(int num, Date startTime) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = Calendar.getInstance();
		if (startTime != null) {
			date.setTime(startTime);
		}
		date.add(Calendar.DATE, -num);
		String beforeDate = dft.format(date.getTime()) + " 00:00:00";
		Date fdate = null;
		try {
			fdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(beforeDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fdate;
	}

	/**
	 * 得到startTime的num天前的日期：yyyy-MM-dd 23:59:59
	 * 
	 * @param num
	 * @param startTime
	 * @return
	 */
	public static Date getPriorDayEndTime(int num, Date startTime) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = Calendar.getInstance();
		if (startTime != null) {
			date.setTime(startTime);
		}
		date.add(Calendar.DATE, -num);
		String beforeDate = dft.format(date.getTime()) + " 23:59:59";
		Date fdate = null;
		try {
			fdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(beforeDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fdate;
	}

	public static int getDayOfWeek(Date date) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(date);
		int x = aCalendar.get(Calendar.DAY_OF_WEEK);
		return x;
	}

	public static String getFristDayOfWeek() {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String week_strat = df.format(c.getTime());
		return week_strat;
	}

	public static String getLastDayOfWeek() {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String week_strat = df.format(c.getTime());
		return week_strat;
	}

	public static String getFristDayOfWeek(String cDate) {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
		try {
			c.setTime(getFormatDateOnDay(cDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String week_strat = df.format(c.getTime());
		return week_strat;
	}

	public static String getLastDayOfWeek(String cDate) {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
		try {
			c.setTime(getFormatDateOnDay(cDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String week_strat = df.format(c.getTime());
		return week_strat;
	}

	public static int getHourOfDay(Date date) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(date);
		int x = aCalendar.get(Calendar.HOUR_OF_DAY);
		return x;
	}

	public static int getDayOfMonth(Date date) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(date);
		int x = aCalendar.get(Calendar.DAY_OF_MONTH);
		return x;
	}

	/**
	 * 获得系统当前完整时间:yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getNowDateTime() {
		SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return fdate.format(new Date());
	}

	/**
	 * 返回时间字符串:yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getDateTimeStr(Date date) {
		SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return fdate.format(date);
	}

	/**
	 * 返回某天所在月共有多少天.
	 * 
	 * @param date
	 *            yyyy-MM-dd格式
	 * @return
	 */
	public static int getDaysCountInMonth(String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(DateUtils.getFormatDateOnDay(date));
		return cal.getActualMaximum(Calendar.DATE);
	}

	/**
	 * 当天在当月的比例值，比如10月10日记为(10*100/31)%
	 * 
	 * @param date
	 *            yyyy-MM-dd格式
	 * @return
	 */
	public static String getDaysProcessInMonth(String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(DateUtils.getFormatDateOnDay(date));
		DecimalFormat df = new DecimalFormat("00.00%");
		return df.format((cal.get(Calendar.DATE) * 1.0D) / cal.getActualMaximum(Calendar.DATE));
	}

	/**
	 * 返回某天离当月最后一天还剩多少天;
	 * 
	 * @param date
	 *            yyyy-MM-dd格式
	 * @return
	 */
	public static int getRemainDaysInMonth(String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(DateUtils.getFormatDateOnDay(date));
		return cal.getActualMaximum(Calendar.DATE) - cal.get(Calendar.DATE);
	}

	/**
	 * 返回某天的中文星期几;
	 * 
	 * @param date
	 *            yyyy-MM-dd格式
	 * @param isShortFormat
	 *            true时表示只返回[日-六];false时返回完整的[星期日-星期六]
	 * @return
	 */
	public static String getWeekdayInChinese(String date, boolean isShortFormat) {
		String[] week_day = new String[] { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		String[] week_day_short = new String[] { "日", "一", "二", "三", "四", "五", "六" };

		Calendar cal = Calendar.getInstance();
		cal.setTime(DateUtils.getFormatDateOnDay(date));
		// 1到7对应星期日到星期六
		return isShortFormat ? week_day_short[cal.get(Calendar.DAY_OF_WEEK) - 1] : week_day[cal.get(Calendar.DAY_OF_WEEK) - 1];
	}

	/**
	 * 返回本季度的第1天,格式yyyy-MM-dd 00:00:00
	 * 
	 * @param now_date
	 *            yyyy-MM-dd 格式
	 * @return
	 */
	public static Date getFirstDayTimeOfThisQuarter(String now_date) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Date date_result = null;
		try {
			Date date = dft.parse(now_date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);// 第1月为0
			if ((month >= 0) && (month <= 2)) {
				cal.set(Calendar.MONTH, 0);
				cal.set(Calendar.DAY_OF_MONTH, 1);
				date_result = cal.getTime();
			}
			if ((month >= 3) && (month <= 5)) {
				cal.set(Calendar.MONTH, 3);
				cal.set(Calendar.DAY_OF_MONTH, 1);
				date_result = cal.getTime();
			}
			if ((month >= 6) && (month <= 8)) {
				cal.set(Calendar.MONTH, 6);
				cal.set(Calendar.DAY_OF_MONTH, 1);
				date_result = cal.getTime();
			}
			if ((month >= 9) && (month <= 11)) {
				cal.set(Calendar.MONTH, 9);
				cal.set(Calendar.DAY_OF_MONTH, 1);
				date_result = cal.getTime();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date_result;

	}

	/**
	 * 返回本月的第1天,格式yyyy-MM-dd 00:00:00
	 * 
	 * @param now_date
	 *            yyyy-MM-dd 格式
	 * @return
	 */
	public static Date getFirstDayTimeOfThisMonth(String now_date) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(dft.parse(now_date));
			cal.set(Calendar.DAY_OF_MONTH, 1);
			date = cal.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 返回date所在季度的总天数;
	 * 
	 * @param now_date
	 *            yyyy-MM-dd 格式
	 * @return
	 */
	public static int getQuarterDaysCount(String now_date) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		int all_count = 0;
		try {
			Date date = dft.parse(now_date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);// 第1月为0
			if ((month >= 0) && (month <= 2)) {
				cal.set(Calendar.MONTH, 1);// 变态的2月
				cal.set(Calendar.DAY_OF_MONTH, 1);
				all_count = 31 + getDaysCountInMonth(dft.format(cal.getTime())) + 31;
			}
			if ((month >= 3) && (month <= 5)) {
				all_count = 30 + 31 + 30;
			}
			if ((month >= 6) && (month <= 8)) {
				all_count = 31 + 31 + 30;
			}
			if ((month >= 9) && (month <= 11)) {
				all_count = 31 + 30 + 31;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return all_count;
	}
	
	public static boolean isSameMonth(String date1, String date2){
		Calendar date = Calendar.getInstance();
		try {
			date.setTime(getFormatDateOnDay(date1));
			int month = date.get(Calendar.MONTH);
			date.setTime(getFormatDateOnDay(date2));
			int month2 = date.get(Calendar.MONTH);
			return month == month2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static String[] getFiscalExtrems(String date){
		Integer year = Integer.valueOf(date.substring(0, 4));
		String monthAndDay = date.substring(5);
		if(monthAndDay.compareTo("04-01") >= 0){
			return new String[]{year + "-04-01", (year+1) + "-03-31"};
		}else if(monthAndDay.compareTo("03-31") <= 0){
			return new String[]{(year-1) + "-04-01", year + "-03-31"};
		}
		return new String[]{"2015-04-01","2016-03-31"};
	}
	
	public static int getDaysInFiscalYear(String statDate){
		Date curDate = getFormatDateOnDay(statDate);
		int days = getDayOfMonth(curDate);
		
		while(curDate.getMonth()!=3){ //
			String priorMonthDate = getPriorMonthStr(curDate,1);
			String firstDayOfMonth = priorMonthDate+"-01";
			
			days += getDaysCountInMonth(firstDayOfMonth);
			
			curDate = getFormatDateOnDay(firstDayOfMonth);
		}
		return days;
	}
	
	
	public static String[] getDatesByWeekOfYear(int year,int weekOfYear){
		   Calendar gregorianCalendar = new GregorianCalendar();  
	       gregorianCalendar.setMinimalDaysInFirstWeek(1);  
	         
	       gregorianCalendar.set(Calendar.YEAR , year);  
	       gregorianCalendar.set(Calendar.WEEK_OF_YEAR , weekOfYear);  
	       
	       gregorianCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	       
	       String startDate = DateUtils.getFormatDate(gregorianCalendar.getTime());
	       
	       String endDate = getLastDayOfWeek(startDate);
	       
	       return new String[]{startDate,endDate};
		}
		
		
		public static String[] getDatesByWeekOfYear2(int year,int weekOfYear){
			   Calendar gregorianCalendar = new GregorianCalendar();  
		       gregorianCalendar.setMinimalDaysInFirstWeek(6);  
		         
		       gregorianCalendar.set(Calendar.YEAR , year);  
		       gregorianCalendar.set(Calendar.WEEK_OF_YEAR , weekOfYear);  
		       
		       gregorianCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		       
		       String startDate = DateUtils.getFormatDate(gregorianCalendar.getTime());
		       
		       String endDate = getLastDayOfWeek(startDate);
		       
		       return new String[]{startDate,endDate};
			}

	public static void main(String[] args) throws Exception {
		
//		int week = getWeekdayStartFromOne("2014-09-11");
//		System.out.println("week: " + week);
//		Date bindDate = DateUtils.getFormatDateOnDayAndTime("2008-01-10 00:00:00");
//		Date payDate = DateUtils.getFormatDateOnDayAndTime("2009-12-01 00:00:00");
//		
//		int dayNum = DateUtils.getDistDates(bindDate, payDate);
//		System.out.println(DateUtils.getDistDates("2018-01-10 00:00:00", "2009-12-01 00:00:00"));
		
//		System.out.println(getPriorHourDateTime(1, "2015-03-25 00:23:11"));
//		System.out.println(getPriorDayDateTime(1, "2015-03-25 00:23:11"));
		
		String[] wkExtrems = DateUtils.getDatesByWeekOfYear(2015,14);
		System.out.println("days of: " +wkExtrems[0] + "\t" + wkExtrems[1]);
//		System.out.println("days of: " +getDaysInFiscalYear("2015-05-11"));
		
		
		System.out.println(getPriorMinuteDateStr(1000));
		
//		System.out.println("prior1Month: " + getPriorMonthStr(getFormatDateOnDay("2015-03-29"), 1));
//		System.out.println(Math.pow(10, 2));
//		
//		for(int i=1; i< 100; i++){
//			double ratio = i*0.01;
//			int base = 650;
//			
//			double result = 0;
//			StringBuilder sb = new StringBuilder();
//			for(int j = 1 ; j<= 12 ; j++){
//				double tmp = base*Math.pow(1+ratio, j);
//				sb.append(tmp).append("\t");
//				result += tmp;
//			}
//			
//			System.out.println(String.format("ratio: %d result: %f\t" +sb.toString(), i,result));
//			
//		}
		
	}
}
