package com.wordstalk.translate.common.util;

import java.util.regex.Pattern;

import com.wordstalk.translate.common.vo.*;
import org.apache.commons.lang3.StringUtils;

import com.wordstalk.translate.common.vo.param.VerifyVO;

public class VerifyUtil {

	public static VerifyVO verifyCustomer(CustomerVO vo){
		if (vo != null) {
			if (!StringUtils.isNotEmpty(vo.getCustomerName().trim()))
				return new VerifyVO(false, "客户名称不能为空.");
			if (!StringUtils.isNotEmpty(vo.getManagerName().trim()))
				return new VerifyVO(false, "客户经理不能为空.");

			return new VerifyVO(true, "");
		} else {
			return new VerifyVO(false, "数据为空");
		}
	}

	public static VerifyVO verifyTranslator(TranslatorVO vo) {
		if (vo != null) {
			/* 1.验证必须字段 */
			if (!StringUtils.isNotEmpty(vo.getName().trim()))
				return new VerifyVO(false, "译员姓名不能为空.");
//			if (vo.getLevel() == null || vo.getLevel() < 1 || vo.getLevel() > 4)
//				return new VerifyVO(false, "译员级别数据错误.");
			if (!StringUtils.isNotEmpty(vo.getName().trim()))
				return new VerifyVO(false, "译员背景不能为空.");

			/* 2.验证其他字段 */
			if (StringUtils.isNotEmpty(vo.getTelephone().trim())) {
				if (!vo.getTelephone().matches("^(1[0-9])\\d{9}$"))
					return new VerifyVO(false, "译员手机号格式错误");
			}

			if (StringUtils.isNotEmpty(vo.getEmail().trim())) {
				if (!vo.getEmail()
						.matches(
								"^([a-z0-9A-Z]+[_-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"))
					return new VerifyVO(false, "译员邮箱错误");
			}

			return new VerifyVO(true, "");
		} else {
			return new VerifyVO(false, "数据为空");
		}
	}

	public static void main(String[] args) {
		System.out
				.println("_a@a.com"
						.matches("([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,5})+")
						+ "111");
	}

	public static VerifyVO verifyProject(ProjectVO vo) {
		if (vo != null) {
			if (!StringUtils.isNotEmpty(vo.getProjectName().trim()))
				return new VerifyVO(false, "项目名称不能为空.");
			if (!StringUtils.isNotEmpty(vo.getCustomerName().trim()))
				return new VerifyVO(false, "客户名称不能为空.");
			if (!StringUtils.isNotEmpty(vo.getLanguageFrom().trim()))
				return new VerifyVO(false, "项目源语言不能为空.");
			if (!StringUtils.isNotEmpty(vo.getLanguageTo().trim()))
				return new VerifyVO(false, "项目目标语言不能为空.");

			return new VerifyVO(true, "");
		} else {
			return new VerifyVO(false, "数据为空");
		}
	}

	public static VerifyVO verifyProjectPart(ProjectPartVO vo) {
		if (vo != null) {
			if (!StringUtils.isNotEmpty(vo.getPartName().trim()))
				return new VerifyVO(false, "区块名称不能为空.");
			if (!StringUtils.isNotEmpty(vo.getTranslatorId().trim())
					&& isInteger(vo.getTranslatorId()))
				return new VerifyVO(false, "译员不能为空.");
			if (!StringUtils.isNotEmpty(vo.getStartDate().trim()))
				return new VerifyVO(false, "开始时间不能为空.");
			if (!StringUtils.isNotEmpty(vo.getEndDate().trim()))
				return new VerifyVO(false, "结束时间不能为空.");
			if (vo.getStatus() != -1 && vo.getStatus() != 1)
				return new VerifyVO(false, "结算状态设置错误.");
			if (vo.getPartType() !=1 && vo.getPartType() != 2)
				return new VerifyVO(false, "区块类型错误。");

			return new VerifyVO(true, "");
		} else {
			return new VerifyVO(false, "数据为空");
		}
	}

	public static VerifyVO verifyProjectAdmin(ProjectAdminVO vo) {
		if (vo != null) {
			// if (vo.getChargeStd() == null) {
			// return new VerifyVO(false, "收费标准不能为空.");
			// }
			if (vo.getProjectIncome() == null) {
				return new VerifyVO(false, "项目收入不能为空.");
			}
			if (vo.getTranCost() == null) {
				return new VerifyVO(false, "译员稿费不能为空.");
			}
			if (vo.getManageCost() == null) {
				return new VerifyVO(false, "管理费不能为空.");
			}
			if (vo.getSaleCommission() == null) {
				return new VerifyVO(false, "销售提成不能为空.");
			}
			if (vo.getProjectProfit() == null) {
				return new VerifyVO(false, "项目利润不能为空.");
			}
			if (vo.getProfitRatio() == null) {
				return new VerifyVO(false, "利润率不能为空.");
			}
			if (vo.getAccountStatus() == null) {
				return new VerifyVO(false, "客户款到账不能为空.");
			}

			return new VerifyVO(true, "");
		} else {
			return new VerifyVO(false, "数据为空");
		}
	}

	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	public static boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			if (value.contains("."))
				return true;
			return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isNumber(String value) {
		return isInteger(value) || isDouble(value);
	}
}
