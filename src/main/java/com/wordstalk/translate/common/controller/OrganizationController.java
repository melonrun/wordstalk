package com.wordstalk.translate.common.controller;

import com.wordstalk.translate.common.service.OrganizationService;
import com.wordstalk.translate.common.util.VerifyUtil;
import com.wordstalk.translate.common.vo.JsonContent;
import com.wordstalk.translate.common.vo.OrganizationVO;
import com.wordstalk.translate.common.vo.param.Page;
import com.wordstalk.translate.common.vo.param.PageParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 机构信息
 * @author yong
 * @date 2016年7月4日
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

	@RequestMapping("/organizationPage")
	public ModelAndView customerList(HttpServletResponse response) {
		ModelAndView view = new ModelAndView("organization/organization_list");
		return view;
	}

	@ResponseBody
    @RequestMapping("/organizationList")
    public Object organizationList(PageParam param, HttpSession session, HttpServletResponse response,
	                    HttpServletRequest request) {
        Page page = this.organizationService.getOrganList(param);
        if(page == null)
            return JsonContent.errorJson("获取失败", page);
        return JsonContent.okJson("查询成功", page);
	}

    @ResponseBody
    @RequestMapping("/addOrganization")
    public Object addOrganization(OrganizationVO vo, HttpSession session, HttpServletResponse response,
                                  HttpServletRequest request) {
        if(StringUtils.isEmpty(vo.getOrganName())){
            return JsonContent.errorJson("请输入机构名称", null);
        }
        if(this.organizationService.addOrganization(vo)){
            return JsonContent.okJson("保存成功", null);
        }else
            return JsonContent.errorJson("请输入机构名称", null);
   }

    @ResponseBody
    @RequestMapping("/delOrganization")
    public Object delOrganization(OrganizationVO vo, HttpSession session, HttpServletResponse response,
                                  HttpServletRequest request) {
        if(this.organizationService.delOrganization(vo)){
            return JsonContent.okJson("保存成功", null);
        }else
            return JsonContent.errorJson("信息错误", null);
    }
}
