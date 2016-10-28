package com.jzfactory.jd.student.service;

import java.util.List;

import com.jzfactory.jd.student.bean.BlackTable;
import com.jzfactory.jd.student.dao.BlackTableDao;
import com.jzfactory.jd.student.dao.BlackTableDaoImpl;
import com.jzfactory.jd.student.util.DBConnection;
import com.mysql.jdbc.Connection;

public class BlackServiceImpl implements BlackService {

	private BlackTableDao btDao;
	
	public BlackServiceImpl(){
		Connection conn=(Connection) DBConnection.createConnection();
        btDao=new BlackTableDaoImpl(conn);
	}
	@Override
	public List<BlackTable> getAll() {
		// TODO Auto-generated method stub
		return btDao.findAll();
	}

	@Override
	public BlackTable findByName(String name) {
		// TODO Auto-generated method stub
		return btDao.findByName(name);
	}

	@Override
	public void saveBlack(BlackTable black) {
		// TODO Auto-generated method stub
          btDao.insert(black);
	}

	@Override
	public void updateBlack(BlackTable black) {
		// TODO Auto-generated method stub
          btDao.updateByName(black);
	}

	@Override
	public List<BlackTable> getInTable() {
		// TODO Auto-generated method stub
		return btDao.findInTable();
	}

	@Override
	public boolean isInBlack(String name) {
		// TODO Auto-generated method stub
		BlackTable bt=new BlackTable();
		bt=btDao.findByName(name);
		if(bt!=null){
			return true;
		}else{
			return false;
		}
		
	}

}
