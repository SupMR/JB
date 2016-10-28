package com.jzfactory.jd.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jzfactory.jd.student.bean.BlackTable;
import com.jzfactory.jd.student.bean.Student;
import com.jzfactory.jd.student.util.DBConnection;

public class BlackTableDaoImpl implements BlackTableDao {

	private Connection conn;// ��ݿ����Ӷ���
	public BlackTableDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(BlackTable bt) {
		// TODO Auto-generated method stub

		String sql="insert into blacktable(username,includeDate,removed)values(?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bt.getUsername());
			ps.setDate(2,new java.sql.Date(bt.getIncludeDate().getTime()));
			ps.setInt(3, bt.getRemoved());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block)
			e.printStackTrace();
		}
		finally {try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	}

	@Override
	public void updateByName(BlackTable bt) {
		// TODO Auto-generated method stub

		String sql="update blacktable set includeDate=?,removed=? where username=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(bt.getIncludeDate().getTime()));	
			ps.setInt(2, bt.getRemoved());
			ps.setString(3, bt.getUsername());
			ps.executeUpdate();

			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<BlackTable> findAll() {
		List<BlackTable> list = new ArrayList<BlackTable>();
		String sql="select * from blacktable";
		PreparedStatement ps = null;
		ResultSet rs = null;
		BlackTable bt=null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bt=new BlackTable();
				bt.setId(rs.getInt(1));
				bt.setUsername(rs.getString(2));
				String dateStr=rs.getString(3);
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date;
				try {
					date = format.parse(dateStr);
					bt.setIncludeDate(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				bt.setRemoved(rs.getInt(4));
				list.add(bt);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return list;
	}

	@Override
	public List<BlackTable> findInTable() {
		List<BlackTable> list = new ArrayList<BlackTable>();
		String sql="select * from blacktable where removed=0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		BlackTable bt=null;
		try {
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
			    bt=new BlackTable();
			    bt.setId(rs.getInt(1));
			    bt.setUsername(rs.getString(2));
			    bt.setIncludeDate(rs.getDate(3));
			    bt.setRemoved(rs.getInt(4));
			    list.add(bt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public BlackTable findByName(String name) {
 
		String sql="select * from blacktable where username=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		BlackTable bte=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			while (rs.next()) {
			    bte=new BlackTable();
			    bte.setId(rs.getInt(1));
			    bte.setUsername(rs.getString(2));
			    bte.setIncludeDate(rs.getDate(3));
			    bte.setRemoved(rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return bte;
	}
	
	public static void main(String[] args) throws ParseException{
		Connection conn = DBConnection.createConnection();
		BlackTableDao btDao = new BlackTableDaoImpl(conn);
	    BlackTable bl=new BlackTable();
//	    bl.setUsername("张丹");
//        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
//        String ddte="1996-08-15";
//        Date date=null;
//		try {
//			 date=sf.parse(ddte);
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 bl.setIncludeDate(date);
//		 btDao.insert(bl);
	    
	    
//	    bl.setUsername("张丹");
//		
//		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
//		 String ddte="1970-02-14";
//		Date date=null;
//		date = sf.parse(ddte);
//		bl.setIncludeDate(date);
//		
//		btDao.updateByName(bl);
  
//	    List<BlackTable> list=btDao.findInTable();
//	    System.out.println(list);
	    
//	    List<BlackTable> list=btDao.findAll();
//	    System.out.println(list);
	    bl.setUsername("张三");
      SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
      String ddte="1996-05-11";
      Date date=null;
		try {
			 date=sf.parse(ddte);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 bl.setIncludeDate(date);
		 btDao.insert(bl);
	}

}
