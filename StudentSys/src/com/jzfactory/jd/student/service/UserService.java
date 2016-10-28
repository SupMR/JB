package com.jzfactory.jd.student.service;

import java.util.List;

import com.jzfactory.jd.student.bean.User;



/**
 * @author Administrator
 *
 */
public interface UserService {
	List findAll();
	
	List findBlackList();
	
	User findById(int id);
	
	void updateStatus(User user);
	
	/**
	 * ͨ���û���Ʋ����û�
	 * @param name
	 * @return
	 */
	
	User findByName(String name);
	
	
	void updateUser(User user);
	
	void addUser(User user);
	
	void deleteUser(int id);

}
