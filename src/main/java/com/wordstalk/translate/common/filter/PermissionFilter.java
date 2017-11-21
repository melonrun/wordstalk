package com.wordstalk.translate.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.wordstalk.translate.common.util.PathPatternMatcher;
import com.wordstalk.translate.common.vo.ConstantsField;


public class PermissionFilter extends HttpServlet implements Filter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7395220835797180138L;

	public static final String LOGIN_USER_SESSION_KEY = "username";
	private List<String> excludePath;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String excludePathv = filterConfig.getInitParameter("excludePath");
		excludePath = new ArrayList<String>();
		if (!StringUtils.isBlank(excludePathv)) {
			String[] paths = excludePathv.split(";");
			excludePath.addAll(Arrays.asList(paths));
		}		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		String path = hrequest.getServletPath();

		if(PathPatternMatcher.urlPathMatch(excludePath, path)) {
			chain.doFilter(hrequest, hresponse);
			return;
		}		
		
		if(null == hrequest.getSession().getAttribute(ConstantsField.SESSION_USER_NAME)) {
			if (hrequest.getHeader("x-requested-with") != null && hrequest.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
				hresponse.sendError(999);
			}else{
				hresponse.sendRedirect("/wordstalk/login.html");
			}
			return;
		}else if("/".equals(path)){
			hresponse.sendRedirect("/wordstalk/translator/translatorPage.htm");
		}else if(path.contains("admin")){
			if(!"admin".equals(hrequest.getSession().getAttribute(ConstantsField.SESSION_USER_ROLE)))
				hresponse.sendRedirect("/wordstalk/project/projectPage.htm");
		}

		chain.doFilter(request, response);
	}
	
}

