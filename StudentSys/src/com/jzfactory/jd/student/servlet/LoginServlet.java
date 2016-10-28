package com.jzfactory.jd.student.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jzfactory.jd.student.bean.User;
import com.jzfactory.jd.student.service.LoginService;
import com.jzfactory.jd.student.service.LoginServiceImpl;



public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurr+ed
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��ȡ����Ĳ���
		String username=request.getParameter("Username");
		String password=request.getParameter("Password");
		String remember=request.getParameter("remember");
		//����������װ��ʵ��been
		User user=new User();
		user.setName(username);
		user.setPassword(password);
		//������¼�ķ��������
	    LoginService service=new LoginServiceImpl();
	    //�û����е�¼
	    int res=service.login(user);
	    if(user.getName().equals("admin")){
	    	HttpSession session=request.getSession(true);
	    	session.setAttribute("user", user);
	    	session.setMaxInactiveInterval(200);
	    	response.sendRedirect("BlackServlet");
	    }else
	    {
	    if(res==0){
	    	if(remember!=null && remember.equals("1"))
	    	{
	    	//设置cookie
	    	Cookie cookie=new Cookie("user",user.getName()+","+user.getPassword());
	    	cookie.setMaxAge(60*60);
	    	cookie.setPath("/");
	    	response.addCookie(cookie);
	    	}
	    	//response.sendRedirect("http://www.baidu.com");
	    	HttpSession session=request.getSession(true);
	    	session.setAttribute("user", user);
	    	
	    	//��ȡǰ̨�Զ���¼״̬��
	    	String radio=request.getParameter("remember");
//	    	if(radio!=null){
//	    		//��ȡcookie���󣬽��û�������浽cookie�У�
//	    		Cookie c=new Cookie("loginInfo",URLEncoder.encode(username,"utf-8")+"_"+password);
//	    	     //����cookie���������·��
//	    		c.setPath("/Black");
//	    		//����cookie����ʱ��
//	    		c.setMaxAge(30);
//	    		//��cookie��ӵ������
//	    		response.addCookie(c);
//	    	}
	    
//	    	//������������
	    	session.setMaxInactiveInterval(60);
	    	
	    	response.sendRedirect("MainServlet");
	    }
	    else{
	    	 response.sendRedirect("../index.jsp?log_res="+res);
	    }
	}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		//看看乱码不
	}

}
