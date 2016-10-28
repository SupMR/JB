package com.jzfactory.jd.student.dao;



import java.util.List;

import com.jzfactory.jd.student.bean.User;


/**
 * �����û���Dao���
 * @author yangxf 2016-08-24
 *
 */
/**
 * @author Administrator
 *
 */



public interface UserDao {
	/**
	 * ����û�
	 * @param user
	 */
	void addUser(User user);
	/**
	 * ͨ��idɾ���û�
	 * @param id
	 */
	void deleteUser(int id);

	/**
	 * �޸��û���Ϣ
	 * @param user
	 */
	void upDateUser(User user);
	/**
	 * �����û�
	 * @param id 
	 * @return ���û��Ķ���
	 */
	User findById(int id);
	/**
	 * ͨ���û���Ʋ����û�
	 * @param name �û����
	 * @return
	 */
	User findByName(String name);
	
	/**
	 * ����ȫ���û�
	 * @return list����
	 */
	List findAll();
	/**
	 * ���Һ�����Ա
	 * @return
	 */
	List findBlackList();
	
	/**
	 * �޸���Ա״̬
	 */
	void updateStatus(User user);
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	User login(String username,String password);
	
}
