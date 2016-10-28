package com.jzfactory.jd.student.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jzfactory.jd.student.bean.BlackTable;
import com.jzfactory.jd.student.bean.User;
import com.jzfactory.jd.student.service.BlackService;
import com.jzfactory.jd.student.service.BlackServiceImpl;

public class BlackFilter implements Filter {

	private BlackService service=new BlackServiceImpl();
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		//获取用户
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user==null)
		{
			arg2.doFilter(request, response);
			return;
		}
		//获取黑名单用户
		List<BlackTable> blackList=service.getInTable();
		
		for(BlackTable black:blackList)
		{
			if(user.getName().equals(black.getUsername()))
			{
//				String path = request.getContextPath();
//				String basePath = request.getScheme() + "://" + request.getServerName()
//						+ ":" + request.getServerPort() + path + "/";
//				response.sendRedirect(basePath+"Black_error.jsp");
				//获取用户名
				//request.setAttribute("username", user.getName());
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Black_error.jsp");
				dispatcher.forward(request, response);
				return;
			}
		}

		arg2.doFilter(request,response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
