package com.jzfactory.jd.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jzfactory.jd.student.bean.Clasz;
import com.jzfactory.jd.student.bean.Student;
import com.jzfactory.jd.student.util.DBConnection;

public class ClaszDaoImpl implements ClaszDao {

	private Connection conn;// ��ݿ����Ӷ���

	public ClaszDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void add(Clasz cls) {
		String sql = "insert into clasz(name,t_name) values(?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// ����༶��Ϣ
			ps = conn.prepareStatement(sql);
			ps.setString(1, cls.getName());
			ps.setString(2, cls.getT_name());
			ps.executeUpdate();
			// ��ȡ�ð༶��id
			sql = "select id from clasz where name=?";

			if (!ps.isClosed())
				ps.close();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cls.getName());
			rs = ps.executeQuery();
			while (rs.next()) {
				cls.setId(rs.getInt(1));
				break;
			}

			// ����ѧ����Ϣ
			List<Student> sList = cls.getStudList();
			if (sList != null && sList.size() > 0) {
				String sql1 = "insert into student(name,code,sex,birth,class_id) values(?,?,?,?,?)";
				for (Student s : sList) {
					if (!ps.isClosed())
						ps.close();
					ps = conn.prepareStatement(sql1);
					ps.setString(1, s.getName());
					ps.setString(2, s.getCode());
					ps.setInt(3, s.getSex());
					ps.setDate(4, new java.sql.Date(s.getBirth().getTime()));
					ps.setInt(5, cls.getId());
					ps.execute();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (!ps.isClosed())
					ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean delete(int claszId, boolean isDelStud) {
		// TODO Auto-generated method stub

		PreparedStatement ps=null;
		if(isDelStud)
		{
			String sql="delete from student where class_id=?";
			try {
				//ɾ��ð��ѧ����Ϣ
				ps=conn.prepareStatement(sql);
				ps.setInt(1, claszId);
				ps.execute();
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
		}else{
			String sql="select * from student where class_id=?";
			ResultSet rs=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1, claszId);
				rs=ps.executeQuery();
				if(rs!=null&&rs.next())
				{
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					ps.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//ɾ��༶
		String sql="delete from clasz where id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, claszId);
			boolean isOK=ps.execute();
			return true;
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
		return false;

	}

	@Override
	public void update(Clasz cls) {
		String sql = "update clasz set name=?,t_name=? where id=?";
		PreparedStatement ps = null;

		try {
			// ��ȡsql���ִ�ж���
			ps = conn.prepareStatement(sql);
			// ���ò���
			
			ps.setString(1, cls.getName());
			ps.setString(2, cls.getT_name());
			ps.setInt(3, cls.getId());
			
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Clasz> findAll() {
		String sql = "select id from clasz";
		List<Integer> idList = new ArrayList<Integer>();
		List<Clasz> clsList = new ArrayList<Clasz>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				idList.add(rs.getInt(1));

			}
			for (Integer i : idList) {
				Clasz cls = this.findById(i);
				clsList.add(cls);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clsList;
	}

	@Override
	public Clasz findById(int id) {
		String sql = "select * from clasz where id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Clasz cls = null;
		try {
			ps = conn.prepareStatement(sql);
			// 设置参数
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				int c_id = rs.getInt(1);
				String c_name = rs.getString(2);
				String c_tname = rs.getString(3);
				cls = new Clasz(c_id, c_name, c_tname, null);
				break;
			}
			rs.close();
			ps.close();
			sql = "select * from student where class_id=?";
			ps = conn.prepareStatement(sql);
			List<Student> sList = new ArrayList<Student>();
			ps.setInt(1, cls.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				int s_id = rs.getInt(1);
				String s_code = rs.getString(3);
				String s_name = rs.getString(2);
				int s_sex = rs.getInt(4);
				Date s_birth = rs.getDate(5);
				int s_cls_id = rs.getInt(6);
				Student s = new Student();
				s.setId(s_id);
				s.setCode(s_code);
				s.setName(s_name);
				s.setSex(s_sex);
				s.setBirth(s_birth);
				s.setClass_id(s_cls_id);
				sList.add(s);
			}
			cls.setStudList(sList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return cls;
	}


	@Override
	public List<Clasz> findByName(String name) {

		String sql = "select * from clasz where name like'%" + name + "%' ";

		PreparedStatement ps = null;
		ResultSet rs = null;
		Clasz clasz = null;
		List<Clasz> list = new ArrayList<Clasz>();
		try {
			ps = conn.prepareStatement(sql);
			// ���ò���
			// ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				clasz = new Clasz();
				clasz.setId(rs.getInt(1));
				clasz.setName(rs.getString(2));
				// clasz.setT_name(rs.getString(3));
				list.add(clasz);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) {

		Connection conn = DBConnection.createConnection();
		ClaszDao claszDao = new ClaszDaoImpl(conn);

//		Student s1 = new Student();
//		s1.setName("name1");
//		s1.setSex(1);
//		s1.setCode("2");
//		s1.setBirth(new Date());
//
//		Student s2 = new Student();
//		s2.setName("name2");
//		s2.setSex(0);
//		s2.setCode("6");
//		s2.setBirth(new Date());
//
//		Student s3 = new Student();
//		s3.setName("name1");
//		s3.setSex(1);
//		s3.setCode("2");
//		s3.setBirth(new Date());
//
//		List<Student> sList = new ArrayList<Student>();
//		sList.add(s1);
//		sList.add(s2);
//		sList.add(s3);
//
//		Clasz cls = new Clasz();
//		cls.setName("�������");
//		cls.setT_name("����ʦ");
//		cls.setStudList(sList);

		// claszDao.add(cls);

//		boolean isOK = claszDao.delete(5, true);
//		System.out.println("delete isOK=" + isOK);

		Clasz clasz = new Clasz();
		 clasz.setName("一年二班");
		 clasz.setT_name("小芳");
		 clasz.setId(2);
		 claszDao.update(clasz);
		 System.out.println(clasz);

//		 List<Clasz> list=claszDao.findAll();
//		 System.out.println(list);

//		 clasz=claszDao.findById(4);
//		 System.out.println(clasz);

		// List<Clasz> list=claszDao.findByName("��");
		// System.out.println(list);

		
	}

}
