package com.jzfactory.jd.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jzfactory.jd.student.bean.BlackTable;
import com.jzfactory.jd.student.bean.User;
import com.jzfactory.jd.student.service.BlackService;
import com.jzfactory.jd.student.service.BlackServiceImpl;

public class BlackServlet extends HttpServlet {

	private BlackService service = new BlackServiceImpl();

	/**
	 * Constructor of the object.
	 */
	public BlackServlet() {
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
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null && !user.getName().equals("admin"))
		{
			String path=request.getContextPath();
			String basePath=request.getScheme()+"://"+request.getServerName();
			response.sendRedirect(basePath+"servlet/MainServlet");
			return;
		}
		
		List<BlackTable> list=service.getAll();
		request.setAttribute("black_list", list);
        request.getRequestDispatcher("../black.jsp").forward(request, response);

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
