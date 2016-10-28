package com.jzfactory.jd.student.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UploadServlet() {
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
		
		
//创建文件上传工厂类
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload sfu=new ServletFileUpload(factory);
		//设置文件上传的大小
		sfu.setFileSizeMax(-1);
		//缓存输出字节流
		BufferedOutputStream bos=null;
		//缓存输入字节流
		BufferedInputStream bis=null;
		//获取服务在服务器的绝对路径
		String contextPathString=request.getSession().getServletContext().getRealPath("/");
		//创建一个文件对象
		File parentfile=new File(contextPathString+"/head_img","header.jpg");
		
		try {
			List<FileItem> list=sfu.parseRequest(request);
			for(FileItem item:list){
				//获取上传文件的输入流
				InputStream is=item.getInputStream();
				bos=new BufferedOutputStream(new FileOutputStream(parentfile));
				bis=new BufferedInputStream(is);
				byte[]buffer=new byte[1024];
				int len=-1;
				while((len=bis.read(buffer))!=-1){
					bos.write(buffer,0,len);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bos.close();
			bis.close();
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
