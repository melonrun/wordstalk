package com.wordstalk.translate.common.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wordstalk.translate.common.service.ProjectPartService;
import com.wordstalk.translate.common.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wordstalk.translate.common.service.ExportService;
import com.wordstalk.translate.common.service.ProjectAdminService;
import com.wordstalk.translate.common.service.ProjectService;
import com.wordstalk.translate.common.util.DateUtils;
import com.wordstalk.translate.common.util.VerifyUtil;
import com.wordstalk.translate.common.vo.param.VerifyVO;

@Controller
@RequestMapping("/adminproject")
public class ProjectAdminController {
	
	@Autowired
	private ProjectAdminService adminService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ExportService exportService;

	@Autowired
	private ProjectPartService projectPartService;

	@RequestMapping("/adminProjectPage")
	public ModelAndView addProjectPage(HttpSession session) {
		ModelAndView view = new ModelAndView("project/add_project_admin");
		return view;
	}

	@ResponseBody
	@RequestMapping("/updatePartPmCheckout")
	public Object updatePartPmCheckout(ProjectPartVO vo, HttpSession session){
        if(!"admin".equals(session.getAttribute(ConstantsField.SESSION_USER_ROLE))) {
            return JsonContent.errorJson("不能修改。", null);
        }
		if (projectPartService.updatePartPmCheckout(vo))
			return JsonContent.okJson(null, null);
		else
			return JsonContent.errorJson("添加失败", null);
	}
	
	@ResponseBody
	@RequestMapping("/saveProjectAdmin")
	public Object saveProjectAdmin(ProjectAdminVO vo) {
		VerifyVO verifyVO = VerifyUtil.verifyProjectAdmin(vo);
    	if(!verifyVO.isStatus()){
    		return JsonContent.errorJson(verifyVO.getErrorMsg(), "");
    	}else{
    		adminService.saveProjectAdmin(vo);
    		return JsonContent.okJson(null, null);
    	}
	}
	
	@ResponseBody
	@RequestMapping("/getProjectDetail")
	public Object getProjectDetail(ProjectVO vo) {
		if(vo.getId() != null && vo.getId() > 0){
			return JsonContent.okJson("获取成功", adminService.getProjectDetail(vo));
		}
		return JsonContent.errorJson("查询失败", "");
	}
	
	@ResponseBody
	@RequestMapping("/getProjectAdminDetail")
	public Object getProjectAdminDetail(ProjectAdminVO vo) {
		if(vo.getProjectId() != null && vo.getProjectId() > 0){
			ProjectAdminVO adminVo = adminService.getProjectAdminDetail(vo);
			if(adminVo != null){
				return JsonContent.okJson("获取成功", adminVo);
			}
			return JsonContent.errorJson("数据为空", "");
		}
		return JsonContent.errorJson("查询失败", "");
	}
	
	@ResponseBody
	@RequestMapping("/queryTransCost")
	public Object queryTransCost(ProjectVO vo){
		if(vo.getId() != null && vo.getId() > 0){
			return JsonContent.okJson("获取成功", adminService.querTransCost(vo));
		}
		return JsonContent.errorJson("查询失败", "");
	}

	@ResponseBody
	@RequestMapping("/queryReviewCost")
	public Object queryReviewCost(ProjectVO vo){
		if(vo.getId() != null && vo.getId() > 0){
			return JsonContent.okJson("获取成功", adminService.queryReviewCost(vo));
		}
		return JsonContent.errorJson("查询失败","");
	}
	
	@ResponseBody
	@RequestMapping("/queryWordsNum")
	public Object queryWordsNum(ProjectVO vo){
		if(vo.getId() != null && vo.getId() > 0){
			return JsonContent.okJson("获取成功", adminService.queryWordsNum(vo));
		}
		return JsonContent.errorJson("查询失败", "");
	}
	
	@RequestMapping("/exportPartAdmin")
	public Object exportPartAdmin( HttpServletResponse response, HttpServletRequest request,
			ProjectVO vo) {
		ProjectVO projectVO = this.projectService.getProjectDetail(vo);
		ProjectAdminVO adminVo = new ProjectAdminVO();
		adminVo.setProjectId(vo.getId());
		adminVo = this.adminService.getProjectAdminDetail(adminVo);
		
		List<ProjectVO> results = new ArrayList<>();
		results.add(projectVO);
		List<ProjectAdminVO> results2 = new ArrayList<>();
		results2.add(adminVo);
		
		String[] titles = {"项目名称", "客户名称", "源语言","目标语言","区块合计字数", "不计空格字数", "备注"};
	    String[] columns = { "projectName", "customerName", "languageFrom", "languageTo", "wordsCount",
	    		"wordsNoSpace", "remarks"};
	    String fileName = "项目-管理员详情-"+DateUtils.getCurrentDate("yyyy-MM-dd");
	    
	    List<ExcelSheetVO> datas = new ArrayList<>();
	    ExcelSheetVO excelVO = new ExcelSheetVO();
	    excelVO.setColumns(columns);
	    excelVO.setTitles(titles);
	    excelVO.setResults(results);
	    datas.add(excelVO);
	    
	    String[] titles2 = {"收费标准","项目收入","译员稿费","管理费","销售提成","提成记录","项目利润","利润率"
	    		,"客户款到账","到账时间"};
	    String[] columns2 = {"chargeStd","projectIncome","tranCost","manageCost","saleCommission","saleRecord"
	    		,"projectProfit","profitRatio","accountStatusStr","endDate"};
	    ExcelSheetVO excelVO2 = new ExcelSheetVO();
	    excelVO2.setColumns(columns2);
	    excelVO2.setTitles(titles2);
	    excelVO2.setResults(results2);
	    datas.add(excelVO2);
	    
	    exportService.write2Excel(request, response, datas, fileName);
	    return null;
	}
}
