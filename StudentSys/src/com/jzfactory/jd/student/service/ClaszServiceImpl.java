package com.jzfactory.jd.student.service;

import com.jzfactory.jd.student.bean.Clasz;
import com.jzfactory.jd.student.dao.ClaszDao;
import com.jzfactory.jd.student.dao.ClaszDaoImpl;
import com.jzfactory.jd.student.dao.StudentDao;
import com.jzfactory.jd.student.dao.StudentDaoImpl;
import com.jzfactory.jd.student.util.DBConnection;
import com.mysql.jdbc.Connection;

public class ClaszServiceImpl implements ClaszService {

	private ClaszDao clsDao;
	private StudentDao stuDao;
	
	public ClaszServiceImpl() {
		Connection conn=(Connection) DBConnection.createConnection();
		clsDao=new ClaszDaoImpl(conn);
		stuDao=new StudentDaoImpl(conn);
	}
	@Override
	public void add(Clasz c) {
		// TODO Auto-generated method stub
        clsDao.add(c);
	}

	@Override
	public void deleteClasz(int clasId) {
		// TODO Auto-generated method stub
          clsDao.delete(clasId, true);
	}

	@Override
	public void updateClasz(Clasz clas) {
		// TODO Auto-generated method stub
         clsDao.update(clas);
	}

}
