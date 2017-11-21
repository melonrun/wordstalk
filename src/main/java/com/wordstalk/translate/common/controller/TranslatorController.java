package com.wordstalk.translate.common.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wordstalk.translate.common.service.ExportService;
import com.wordstalk.translate.common.service.ProjectPartService;
import com.wordstalk.translate.common.service.TranslatorService;
import com.wordstalk.translate.common.util.DateUtils;
import com.wordstalk.translate.common.util.VerifyUtil;
import com.wordstalk.translate.common.vo.ExcelSheetVO;
import com.wordstalk.translate.common.vo.JsonContent;
import com.wordstalk.translate.common.vo.ProjectPartVO;
import com.wordstalk.translate.common.vo.TranslatorVO;
import com.wordstalk.translate.common.vo.param.Page;
import com.wordstalk.translate.common.vo.param.PageParam;
import com.wordstalk.translate.common.vo.param.VerifyVO;

@Controller
@RequestMapping("/translator")
public class TranslatorController {
	
    @Autowired
    private TranslatorService translatorService;
    
    @Autowired
    private ProjectPartService projectPartService;
    
    @Autowired
    private ExportService exportService;

	@RequestMapping("/addTranslator")
    public ModelAndView addTranslatorRe( HttpServletResponse response) {
    	ModelAndView view = new ModelAndView("translate/add_translator");
		return view;
    }
    
    @RequestMapping("/translatorPage")
    public ModelAndView translatorList( HttpServletResponse response) {
    	ModelAndView view = new ModelAndView("translate/translator_list");
		return view;
    }
    
    @ResponseBody
    @RequestMapping("/translatorList")
    public Object translatorList(PageParam param, HttpServletResponse response,
    		HttpServletRequest request) {
		Page page = this.translatorService.queryTranslator(param);
		if(page == null)
			return JsonContent.errorJson("获取失败", page);
		return JsonContent.okJson("查询成功", page);
	}
    
    @ResponseBody
    @RequestMapping("/getAllTranslator")
    public Object getAllTranslator() {
    	List<TranslatorVO> results = this.translatorService.queryTranslatorList(new PageParam());
		if(results == null)
			return JsonContent.errorJson("获取失败", results);
		return JsonContent.okJson("查询成功", results);
	}
    
    @ResponseBody
    @RequestMapping("/addTranslatorSubmit")
    public Object addTranslatorSubmit(TranslatorVO vo) {
    	VerifyVO verifyVO = VerifyUtil.verifyTranslator(vo);
    	if(!verifyVO.isStatus()){
    		return JsonContent.errorJson(verifyVO.getErrorMsg(), "");
    	}else{
    		translatorService.saveTranslator(vo);
    		return JsonContent.okJson(null, null);
    	}
    }
    
    @ResponseBody
    @RequestMapping("/updateTranslatorSubmit")
    public Object updateTranslatorSubmit(TranslatorVO vo) {
    	VerifyVO verifyVO = VerifyUtil.verifyTranslator(vo);
    	if(!verifyVO.isStatus()){
    		return JsonContent.errorJson(verifyVO.getErrorMsg(), "");
    	}else{
    		translatorService.updateTranslator(vo);
    		return JsonContent.okJson(null, null);
    	}
    }
    
    @ResponseBody
    @RequestMapping("/getTranslatorDetail")
    public Object getTranslatorDetail(TranslatorVO vo){
    	if(vo.getId() != null){
    		return JsonContent.okJson("", translatorService.getTranslatorDetail(vo));
    	}else{
    		return JsonContent.errorJson("id为空", null);
    	}
    }
    
    @RequestMapping("/exportTranslator")
    public Object exportTranslator( HttpServletResponse response, HttpServletRequest request) {
    	List<TranslatorVO> results = this.translatorService.queryTranslatorList(new PageParam());
        if(results != null){
		    String[] titles = {"名字", "级别", "在职", /*"背景",*/"语言",/*"擅长领域",*/"合同开始时间","合同结束时间",
		    		"稿费标准","电话","邮箱"/*,"空余时间天数"*/, "空余时间明细", "说明"};
		    String[] columns = { "name","levelStr", "statusStr", /*"workExperience",*/ "languageList", /*"skillfulField",*/
		    		"contractStartDate", "contractEndDate", "salary", "telephone", "email", "spareDayStr", "remarks"};
		    String fileName = "译员表"+DateUtils.getCurrentDate("yyyy-MM-dd");
		    exportService.write2Excel(request, response, titles, columns, results, fileName);
        }
        return null;
    }
    
    
    @RequestMapping("/exportTranslatorDetail")
    public Object exportTranslatorDetail( HttpServletResponse response, HttpServletRequest request,
    		TranslatorVO vo) {
    	TranslatorVO voDetail = translatorService.getTranslatorDetail(vo);
    	List<ProjectPartVO> results = projectPartService.getAllProjectPartByTid(vo);
    	
    	if(results != null && voDetail != null){
    		String[] titles = {"项目名称", "项目区块名称","翻译起始时间", "翻译结束时间", "字数", "稿费", "质量评价", "稿费结算"};
    		String[] columns = {"projectName", "partName", "startDate",
				    "endDate", "wordsNum", "salaryReal", "comment", "statusStr"};
    		String fileName = "译员-项目区块详情-"+DateUtils.getCurrentDate("yyyy-MM-dd");
    		List<ExcelSheetVO> datas = new ArrayList<>();
    		ExcelSheetVO excelVO = new ExcelSheetVO();
    		excelVO.setTitles(titles);
    		excelVO.setColumns(columns);
    		excelVO.setResults(results);
    		datas.add(excelVO);
    		
    		ExcelSheetVO excelVO2 = new ExcelSheetVO();
    		String[] titles2 = {"名字", "级别", "背景","语言","擅长领域","合同开始时间","合同结束时间",
		    		"稿费标准","电话","邮箱", "空余时间明细"};
		    String[] columns2 = { "name","levelStr", "workExperience", "languageList", "skillfulField",
		    		"contractStartDate", "contractEndDate", "salary", "telephone", "email", "spareDayStr"};
		    List<TranslatorVO> transVO = new ArrayList<>();
		    transVO.add(voDetail);
    		excelVO2.setTitles(titles2);
    		excelVO2.setColumns(columns2);
    		excelVO2.setResults(transVO);
		    datas.add(excelVO2);
		    
    		exportService.write2Excel(request, response, datas, fileName);
    	}
    	return null;
    }
}
