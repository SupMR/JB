package com.jzfactory.jd.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzfactory.jd.student.bean.BlackTable;
import com.jzfactory.jd.student.service.BlackService;
import com.jzfactory.jd.student.service.BlackServiceImpl;

public class BlackOptServlet extends HttpServlet {

	private BlackService service = new BlackServiceImpl();

	/**
	 * Constructor of the object.
	 */
	public BlackOptServlet() {
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

		String opt = request.getParameter("opt");

		String bname=request.getParameter("bname");
		if (bname != null)
			bname = new String(bname.getBytes("iso-8859-1"), "utf-8");
	    
		BlackTable black=service.findByName(bname);
		if(black==null && opt.equals("0"))
		{
			black=new BlackTable();
			black.setUsername(bname);
			black.setIncludeDate(new Date());
			if(opt!=null)
				black.setRemoved(1);
			 service.saveBlack(black);
		}

		if(black!=null)
		{
			if(opt!=null && opt.equals("0"))
				black.setRemoved(1);
			if(opt!=null && opt.equals("1"))
				black.setRemoved(0);
			service.updateBlack(black);
		}
		response.sendRedirect("BlackServlet");
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
