package com.wordstalk.translate.common.controller;

import com.wordstalk.translate.common.service.CustomerService;
import com.wordstalk.translate.common.service.ExportService;
import com.wordstalk.translate.common.service.UserService;
import com.wordstalk.translate.common.util.DateUtils;
import com.wordstalk.translate.common.util.VerifyUtil;
import com.wordstalk.translate.common.vo.*;
import com.wordstalk.translate.common.vo.param.Page;
import com.wordstalk.translate.common.vo.param.PageParam;
import com.wordstalk.translate.common.vo.param.VerifyVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 客户信息
 * @author yong
 * @date 2016年7月4日
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

    @Autowired
    private ExportService exportService;

	@RequestMapping("/addCustomer")
	public ModelAndView addCustomer(HttpServletResponse response) {
		ModelAndView view = new ModelAndView("customer/add_customer");
		return view;
	}

    @RequestMapping("/customerPage")
    public ModelAndView customerList(HttpServletResponse response) {
        ModelAndView view = new ModelAndView("customer/customer_list");
        return view;
    }

	@ResponseBody
    @RequestMapping("/customerList")
    public Object customerList(PageParam param, HttpSession session, HttpServletResponse response,
	                    HttpServletRequest request) {
        String other = (String)session.getAttribute(ConstantsField.SESSION_USER_NAME);
		if("PM".equals(other) || "admin".equals(other))
		    param.setOther("");
        else
            param.setOther(other);
        Page page = this.customerService.getCustomerList(param);
		if(page == null)
			return JsonContent.errorJson("获取失败", page);
		return JsonContent.okJson("查询成功", page);
	}

    @ResponseBody
    @RequestMapping("/getCustomerDetail")
    public Object getCustomerDetail(CustomerVO vo, HttpSession session, HttpServletResponse response,
                               HttpServletRequest request) {
        List<CustomerVO> list = this.customerService.getCustomerDetail(vo);
        if(list == null)
            return JsonContent.errorJson("获取失败", list);
        return JsonContent.okJson("查询成功", list);
    }

    @ResponseBody
    @RequestMapping("/updateCustomerSubmit")
    public Object updateCustomerSubmit(CustomerVO vo, HttpSession session, HttpServletResponse response) {
        VerifyVO verifyVO = VerifyUtil.verifyCustomer(vo);
        if(!verifyVO.isStatus()){
            return JsonContent.errorJson(verifyVO.getErrorMsg(), "");
        }else{
            if(this.customerService.updateCustomerSubmit(vo)){
                return JsonContent.okJson("保存成功", null);
            }else
                return JsonContent.errorJson("保存失败", null);
        }
    }

    @ResponseBody
    @RequestMapping("/getProjectListByCustomer")
    public Object getProjectListByCustomer(CustomerVO vo, HttpSession session, HttpServletResponse response) {
        List<CustomerProjectVO> list = this.customerService.getProjectListByCustomer(vo);
        if(list == null)
            return JsonContent.errorJson("获取失败", list);
        return JsonContent.okJson("查询成功", list);
    }


    @ResponseBody
    @RequestMapping("/getAllCustomerList")
    public Object getAllCustomerList(CustomerVO vo, HttpSession session, HttpServletResponse response) {
        List<CustomerVO> list = this.customerService.getAllCustomerList(new PageParam());
        if(list == null)
            return JsonContent.errorJson("获取失败", list);
        return JsonContent.okJson("查询成功", list);
    }

	@RequestMapping("/exportCustomer")
	public Object exportTranslator( HttpServletResponse response, HttpServletRequest request) {
		List<CustomerVO> results = this.customerService.getAllCustomerList(new PageParam());
		if(results != null){
			String[] titles = {"客户姓名", "客户经理", "机构", "职位", "电话", "邮箱", "QQ", "地址", "备注"};
			String[] columns = { "customerName","managerName", "organName", "title", "cellphone", "email",
					"qq", "address", "remark"};
			String fileName = "客户表"+ DateUtils.getCurrentDate("yyyy-MM-dd");
			exportService.write2Excel(request, response, titles, columns, results, fileName);
		}
		return null;
	}
}
