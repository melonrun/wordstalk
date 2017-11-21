package com.wordstalk.translate.common.util.core;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

public class Functions {
	private static java.text.NumberFormat nf = java.text.NumberFormat.getInstance();   
	static {
		nf.setGroupingUsed(false);  
	}
	
	public static String getRealValue(Object v1){
		if(v1==null){
			return "";
		}
		try{
			return nf.format(v1);
		}catch(Exception e){
			
		}
		return String.valueOf(v1);
		
		
	}
	public static boolean validateStartWith(String srcStr, String subStr) {
		boolean flag = false;
		if (StringUtils.isNotBlank(srcStr)
				&& StringUtils.isNotBlank(subStr)
				&& StringUtils.startsWith(srcStr.toLowerCase(), subStr
						.toLowerCase())) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 得到两数相除后的百分数，精确小数点2位 return 100.00
	 * 
	 * @param list
	 * @return
	 */
	public static Double getRatio(Double v1, Double v2) {
		if (v2.intValue() != 0) {
			double t = ArithUtil.div(v1, v2, 4);
			return ArithUtil.mul(t, 100);
		} else {
			return 100d;
		}
	}
	
	public static String countDiv(Object v1, Object v2){
		if(v1 == null || v2 ==null)
			return "0.00";
		else{
			Double value1 = Double.parseDouble(v1.toString());
			Double value2 = Double.parseDouble(v2.toString());
			Double result = 0d;
			if(value2.intValue() != 0)
				result = ArithUtil.div(value1, value2, 2);
			return String.valueOf(result);
		}
	}
	
	//---------------------------------------游戏收益报表使用----------------------------------------------------------------
	/**
	 * 得到两数相除后的百分数，精确小数点2位 return 100.00
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String getRatioByLong(Long v1, Long v2) {
		return String.valueOf(getRatio(v1 * 1.0, v2 * 1.0));
	}

	public static String getRatioByLongFormat(Long v1, Long v2) {
		if (v1 == null || v2 == null || v1.equals(0L) || v2.equals(0L)) {
			return "";
		} else {
			return getRatioByLong(v1, v2) + "%";
		}
	}

	public static String getRealMoney(Double put, Double get) {
		if (put == null || get == null || put.equals(0D) || get.equals(0D)) {
			return "";
		} else {
			return new DecimalFormat("0.00").format(get * 0.6d - put); // TODO
																		// 按固定分成0.6计算
		}
	}

	public static String getAvgPut(Double put, Long num) {
		if (put == null || num == null || num.equals(0L) || put.equals(0D)) {
			return "";
		} else {
			return new DecimalFormat("0.00").format(put / (num * 1.0d));
		}
	}

	//---------------------------------------游戏适应性分析报表使用--------------------------------------------------------	
	/**
	 * CPA :pay_all/bind_all
	 * @param pay_all 成本
	 * @param bind_all 注册数
	 * @return
	 */
	public static String cpa(Double pay_all,Long bind_all){
		if (pay_all == null || bind_all == null || bind_all.equals(0L)) {
			return "";
		} else {
			return new DecimalFormat("0.00").format(pay_all / (bind_all * 1.0d));
		}
	}
	
	/**
	 * 次登率:second_login_all/bind_all
	 * @param second_login_all 次登数
	 * @param bind_all 注册数
	 * @return
	 */
	public static String secondLoginRate(Long second_login_all,Long bind_all){
		return payRate(second_login_all, bind_all);
	}
	
	/**
	 * 次登成本:cost/second_login_all
	 * @param cost 成本
	 * @param second_login_all 次登数
	 * @return
	 */
	public static String secondLoginCost(Double cost,Long second_login_all){
		return cpa(cost, second_login_all);
	}
	
	/**
	 * 付费率:pay_all/bind_all
	 * @param pay_all 付费人数
	 * @param bind_all 注册人数
	 * @return
	 */
	public static String payRate(Long pay_all,Long bind_all){
		if (pay_all == null || bind_all == null || bind_all.equals(0L)) {
			return "";
		} else {
			return getRatioByLong(pay_all, bind_all) + "%";
		}
	}
	
	/**
	 * 付费用户成本:cost/pay_all
	 * @param cost 成本
	 * @param pay_all 充值人数
	 * @return
	 */
	public static String payUserCost (Double cost,Long pay_all){
		return cpa(cost, pay_all);
	}
	
	/**
	 * ROI:pay/cost
	 * @param pay 充值金额
	 * @param cost 成本
	 * @return
	 */
	public static String roi(Double pay,Double cost){
		if(pay==null||cost==null||cost.equals(0D)){
			return "";
		}
		return String.valueOf(getRatio(pay, cost))+"%";
	}
	
	/**
	 * ARPU值:pay/pay_all
	 * @param pay 充值金额
	 * @param pay_all 充值人数
	 * @return
	 */
	public static String arpu(Double pay,Long pay_all){
		return cpa(pay,pay_all);
	}
	
	/**
	 * 千人付费金额 : (pay_all/bind_all)*1000
	 * @param pay_all 充值金额
	 * @param bind_all 注册数
	 * @return
	 */
	public static String thousandPersonsPay(Double pay_all ,Long bind_all){
		if(pay_all==null||bind_all==null||bind_all.equals(0L)){
			return "";
		}
		return  new DecimalFormat("0.00").format((pay_all*1.0d/bind_all)*1000.0d);
	}
	
	/**
	 * 外投KPI=(ROI*0.7+付费率*0.3)*100=(充值金额/成本*0.7+付费人数/注册人数*0.3)*100
	 * @param pay 充值金额
	 * @param cost 成本
	 * @param pay_all 充值人数
	 * @param bind_all 注册数
	 * @return
	 */
	public static String kpiOfOuter(Double pay,Double cost,Long pay_all,Long bind_all){
		if(pay==null||cost==null||pay_all==null||bind_all==null||cost.equals(0D)||bind_all.equals(0L)){
			return "";
		}
		return  new DecimalFormat("0.00").format((pay*1.0d/cost*0.7+pay_all*1.0d/bind_all*0.3)*100.0d);
	}
	
	/**
	 * 内部资源KPI(包括SEM)=(千人付费金额/100000*0.7+付费率*0.3)*1000=((充值金额/注册数)*1000/100000*0.7+付费人数/注册人数*0.3)*1000
	 * @param pay
	 * @param pay_all
	 * @param bind_all
	 * @return
	 */
	public static String kpiOfInner(Double pay ,Long pay_all,Long bind_all){
		if(pay==null||pay_all==null||bind_all==null||bind_all.equals(0L)){
			return "";
		}
		return  new DecimalFormat("0.00").format(((pay*1.0d/bind_all)*1000d/100000d*0.7+pay_all*1.0d/bind_all*0.3)*1000.0d);
	}
	
	public static String cnTime(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat sf = new SimpleDateFormat();
		sf.applyPattern("yyyy-MM-dd HH:mm");
		return sf.format(date);
	}

	public static String getTimeStr(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat sf = new SimpleDateFormat();
		sf.applyPattern("yyyy-MM-dd HH:mm:ss");
		return sf.format(date);
	}

	public static int cSortNum(int rowNum, int pageSize, int pageNum) {
		return rowNum + 1 + pageSize * pageNum;
	}


	public static Double trimDouble(Double d, Integer num) {
		BigDecimal a = new BigDecimal(d);
		return a.setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static String cnTimeFromLong(long millis) {
		Date date = new Date(millis);
		return cnTime(date);
	}

	/**
	 * 获取日期的中文年月日格式
	 * 
	 * @param date
	 * @return
	 */
	public static String cnDate(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat sf = new SimpleDateFormat();
		sf.applyPattern("yyyy\u5E74MM\u6708dd\u65E5");
		return sf.format(date);
	}

	/**
	 * 获取日期的标准显示格式
	 * 
	 * @param date
	 * @return
	 */
	public static String enDate(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat sf = new SimpleDateFormat();
		sf.applyPattern("yyyy-MM-dd");
		return sf.format(date);
	}
	
}
