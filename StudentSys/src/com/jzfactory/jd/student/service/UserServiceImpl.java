package com.jzfactory.jd.student.service;


import java.sql.Connection;
import java.util.List;

import com.jzfactory.jd.student.bean.User;
import com.jzfactory.jd.student.dao.UserDao;
import com.jzfactory.jd.student.dao.UserDaoImpl;
import com.jzfactory.jd.student.util.DBConnection;


public class UserServiceImpl implements UserService {

	private UserDao userDao;//�û�Dao

	public UserServiceImpl(){
		Connection conn=DBConnection.createConnection();
		userDao=new UserDaoImpl(conn);
	}

	@Override
	public List findAll() {
		
		return userDao.findAll();
	}

	@Override
	public List findBlackList() {
		// TODO Auto-generated method stub
		return userDao.findBlackList();
	}

	@Override
	public void updateStatus(User user) {
		userDao.updateStatus(user);
		
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findByName(name);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.upDateUser(user);
		
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(id);
		
	}

}
