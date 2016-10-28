package com.jzfactory.jd.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzfactory.jd.student.bean.User;
import com.jzfactory.jd.student.service.UserService;
import com.jzfactory.jd.student.service.UserServiceImpl;


public class FindByIdServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FindByIdServlet() {
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
        //��ȡǰ̨ͨ��� ��������Ϊid�Ĳ���
		String sId=request.getParameter("id");
		//ʵ��UserService����
		UserService service=new UserServiceImpl();
		//ͨ��������findById����������String����ת��Ϊint����
		User user=service.findById(Integer.parseInt(sId));
		//��user����浽"user"��
		request.setAttribute("user", user);
		request.getRequestDispatcher("../update.jsp").forward(request, response);
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
