package com.jzfactory.jd.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzfactory.jd.student.bean.Clasz;
import com.jzfactory.jd.student.bean.Student;
import com.jzfactory.jd.student.service.StudentService;
import com.jzfactory.jd.student.service.StudentServiceImpl;
import com.jzfactory.jd.student.util.Pagination;
/**
 * 涓婚〉闈㈣姹俿ervlet
 * @author 闃垮皯
 *
 */
public class MainServlet extends HttpServlet {

	//涓氬姟鏈嶅姟绫诲璞�
	private StudentService service=new StudentServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public MainServlet() {
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

		
		
     doPost(request,response);
     
     
     
     
     
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
		
		//鑾峰彇鐝骇id鍜屽悕瀛�
		Map<Integer,String> nameMap=service.getClaszNameWithId();
		
       //鑾峰彇浼犲叆鐨勭彮绾d
		String clsIdStr=request.getParameter("clsId");
		String findName=request.getParameter("findname");
		String pageNumStr=request.getParameter("pageNum");
	    System.out.println(pageNumStr);
		int clsId=-1;
		if(clsIdStr!=null && !clsIdStr.equals(""))
		{
			clsId=Integer.valueOf(clsIdStr);
		}
		else{
			for(Entry<Integer,String>entry:nameMap.entrySet())
			{
				clsId=entry.getKey();
				break;
			}
		}
		
		Integer pageNum=null;
		if(pageNumStr!=null && !pageNumStr.equals(""))
		{
			pageNum=Integer.parseInt(pageNumStr);
		}else{
			pageNum=1;
		}
		//鑾峰彇鐢峰コ浜烘暟鐨勭粺璁℃暟鎹�
		int[] count=service.countBySex(clsId);
		//鑾峰彇鐝骇鐨勪俊鎭�
		Clasz cls=service.getClasz(clsId);
		//杩涜鏌ヨ
		if(findName!=null && !findName.equals(""))
		{
			findName = new String(findName.getBytes("iso-8859-1"), "utf-8");
			List<Student> studList=service.findByName(clsId,findName);
			cls.setStudList(studList);
		}
		int studCount=cls.getStudList().size();
		int pageSize=StudentServiceImpl.PAGE_SIZE;
		if(studCount>pageSize){
			List<Student> sList=service.findByPage(clsId, cls.getStudList().size(), pageNum);
			cls.setStudList(sList);
		}
		//缁檙equest浣滅敤鍩熻缃�
		request.setAttribute("nameMap",nameMap);
		request.setAttribute("count", count);
		request.setAttribute("cls", cls);
		Pagination page=new Pagination(studCount,pageSize);
		request.setAttribute("pageCount",page.getPageCount());
		
		request.setAttribute("pageNum", pageNum);
		//鑾峰彇鍒嗘淳瀵硅薄
		RequestDispatcher dispacher=request.getRequestDispatcher("/main.jsp");
		dispacher.forward(request, response);
		
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
