package com.jzfactory.jd.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzfactory.jd.student.bean.Clasz;
import com.jzfactory.jd.student.bean.Student;
import com.jzfactory.jd.student.service.ClaszService;
import com.jzfactory.jd.student.service.ClaszServiceImpl;
import com.jzfactory.jd.student.service.StudentService;
import com.jzfactory.jd.student.service.StudentServiceImpl;
import com.jzfactory.jd.student.util.DateUtil;

public class ClasOptServlet extends HttpServlet {

	private ClaszService service = new ClaszServiceImpl();

	/**
	 * Constructor of the object.
	 */
	public ClasOptServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opt = request.getParameter("opt");

		String id = request.getParameter("clsId");
		String name = request.getParameter("cname");
		if (name != null)
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		String t_name = request.getParameter("ct_name");
		if (t_name != null)
			t_name = new String(t_name.getBytes("iso-8859-1"),"utf-8");
		if (opt != null && opt.equals("del")) {
			service.deleteClasz(Integer.valueOf(id));
		} else if (opt != null && opt.equals("edit")) {
			Clasz clas = new Clasz();
			clas.setId(Integer.valueOf(id));
			clas.setName(name);
            clas.setT_name(t_name);
			service.updateClasz(clas);

		} else if (opt != null && opt.equals("add")) {
			Clasz clas = new Clasz();
			clas.setName(name);
			clas.setT_name(t_name);

			service.add(clas);
		}
		response.sendRedirect("MainServlet" );
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
