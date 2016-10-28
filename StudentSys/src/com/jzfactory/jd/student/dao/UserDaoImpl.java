package com.jzfactory.jd.student.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jzfactory.jd.student.bean.User;
import com.jzfactory.jd.student.util.DBConnection;


public class UserDaoImpl implements UserDao {

	private Connection conn;// ��ݿ����Ӷ���

	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into User(name, password,email,status) values(?,?,?,?)";
		PreparedStatement ps = null;
		try {
			// ��ȡsql���ִ�ж���
			ps = conn.prepareStatement(sql);
			// ���ò���
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getStatus());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub

		String sql = "delete from User where id=" + id;
		PreparedStatement st = null;

		try {
			// ��ȡsql���ִ�ж���
			st = conn.prepareStatement(sql);

			st.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void upDateUser(User user) {
		// TODO Auto-generated method stub
		String sql = "update user set name=?,password=?,email=? where id=?";
		PreparedStatement ps = null;

		try {
			// ��ȡsql���ִ�ж���
			ps = conn.prepareStatement(sql);
			// ���ò���
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getId());
			// ִ�����
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from user where id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			// ��ݿ�ִ�ж���
			ps = conn.prepareStatement(sql);
			// ���ò���
			ps.setInt(1, id);
			// ��ȡ���
			rs = ps.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
			    user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setStatus(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from user where name=?";
		User user = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// ��ݿ�ִ�ж���
			ps = conn.prepareStatement(sql);
			// ���ò���
			ps.setString(1, name);
			// ��ȡ���
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setStatus(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

	public static void main(String[] args) {
		Connection conn = DBConnection.createConnection();
		// ����û�
		User user = new User();
		// user.setName("����");
		// user.setPassword("123456");
		// user.setEmail("aa@gan.com");
		// UserDao userDao=new UserDaoImpl(conn);
		// userDao.addUser(user);

		UserDao userDao = new UserDaoImpl(conn);
		// userDao.deleteUser(6);

		// user.setName("�ƻ�");
		//user.setPassword("1111");
		// user.setId(5);
		// userDao.upDateUser(user);

//		user = userDao.findById(5);
//		System.out.println(user);

		// user=userDao.findByName("11");
		// System.out.println(user);
		
//		List list=userDao.findAll();
//		System.out.println(list);

	}

	@Override
	public List findAll() {
		String sql="select * from User where status=0";
		List list=new ArrayList();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user=null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setStatus(rs.getInt(5));
				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public List findBlackList() {
		String sql="select * from User where status=1";
		List list=new ArrayList();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user=null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setStatus(rs.getInt(5));
				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public void updateStatus(User user) {
		
		
		String sql = "update user set status=? where id=?";
		PreparedStatement ps = null;
		try {
			// ��ȡsql���ִ�ж���
			ps = conn.prepareStatement(sql);	
		    if(user.getStatus()==0){
		    	ps.setInt(1, 1);
		    }else if(user.getStatus()==1){
		    	ps.setInt(1, 0);
		    }
		    ps.setInt(2, user.getId());
			// ִ�����
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public User login(String username, String password) {
		String sql="select * from user where name='"+username+"' and password='"+password+"'";
		PreparedStatement ps = null;
		User user=null;
		try {
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setStatus(rs.getInt("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
	
}

	


	


	