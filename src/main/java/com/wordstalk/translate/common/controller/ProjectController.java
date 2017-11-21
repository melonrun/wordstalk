package com.wordstalk.translate.common.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wordstalk.translate.common.service.*;
import com.wordstalk.translate.common.vo.export.AdminExportVO;
import com.wordstalk.translate.common.vo.export.PmExportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wordstalk.translate.common.util.DateUtils;
import com.wordstalk.translate.common.util.VerifyUtil;
import com.wordstalk.translate.common.vo.ConstantsField;
import com.wordstalk.translate.common.vo.ExcelSheetVO;
import com.wordstalk.translate.common.vo.JsonContent;
import com.wordstalk.translate.common.vo.ProjectVO;
import com.wordstalk.translate.common.vo.param.Page;
import com.wordstalk.translate.common.vo.param.PageParam;
import com.wordstalk.translate.common.vo.param.VerifyVO;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectAdminService projectAdminService;
	
    @Autowired
    private ExportService exportService;

	@Autowired
	private ExportProjectService exportProjectService;

	@RequestMapping("/projectPage")
	public ModelAndView projectPage(HttpServletResponse response) {
		ModelAndView view = new ModelAndView("project/project_list");
		return view;
	}
	
	@RequestMapping("/addProjectPage")
	public ModelAndView addProjectPage(HttpSession session) {
		/*
		UserVO vo = new UserVO();
		vo.setId((Integer) session.getAttribute(ConstantsField.SESSION_USER_ID));
		List<RoleVO> list = userService.queryUserRoleById(vo);
		if(list.size() > 0){
			ModelAndView view = new ModelAndView(list.get(0).getPermissions());
			return view;
		}
		return null;
		*/
		
		ModelAndView view = new ModelAndView("project/add_project");
		return view;
	}
	
	@RequestMapping("/addProjectPartPage")
	public ModelAndView addProjectPartPage(HttpServletResponse response) {
		ModelAndView view = new ModelAndView("project/add_project_part");
		return view;
	}
	
	@ResponseBody
	@RequestMapping("/projectList")
	public Object projectList(PageParam param, HttpServletResponse response,
    		HttpServletRequest request, HttpSession session) {
		String role = (String) session.getAttribute(ConstantsField.SESSION_USER_ROLE);
		Page page = this.projectService.queryProjectList(param, role.equals(ConstantsField.SESSION_VALUE_PM));
		if(page == null)
			return JsonContent.errorJson("获取失败", page);
		return JsonContent.okJson(role, page);
	}
	
	@ResponseBody
	@RequestMapping("/getProjectDetail")
	public Object getProjectDetail(ProjectVO vo, HttpSession session) {
		if(vo.getId() != null){
            String role = (String) session.getAttribute(ConstantsField.SESSION_USER_ROLE);
    		return JsonContent.okJson(role, projectService.getProjectDetail(vo));
    	}else{
    		return JsonContent.errorJson("id为空", null);
    	}
	}
	
	@ResponseBody
	@RequestMapping("/addProjectSubmit")
	public Object addProjectSubmit(ProjectVO  vo) {
		VerifyVO verifyVO = VerifyUtil.verifyProject(vo);
    	if(!verifyVO.isStatus()){
    		return JsonContent.errorJson(verifyVO.getErrorMsg(), "");
    	}else{
    		projectService.addProjectSubmit(vo);
    		Integer project_id = projectService.getLastProjectId();
            return JsonContent.okJson(project_id.toString(), null);
    	}
	}
	
	@ResponseBody
	@RequestMapping("/updateTranslatorSubmit")
	public Object updateTranslatorSubmit(ProjectVO  vo) {
		VerifyVO verifyVO = VerifyUtil.verifyProject(vo);
    	if(!verifyVO.isStatus()){
    		return JsonContent.errorJson(verifyVO.getErrorMsg(), "");
    	}else{
    		projectService.updateTranslatorSubmit(vo);
    		return JsonContent.okJson(null, null);
    	}
	}

	@ResponseBody
	@RequestMapping("/getAllCustomerName")
	public Object getAllCustomerName(){
		return JsonContent.okJson("", projectService.getAllCustomerName());
	}

	@ResponseBody
	@RequestMapping("/filterTransByProject")
	public Object filterTransByProject(ProjectVO vo){
		if(vo.getId() > 0 ){
			return JsonContent.okJson("", projectService.filterTransByProject(vo));
		}
		return JsonContent.errorJson("", "");
	}
	
    @RequestMapping("/exportAllProject")
    public Object exportAllProject( HttpServletResponse response, HttpServletRequest request,
									PageParam param) {
    	
		List<ExcelSheetVO> datas = new ArrayList<>();
		String fileName = "项目表-" + DateUtils.getCurrentDate("yyyy-MM-dd");

		if(ConstantsField.SESSION_VALUE_ADMIN.
                equals(request.getSession().getAttribute(ConstantsField.SESSION_USER_ROLE))){
			String[] titles2 = {"项目名称", "项目开始时间", "项目结束时间", "客户名称", "源语言", "目标语言", "初译总计字数",
					"审校总计字数", "不计空格字数", "项目说明", "区块类型", "区块名称", "译员名字", "区块字数",
					"稿费标准","稿费","开始时间", "结束时间", "区块备注", "是否结算", "区块结算日期", "收费标准", "项目收入",
					"初译稿费",  "审校稿费", "管理费", "销售提成", "税费", "项目利润", "利润率", "客户款到账", "到账时间",
					"备注",};
			String[] columns2 = {"projectName", "projectStartDate", "projectEndDate", "customerName", "languageFrom",
					"languageTo", "wordsCount", "reviewWordsCount", "wordsNoSpace", "projectRemarks", "partType",
					"partName", "translatorName", "wordsNum", "partSalaryStd", "partSalaryReal", "partStartDate",
					"partEndDate", "comment", "status", "settleDate", "chargeStd", "projectIncome", "tranCost",
					"reviewCost", "manageCost", "saleComm", "taxCost", "projectProfit", "profitRatio", "accountStatus",
					"adminEndDate", "saleRecord", };

			List<AdminExportVO> results2 = this.exportProjectService.adminExportVOList(param, false);
			ExcelSheetVO excelVO2 = new ExcelSheetVO();
			excelVO2.setColumns(columns2);
			excelVO2.setTitles(titles2);
			excelVO2.setResults(results2);
			datas.add(excelVO2);
		}else {
			/*	普通项目经理的导出内容*/
			String[] titles = {"项目名称", "项目开始时间", "项目结束时间", "客户名称", "源语言", "目标语言", "初译总计字数",
					"审校总计字数", "不计空格字数", "项目说明", "区块类型", "区块名称", "译员名字",
					"稿费标准", "稿费", "区块字数", "开始时间", "结束时间",
					"区块备注", "是否结算", "结算日期"};
			String[] columns = {"projectName", "projectStartDate", "projectEndDate", "customerName", "languageFrom",
					"languageTo", "wordsCou·nt", "reviewWordsCount", "wordsNoSpace", "projectRemarks", "partType",
					"partName", "translatorName", "partSalaryStd", "partSalaryReal",
					"wordsNum", "partStartDate", "partEndDate", "comment", "status", "settleDate"};
			List<PmExportVO> results = this.exportProjectService.pmExportVOtList(param, true);

			ExcelSheetVO excelVO = new ExcelSheetVO();
			excelVO.setColumns(columns);
			excelVO.setTitles(titles);
			excelVO.setResults(results);
			datas.add(excelVO);
		}

		exportService.write2Excel(request, response, datas, fileName);
        return null;
    }
}
