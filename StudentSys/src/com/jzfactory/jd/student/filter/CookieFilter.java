package com.jzfactory.jd.student.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jzfactory.jd.student.bean.User;

public class CookieFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub


		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		Cookie[] cookies=req.getCookies();
		if(cookies!=null && cookies.length>0)
		{
			for(Cookie cookie:cookies)
			{
				if(cookie.getName().equals("user"))
				{
					String value=cookie.getValue();
					String[] nv=value.split(",");
					User user=new User();
					user.setName(nv[0]);
					user.setPassword(nv[1]);
					HttpSession session=req.getSession();
					session.setAttribute("user",user);
					if(req.getServletPath().equals("/index.jsp"))
					{
						String path = req.getContextPath();
						String basePath = request.getScheme() + "://" + request.getServerName()
								+ ":" + request.getServerPort() + path + "/";
					
						resp.sendRedirect(basePath+"servlet/MainServlet");
						return;
					}
						
				}
			}
		}
		chain.doFilter(request,response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
