package com.jzfactory.jd.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接工具类
 * @author yangxf 2016-08-24
 *
 */
public class DBConnection {
	//数据库驱动的名称
	 private static final String  DRIVER_NAME="com.mysql.jdbc.Driver";
	
		//数据库连接地址
	private static final String  URL="jdbc:mysql://localhost:3306/login";
	//用户名称
	private static final String USER_NAME="root";
	
	//用户密码
	private static final String PASSWORD="root";
	/**
	 * 创建数据库连接对象
	 */
	public static Connection createConnection(){
		Connection conn=null;
		try {
			//加载驱动类
			Class.forName(DRIVER_NAME);
			//创建数据库连接对象
			conn=DriverManager.getConnection(URL,USER_NAME,PASSWORD);  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		Connection conn=createConnection();
	}

}
