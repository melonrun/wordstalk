package com.wordstalk.translate.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 格式化相关工具类
 * 
 * @author liqiang17
 * 
 */
public final class FormatUtils {
	
	
	public static float formatDouble(double dVal,int scale){
		BigDecimal bd = new BigDecimal(dVal).setScale(scale,BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}

	// ############################################[日期相关]#################################################
	/**
	 * 将yyyy-MM-dd[ HH:mm:ss]格式成标准的日期格式yyyy-MM-dd
	 * 
	 * @param datetime
	 * @return
	 */
	public static String my_date_format_only_date(String datetime) {
		return datetime.split("\\s")[0];
	}

	/**
	 * 返回本季度最后1天结束时间,格式yyyy-MM-dd 23:59:59
	 * 
	 * @param now_date
	 *            yyyy-MM-dd 格式
	 * @return
	 */
	public static Date getLastDayTimeOfThisQuarter(String now_date) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = dft.parse(now_date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);// 第1月为2
			if ((month >= 0) && (month <= 2)) {
				cal.set(Calendar.MONTH, 2);
				cal.set(Calendar.DAY_OF_MONTH, 31);
			}
			if ((month >= 3) && (month <= 5)) {
				cal.set(Calendar.MONTH, 5);
				cal.set(Calendar.DAY_OF_MONTH, 30);
			}
			if ((month >= 6) && (month <= 8)) {
				cal.set(Calendar.MONTH, 8);
				cal.set(Calendar.DAY_OF_MONTH, 30);
			}
			if ((month >= 9) && (month <= 11)) {
				cal.set(Calendar.MONTH, 11);
				cal.set(Calendar.DAY_OF_MONTH, 31);
			}
			String beforeDate = dft.format(cal.getTime()) + " 23:59:59";
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(beforeDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	// ############################################[数字相关]#################################################
	/**
	 * 红升绿降:[+-](base-target)/target%
	 * 
	 * @param base
	 * @param target
	 * @return
	 */
	public static String getRate(Long base, Long target) {
		if (base == null || target == null)
			return "";
		long base_int = base;
		long target_int = target;
		if (base_int == 0L || target_int == 0L)
			return "";
		double rate = (base - target) * 100.0d / target;
		DecimalFormat df = new DecimalFormat("0.00");
		if (rate <= 0) {
			return "<font style='color:green'>" + df.format(rate) + "%</font>";
		} else {
			return "<font style='color:red'>+" + df.format(rate) + "%</font>";
		}
	}

	/**
	 * 红升绿降:[+-](base-target)/target%
	 * 
	 * @param base
	 * @param target
	 * @return
	 */
	public static String getRate(Double base, Double target) {
		if (base == null || target == null)
			return "";
		double base_int = base;
		double target_int = target;
		if (base_int == 0D || target_int == 0D)
			return "";
		double rate = (base - target) * 100.0d / target;
		DecimalFormat df = new DecimalFormat("0.00");
		if (rate <= 0) {
			return "<font style='color:green'>" + df.format(rate) + "%</font>";
		} else {
			return "<font style='color:red'>+" + df.format(rate) + "%</font>";
		}
	}



	/**
	 * 如果value>=base则返回标红的value;否则返回标绿的value;
	 * 
	 * @param value
	 *            格式00.00%
	 * @param base
	 *            格式00.00%
	 * @return
	 */
	public static String getRatioFormatPro(String value, String base) {
		double d_value = 0d;
		double d_base = 0d;
		try {
			d_value = Double.valueOf(value.replaceAll("%", ""));
			d_base = Double.valueOf(base.replaceAll("%", ""));
			if (d_value >= d_base) {
				return "<font style='color:red'>" + round(d_value, 1) + "%</font>";
			} else {
				return "<font style='color:green'>" + round(d_value, 1) + "%</font>";
			}
		} catch (Exception e) {
			return value;
		}
	}

	/**
	 * 返回只保留小数点后1位,四舍五入方法.返回00.0%
	 * 
	 * @param value
	 *            格式00.00%
	 * @return
	 */
	public static String getDoubleFormat45(String value) {
		double d_value = 0d;
		try {
			d_value = Double.valueOf(value.replaceAll("%", ""));
			return round(d_value, 1) + "%";
		} catch (Exception e) {
			return value;
		}
	}

	public static String round(double v, int scale) {
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return String.valueOf(b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue());
	}

	/**
	 * 返回v1/v2;只保留整数位(四值五入).
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String getAvgByLong(Long v1, Long v2) {
		if (v1 == null || v2 == null || v1.equals(0L) || v2.equals(0L)) {
			return "";
		}
		return String.valueOf(Math.round(v1 * 1.0d / v2));
	}

	/**
	 * 返回v1/v2;只保留整数位.
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String getAvgByDouble(Double v1, Long v2) {
		if (v1 == null || v2 == null || v1.equals(0D) || v2.equals(0L)) {
			return "";
		}
		return String.valueOf(v1 / v2);
	}

	/**
	 * 金额格式化:将输入obj格式0,000.00
	 * 
	 * @param obj
	 *            double型
	 * @return
	 */
	public static String moneyFormat(Object obj) {
		if (obj == null) {
			return "";
		}
		String str_obj = obj.toString();
		if (str_obj.equals("")) {
			return "";
		}
		if (str_obj.contains(",")) {
			return str_obj;
		}
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		// nf.setMinimumFractionDigits(2);
		return "￥" + nf.format(Double.parseDouble(str_obj)) + "元";
	}

	/**
	 * 数字格式化:将输入obj格式0,000
	 * 
	 * @param obj
	 *            long型
	 * @return
	 */
	public static String longFormat(Object obj) {
		if (obj == null) {
			return "";
		}
		String str_obj = obj.toString();
		if (str_obj.equals("")) {
			return "";
		}
		if (str_obj.contains(",")) {
			return str_obj;
		}
		
		if(obj instanceof Integer){
			int val = (Integer) obj;
			if(val==0){
				return "";
			}
		}else if(obj instanceof Long){
			long val = (Long)obj;
			if(val== 0l){
				return "";
			}
		}
		
		
		
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(0);
		nf.setMinimumFractionDigits(0);
		return nf.format(Long.parseLong(str_obj));
	}

	/**
	 * 数字格式化:将输入obj格式0,000
	 * 
	 * @param obj
	 *            double型
	 * @return
	 */
	public static String doubleFormat(Object obj) {
		if (obj == null) {
			return "";
		}
		String str_obj = obj.toString();
		if (str_obj.equals("")) {
			return "";
		}
		if (str_obj.contains(",")) {
			return str_obj;
		}
		DecimalFormat df = new DecimalFormat("###,###.##");
		return df.format(obj);
	}

	/**
	 * 数字格式化:将输入obj格式化为原型
	 * 
	 * @param obj
	 *            double型
	 * @return
	 */
	public static String prototypeFormat(Object obj) {
		if (obj == null) {
			return "";
		}
		return String.valueOf(obj);
	}

	public static void main(String[] args) {
//		String[] dates = new String[] { "2012-04-01", "2012-04-30",//
//				"2012-05-01", "2012-05-02", "2012-05-31",//
//				"2012-06-01", "2012-06-30" };
//		for (String now_date : dates) {
//			System.out.printf("%s,季度天数:%s,当前时间计数:%s,本季度进度:%s,剩余天数:%s\n",//
//					now_date,//
//					DateUtils.getQuarterDaysCount(now_date),//
//					getNowDaysInQuarter(now_date),//
//					getDaysProcessInQuarter(now_date),//
//					getRemainDaysInQuarter(now_date));
//		}
//		System.out.println("==============================================");
//		dates = new String[] {//
//		"2012-01-01", "2012-01-02", "2012-01-31",//
//				"2012-02-01", "2012-02-02", "2012-02-29",//
//				"2012-03-01", "2012-03-02", "2012-03-31",//
//				"2012-04-01", "2012-04-02", "2012-04-30",//
//				"2012-05-01", "2012-05-02", "2012-05-31",//
//				"2012-06-01", "2012-06-02", "2012-06-30",//
//				"2012-07-01", "2012-07-02", "2012-07-31",//
//				"2012-08-01", "2012-08-02", "2012-08-31",//
//				"2012-09-01", "2012-09-02", "2012-09-30",//
//				"2012-10-01", "2012-10-02", "2012-10-31",//
//				"2012-11-01", "2012-11-02", "2012-11-30",//
//				"2012-12-01", "2012-12-02", "2012-12-31" };
//		for (String now_date : dates) {
//			System.out.printf("%s,%s\n", //
//					now_date, //
//					printArray(get_month_start_dates_in_quarter_all(now_date)));//
//		}
//		System.out.println(Math.round(22.58d));
//		System.out.println(Math.round(22.3d));
//		System.out.println(Math.round(22.44d));
//		System.out.println(Math.round(22d));
//		System.out.println(Math.round(22.0d));
		
		Float f = 587185.94f;
		
		Float f1 = 596484.9f;
		Float f2 = 9298.95f ;
		
		BigDecimal bd1 = new BigDecimal(596484.9);
		BigDecimal bd2 = new BigDecimal(9298.95);
		
		System.out.println(doubleFormat(bd1.subtract(bd2)));
		
		System.out.println(doubleFormat(f1-f2));
		
//		Float f = 2.3432f;
//		System.out.println(f.floatValue());
		
		
	}

	private static String printArray(String[] parts) {
		StringBuilder sb = new StringBuilder();
		for (String part : parts) {
			sb.append("\t").append(part);
		}
		return sb.toString();
	}
}
