package com.jzfactory.jd.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ݿ����ӹ�����
 * @author yangxf 2016-08-24
 *
 */
public class DBConnection {
	//���ݿ�����������
	 private static final String  DRIVER_NAME="com.mysql.jdbc.Driver";
	
		//���ݿ����ӵ�ַ
	private static final String  URL="jdbc:mysql://localhost:3306/login";
	//�û�����
	private static final String USER_NAME="root";
	
	//�û�����
	private static final String PASSWORD="root";
	/**
	 * �������ݿ����Ӷ���
	 */
	public static Connection createConnection(){
		Connection conn=null;
		try {
			//����������
			Class.forName(DRIVER_NAME);
			//�������ݿ����Ӷ���
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
