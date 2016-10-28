package com.jzfactory.jd.student.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jzfactory.jd.student.bean.User;

public class SessionFilter implements Filter {

	private String redirectUrl;//跳转路径
	
	private String servletRegex;//过滤正则
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		
		String servletPath=request.getServletPath();
		Pattern pattern=Pattern.compile(servletRegex);
		if(servletPath.equals(redirectUrl) || pattern.matcher(servletPath).matches())
		{
			arg2.doFilter(request, response);
			return;
		}
		HttpSession session=request.getSession(true);
		User user=(User)session.getAttribute("user");
		if(user!=null)
			arg2.doFilter(request, response);
		else{
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort() + path + "/";
		
			response.sendRedirect(basePath+"index.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
        //获取过滤器初始化参数
		redirectUrl=arg0.getInitParameter("redirectUrl");
		servletRegex=arg0.getInitParameter("servletRegex");
	}

}
