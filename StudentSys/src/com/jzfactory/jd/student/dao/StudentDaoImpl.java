package com.jzfactory.jd.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.jzfactory.jd.student.bean.Clasz;
import com.jzfactory.jd.student.bean.Student;
import com.jzfactory.jd.student.util.DBConnection;


public class StudentDaoImpl implements StudentDao {

	private Connection conn;// 锟斤拷菘锟斤拷锟斤拷佣锟斤拷锟�

	public StudentDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void add(Student stud) {
		String sql = "insert into student(name,code,sex,birth,class_id) values(?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			// 锟斤拷取sql锟斤拷锟街达拷卸锟斤拷锟�
			ps = conn.prepareStatement(sql);
			// 锟斤拷锟矫诧拷锟斤拷
			ps.setString(1, stud.getName());
			ps.setString(2, stud.getCode());
			ps.setInt(3, stud.getSex());
			ps.setDate(4, new java.sql.Date(stud.getBirth().getTime()));
			ps.setInt(5, stud.getClass_id());
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
	public void add(List<Student> sList) {
		if (sList != null) {
			for (Student stu : sList) {
				add(stu);
			}
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from student where id=" + id;
		PreparedStatement ps = null;

		try {
			// 锟斤拷取sql锟斤拷锟街达拷卸锟斤拷锟�
			ps = conn.prepareStatement(sql);

			ps.executeUpdate(sql);

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
	public int deleteByClsId(int claszId) {
		String sql = "delete from student where class_id=?" ;
		PreparedStatement ps = null;
		int count=0;
		try {
			// 锟斤拷取sql锟斤拷锟街达拷卸锟斤拷锟�
			ps = conn.prepareStatement(sql);
			ps.setInt(1, claszId);
			count=ps.executeUpdate();
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

		return count;
	}

	@Override
	public int deleteByClsName(String claszName) {
		String sql = "selete id from clasz where name=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 锟斤拷取sql锟斤拷锟街达拷卸锟斤拷锟�
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, claszName);
			rs = ps.executeQuery();
			Integer id=null;
			while (rs.next()) {
				id=rs.getInt(1);

			}
			if(!ps.isClosed())
				ps.close();
			if(!rs.isClosed())
				rs.close();
			
			sql="delete from student where class_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate();
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
		return 0;
	}

	@Override
	public void update(Student student) {
		String sql = "update student set name=?,code=?,sex=?,birth=?,class_id=? where id=?";
		PreparedStatement ps = null;

		try {
			// 锟斤拷取sql锟斤拷锟街达拷卸锟斤拷锟�
			ps = conn.prepareStatement(sql);
			// 锟斤拷锟矫诧拷锟斤拷
			ps.setString(1, student.getName());
			ps.setString(2, student.getCode());
			ps.setInt(3, student.getSex());
			ps.setDate(4, new java.sql.Date(student.getBirth().getTime()));
			ps.setInt(5, student.getClass_id());
			ps.setInt(6, student.getId());
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
	public int updateClaszId(List<Student> studList, int ClaszId) {
		if(studList!=null){
			for(Student s:studList){
				s.setClass_id(ClaszId);
				update(s);
			}
		}

		return studList.size();
	}

	@Override
	public Student findById(int id) {
		String sql = "select * from student where id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stud = null;
		try {
			// 锟斤拷菘锟街达拷卸锟斤拷锟�
			ps = conn.prepareStatement(sql);
			// 锟斤拷锟矫诧拷锟斤拷
			ps.setInt(1, id);
			// 锟斤拷取锟斤拷锟�
			rs = ps.executeQuery();

			while (rs.next()) {
				stud = new Student();
				stud.setId(rs.getInt(1));
				stud.setName(rs.getString(2));
				stud.setCode(rs.getString(3));
				stud.setSex(rs.getInt(4));
				stud.setBirth(rs.getDate(5));
				stud.setClass_id(rs.getInt(6));

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
		return stud;
	}

	@Override
	public List<Student> findByName(String name) {
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from student where name like ?";
		Student stud = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 锟斤拷菘锟街达拷卸锟斤拷锟�
			ps = conn.prepareStatement(sql);
			// 锟斤拷锟矫诧拷锟斤拷
			ps.setString(1, "%"+name+"%");
			// 锟斤拷取锟斤拷锟�
			rs = ps.executeQuery();
			while (rs.next()) {
				stud = new Student();
				stud.setId(rs.getInt(1));
				stud.setName(rs.getString(2));
				stud.setCode(rs.getString(3));
				stud.setSex(rs.getInt(4));
				stud.setBirth(rs.getDate(5));
				stud.setClass_id(rs.getInt(6));
				list.add(stud);

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
		return list;
	}

	@Override
	public Student findByCode(String code) {
		String sql = "select * from student where code=?";
		Student stud = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 锟斤拷菘锟街达拷卸锟斤拷锟�
			ps = conn.prepareStatement(sql);
			// 锟斤拷锟矫诧拷锟斤拷
			ps.setString(1, code);
			// 锟斤拷取锟斤拷锟�
			rs = ps.executeQuery();
			while (rs.next()) {
				stud = new Student();
				stud.setId(rs.getInt(1));
				stud.setName(rs.getString(2));
				stud.setCode(rs.getString(3));
				stud.setSex(rs.getInt(4));
				stud.setBirth(rs.getDate(5));
				stud.setClass_id(rs.getInt(6));

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
		return stud;
	}

	@Override
	public List<Student> findAll() {
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from student";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stud = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				stud = new Student();
			
				stud.setId(rs.getInt(1));
				stud.setName(rs.getString(2));
				stud.setCode(rs.getString(3));
				stud.setSex(rs.getInt(4));
				stud.setBirth(rs.getDate(5));
				stud.setClass_id(rs.getInt(6));
				list.add(stud);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Student> findAllByClsId(int claszId) {
		List<Student> list=new ArrayList<Student>();
		String sql="select * from student where class_id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stud=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, claszId);
			rs = ps.executeQuery();
			while (rs.next()) {
				stud = new Student();
			
				stud.setId(rs.getInt(1));
				stud.setName(rs.getString(2));
				stud.setCode(rs.getString(3));
				stud.setSex(rs.getInt(4));
				stud.setBirth(rs.getDate(5));
				stud.setClass_id(rs.getInt(6));
				list.add(stud);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Clasz findClsByStudId(int studId) {
		String sql="select c.* from clasz c join student s on c.id=s.class_id where s.id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, studId);
			rs = ps.executeQuery();
			while (rs.next()) {
			int c_id=rs.getInt(1);
			String c_name=rs.getString(2);
			String c_tname=rs.getString(3);
			Clasz cls=new Clasz();
			cls.setId(c_id);
			cls.setName(c_name);
			cls.setT_name(c_tname);
			return cls;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws ParseException {
		Connection conn = DBConnection.createConnection();
		StudentDao studentDao = new StudentDaoImpl(conn);
		// 锟斤拷锟窖э拷锟�
		Student stud = new Student();
		// stud.setCode("01");
		// stud.setName("锟斤拷锟斤拷");
		// stud.setSex(1);
		//
		// SimpleDateFormat sf=new SimpleDateFormat("yyyy-mm-dd");
		// String ddte="1996-08-15";
		// Date date=null;
		// try {
		// date = sf.parse(ddte);
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// stud.setBirth(date);
		// stud.setClass_id(1);
		// StudentDao stuDao=new StudentDaoImpl(conn);
		// stuDao.add(stud);

		/**
		 * 锟斤拷佣锟斤拷
		 */
		// stud.setName("锟斤拷锟斤拷");
		// stud.setCode("1402180111");
		// stud.setSex(0);
		// SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		// String ddte="1996-10-27";
		// Date date;
		// date = sf.parse(ddte);
		// stud.setBirth(date);
		// stud.setClass_id(2);;
		//
		// Student stud1 = new Student();
		// stud1.setName("锟劫猴拷");
		// stud1.setCode("1402180111");
		// stud1.setSex(0);
		// stud1.setBirth(date);
		// stud1.setClass_id(2);
		// List<Student> list=new ArrayList<Student>();
		//
		// list.add(stud);
		// list.add(stud1);
		//
		// studentDao.add(list);

		// studentDao.delete(2);

//		int count= studentDao.deleteByClsId(3);
//		System.out.println(count);

		// stud.setName("锟斤拷锟斤拷1");
		// stud.setCode("03");
		// SimpleDateFormat sf=new SimpleDateFormat("yyyy-mm-dd");
		// String ddte="1970-02-14";
		// Date date=null;
		// date = sf.parse(ddte);
		// stud.setBirth(date);
		// stud.setClass_id(3);
		// stud.setId(3);
		// studentDao.update(stud);

		// stud=studentDao.findById(3);
		// System.out.println(stud);

		// List<Student> list=studentDao.findByName("锟斤拷锟斤拷1");
		// System.out.println(list);

		// stud=studentDao.findByCode("03");
		// System.out.println(stud);

		// 锟斤拷锟斤拷锟斤拷锟斤拷学锟斤拷锟斤拷息
		// List<Student> list=studentDao.findAll();
		// System.out.println(list);
		
		
//		List<Student> list=studentDao.findAllByClsId(3);
//		studentDao.findAll();
//		System.out.println(list);
		
		
//		Clasz clasz=studentDao.findClsByStudId(5);
//		System.out.println(clasz);
		
		
		//System.out.println(Arrays.toString(studentDao.countBySex(2)));
		
		System.out.println(studentDao.findByPage(2, 2, 4));
	}

	@Override
	public int[] countBySex(int claszId) {
	    String sql="select sex, count(*) from student where class_id=? group by sex;";
	    PreparedStatement ps = null;
		ResultSet rs = null;
		int[] count=new int[2];
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,claszId);
			rs=ps.executeQuery();
			while(rs.next()){
				int sex=rs.getInt(1);
				int num=rs.getInt(2);
				count[sex]=num;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public List<Student> findByName(int clsId, String name) {
		// TODO Auto-generated method stub
		String sql="select * from student where class_id=? and name like ?";
		List<Student> list=new ArrayList<Student>();
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 Student stud=null;
		 try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, clsId);
			ps.setString(2, "%"+name+"%");
			rs=ps.executeQuery();
			while (rs.next()) {
				stud = new Student();
				stud.setId(rs.getInt(1));
				stud.setName(rs.getString(2));
				stud.setCode(rs.getString(3));
				stud.setSex(rs.getInt(4));
				stud.setBirth(rs.getDate(5));
				stud.setClass_id(rs.getInt(6));
				list.add(stud);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Student> findByPage(int clsId, int startIndex, int stopIndex) {
		String sql="select * from student where class_id=? limit ?,?";
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 Student stud=null;
         List<Student> sList=new ArrayList<Student>();
			try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1, clsId);
				ps.setInt(2, startIndex-1);
				ps.setInt(3, stopIndex-startIndex+1);
				rs=ps.executeQuery();
				while (rs.next()) {
					stud = new Student();
					stud.setId(rs.getInt(1));
					stud.setName(rs.getString(2));
					stud.setCode(rs.getString(3));
					stud.setSex(rs.getInt(4));
					stud.setBirth(rs.getDate(5));
					stud.setClass_id(rs.getInt(6));
					sList.add(stud);

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


		return sList;
	}
}
