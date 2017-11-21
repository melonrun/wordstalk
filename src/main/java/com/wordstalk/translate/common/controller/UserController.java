package com.wordstalk.translate.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wordstalk.translate.common.service.ExportProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordstalk.translate.common.service.UserService;
import com.wordstalk.translate.common.vo.ConstantsField;
import com.wordstalk.translate.common.vo.JsonContent;
import com.wordstalk.translate.common.vo.RoleVO;
import com.wordstalk.translate.common.vo.UserVO;

/**
 * 用户登录、信息控制
 * @author yong
 * @date 2016年7月4日
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;

    @Autowired
    private ExportProjectService exportProjectService;
    
	@ResponseBody
    @RequestMapping("/login")
    public Object login(UserVO vo, HttpSession session, HttpServletResponse response,
    		HttpServletRequest request) {
		UserVO user = userService.queryUserByNameAndPass(vo);
		if(user == null){
			return JsonContent.errorJson("用户名或密码错误。", null);
		}else{/*登陆成功*/
			logger.info(user.getUserName());
			session.setAttribute(ConstantsField.SESSION_USER_NAME, user.getUserName());
			session.setAttribute(ConstantsField.SESSION_USER_ID, user.getId());
			/*设置超时时间 24 小时*/
			session.setMaxInactiveInterval(86400);
			
			List<RoleVO> list = userService.queryUserRoleById(user);
			session.setAttribute(ConstantsField.SESSION_USER_ROLE, list.get(0).getRoleDesc());
			
			return JsonContent.okJson(user.getUserName(), list.get(0).getRoleDesc());
		}
	}
	
	@ResponseBody
    @RequestMapping("/logout")
    public Object logout(UserVO vo, HttpSession session, HttpServletRequest request) {
		if(request.getSession().getAttribute(ConstantsField.SESSION_USER_NAME) != null){
			request.getSession().removeAttribute(ConstantsField.SESSION_USER_NAME);
		}
		return JsonContent.okJson("注销成功", null);
	}

	@ResponseBody
	@RequestMapping("/update")
	public Object update(UserVO vo, HttpSession session, HttpServletRequest request) {
		exportProjectService.updateTrans();
		return JsonContent.okJson("注销成功", null);
	}
}
