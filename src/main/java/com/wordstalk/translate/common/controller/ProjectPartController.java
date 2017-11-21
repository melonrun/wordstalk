package com.wordstalk.translate.common.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wordstalk.translate.common.service.ProjectAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wordstalk.translate.common.service.ExportService;
import com.wordstalk.translate.common.service.ProjectPartService;
import com.wordstalk.translate.common.service.ProjectService;
import com.wordstalk.translate.common.util.DateUtils;
import com.wordstalk.translate.common.util.VerifyUtil;
import com.wordstalk.translate.common.vo.ExcelSheetVO;
import com.wordstalk.translate.common.vo.JsonContent;
import com.wordstalk.translate.common.vo.ProjectPartVO;
import com.wordstalk.translate.common.vo.ProjectVO;
import com.wordstalk.translate.common.vo.param.Page;
import com.wordstalk.translate.common.vo.param.PageParam;
import com.wordstalk.translate.common.vo.param.VerifyVO;

@Controller
@RequestMapping("/project_part")
public class ProjectPartController {

	@Autowired
	private ProjectPartService projectPartService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
    private ExportService exportService;

	@Autowired
	private ProjectAdminService projectAdminService;

	@RequestMapping("/projectPartPage")
	public ModelAndView projectPartPage(HttpServletResponse response) {
		ModelAndView view = new ModelAndView("project/project_part_list");
		return view;
	}

	@RequestMapping("/addProjectPartPage")
	public ModelAndView addProjectPartPage(HttpServletResponse response) {
		ModelAndView view = new ModelAndView("project/add_project_part");
		return view;
	}

	@ResponseBody
	@RequestMapping("/addProjectPartSubmit")
	public Object addProjectPartSubmit(ProjectPartVO vo) {
		VerifyVO verifyVO = VerifyUtil.verifyProjectPart(vo);
		if (!verifyVO.isStatus()) {
			return JsonContent.errorJson(verifyVO.getErrorMsg(), "");
		} else {
			if (projectPartService.addProjectPartSubmit(vo))
				return JsonContent.okJson(null, null);
			else
				return JsonContent.errorJson("添加失败", null);
		}
	}

	@ResponseBody
	@RequestMapping("/projectPartList")
	public Object getProjectPartList(PageParam param, ProjectPartVO vo) {
		Page page = this.projectPartService.getProjectPartList(param, vo);
		ProjectVO pVo = new ProjectVO();
		pVo.setId(vo.getProjectId());
		Double sumTransCost = projectAdminService.querAllTransCost(pVo);
		if (page == null)
			return JsonContent.errorJson("获取失败", page);
		if(sumTransCost == null)
			sumTransCost = 0.0;
		return JsonContent.okJson(sumTransCost.toString(), page);
	}

	@ResponseBody
	@RequestMapping("/getProjectPartDetail")
	public Object getProjectPartDetail(ProjectPartVO vo) {
		ProjectPartVO pVo = this.projectPartService.getProjectPartDetail(vo);
		if (vo == null)
			return JsonContent.errorJson("获取失败", pVo);
		return JsonContent.okJson("查询成功", pVo);
	}

	@ResponseBody
	@RequestMapping("/getProjectPartByTid")
	public Object getProjectPartByTid(PageParam param) {
		Page page = this.projectPartService.getProjectPartByTid(param);
        ProjectVO vo = new ProjectVO();
        vo.setId(new Integer(param.getSearchKey()));
        Double allCost = this.projectPartService.queryAllTransCost(vo);
		if (page == null)
			return JsonContent.errorJson("获取失败", page);
		return JsonContent.okJson(allCost==null?"":allCost.toString(), page);
	}

    @ResponseBody
    @RequestMapping("/updatePartSettleStatus")
    public Object updatePartSettleStatus(ProjectPartVO vo){
        if (projectPartService.updatePartSettleStatus(vo))
            return JsonContent.okJson(null, null);
        else
            return JsonContent.errorJson("添加失败", null);
    }

	@ResponseBody
	@RequestMapping("/deleteProjectPart")
	public Object deleteProjectPart(ProjectPartVO vo){
		if(projectPartService.deleteProjectPart(vo))
			return JsonContent.okJson(null, null);
		else
			return JsonContent.errorJson("删除失败", null);
	}
	
	@RequestMapping("/exportAllProjectPart")
	public Object exportTranslator( HttpServletResponse response, HttpServletRequest request, ProjectVO vo) {
		List<ProjectPartVO> results = this.projectPartService.exportAllProjectPartList(vo);
		ProjectVO projectVO = projectService.getProjectDetail(vo);
		List<ProjectVO> results2 = new ArrayList<>();
		results2.add(projectVO);

		if(results != null && projectVO != null){
			List<ExcelSheetVO> datas = new ArrayList<>();
			ExcelSheetVO excelVO = new ExcelSheetVO();
			String[] titles = {"区块名称","区块字数", "译员", "稿费标准", "稿费", "翻译起始时间", "翻译结束时间",
					"译员评价", "稿费结算", "结算时间"};
			String[] columns = { "partName", "wordsNum", "translatorName", "salaryStd", "salaryReal",
					"startDate", "endDate", "comments", "statusStr", "settleDate"};
			String fileName = "项目-区块详情表-"+DateUtils.getCurrentDate("yyyy-MM-dd");
			excelVO.setColumns(columns);
			excelVO.setTitles(titles);
			excelVO.setResults(results);

			datas.add(excelVO);

			String[] titles2 = {"项目名称", "客户名称", "源语言","目标语言","区块合计字数", "不计空格字数", "备注"};
			String[] columns2 = { "projectName", "customerName", "languageFrom", "languageTo", "wordsCount",
					"wordsNoSpace", "remarks"};
			ExcelSheetVO excelVO2 = new ExcelSheetVO();
			excelVO2.setColumns(columns2);
			excelVO2.setTitles(titles2);
			excelVO2.setResults(results2);

			datas.add(excelVO2);

			exportService.write2Excel(request, response, datas, fileName);
		}
		return null;
	}
}
