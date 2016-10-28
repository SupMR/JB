package com.jzfactory.jd.student.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jzfactory.jd.student.bean.Clasz;
import com.jzfactory.jd.student.bean.Student;
import com.jzfactory.jd.student.dao.ClaszDao;
import com.jzfactory.jd.student.dao.ClaszDaoImpl;
import com.jzfactory.jd.student.dao.StudentDao;
import com.jzfactory.jd.student.dao.StudentDaoImpl;
import com.jzfactory.jd.student.util.DBConnection;
import com.jzfactory.jd.student.util.Pagination;
import com.mysql.jdbc.Connection;


public class StudentServiceImpl implements StudentService {
 
	public static final int PAGE_SIZE=5;
	
	private ClaszDao clsDao;
	private StudentDao stuDao;
	
	public StudentServiceImpl() {
		Connection conn=(Connection) DBConnection.createConnection();
		clsDao=new ClaszDaoImpl(conn);
		stuDao=new StudentDaoImpl(conn);
	}

	@Override
	public Map<Integer, String> getClaszNameWithId() {
		// TODO Auto-generated method stub
		Map<Integer,String> map=new LinkedHashMap<Integer, String>();
		//鑾峰彇鎵�湁鐝骇鐨勬暟鎹�
		List<Clasz> sList=clsDao.findAll();
		//灏嗘瘡涓彮绾х殑id涓巒ame瀛樺叆鍒癿ap涓�
		for(Clasz cls:sList)
		{
			map.put(cls.getId(), cls.getName());
		}
		return map;
	}

	@Override
	public int[] countBySex(int claszId) {
		// TODO Auto-generated method stub
		return stuDao.countBySex(claszId);
	}

	@Override
	public Clasz getClasz(int claszId) {
		// TODO Auto-generated method stub
		return clsDao.findById(claszId);
	}

	@Override
	public void add(Student s) {
		// TODO Auto-generated method stub
		stuDao.add(s);
	}

	@Override
	public void deleteStudent(int studId) {
		// TODO Auto-generated method stub
		 stuDao.delete(studId);
	}

	@Override
	public void updateStudent(Student stud) {
		// TODO Auto-generated method stub
		stuDao.update(stud);
	}

	@Override
	public List<Student> findByName(int clsId,String name) {
		// TODO Auto-generated method stub
		
		return stuDao.findByName(clsId,name);
	}

	@Override
	public List<Student> findByPage(int clsId,int count,int currPage) {

		Pagination pagination=new Pagination(count,PAGE_SIZE);
		pagination.setCurrPage(currPage);
		int startIndex=pagination.getStartIndex();
		int stopIndex=pagination.getStopIndex();
		
		return stuDao.findByPage(clsId, startIndex, stopIndex);
	}

}
