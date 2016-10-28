package com.jzfactory.jd.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzfactory.jd.student.bean.Student;
import com.jzfactory.jd.student.service.StudentService;
import com.jzfactory.jd.student.service.StudentServiceImpl;
import com.jzfactory.jd.student.util.DateUtil;

/**
 * 学生信息操作servlet
 * 
 * @author 阿少
 *
 */
public class StudOptServlet extends HttpServlet {

	private StudentService service = new StudentServiceImpl();

	/**
	 * Constructor of the object.
	 */
	public StudOptServlet() {
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

		String id = request.getParameter("studId");

		String code = request.getParameter("scode");
		String name = request.getParameter("sname");
		if (name != null)
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		String sex = request.getParameter("ssex");
		String birth = request.getParameter("sbirth");
		String claszId = request.getParameter("clsId");
		if (opt != null && opt.equals("del")) {
			service.deleteStudent(Integer.valueOf(id));
		}
		else if(opt!=null && opt.equals("edit")){
			Student student = new Student();
			student.setId(Integer.valueOf(id));
			student.setName(name);
			student.setCode(code);
			student.setSex(Integer.valueOf(sex));
			student.setBirth(DateUtil.toDate(birth));
			student.setClass_id(Integer.valueOf(claszId));


			service.updateStudent(student);

		}else if(opt!=null && opt.equals("add")){
			Student student = new Student();
			student.setCode(code);
			student.setName(name);
			student.setSex(Integer.valueOf(sex));
			student.setBirth(DateUtil.toDate(birth));
			student.setClass_id(Integer.valueOf(claszId));

			service.add(student);
		}
		
		response.sendRedirect("MainServlet?clsId=" + claszId);
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
