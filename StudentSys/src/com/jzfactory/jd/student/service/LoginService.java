package com.jzfactory.jd.student.service;

import com.jzfactory.jd.student.bean.User;






/**
 * 登录注册服务接口
 * @author 孙超 2016-08-25
 *
 */
public interface LoginService {
	/**
	 * 注册用户
	 * @param user用户信息s
	 * @return 0-成功 1-用户已存在
	 */
	int register(User user);
	/**
	 * 用户登录
	 * @param user 登录的用户信息
	 * @return 0-成功  1-用户不存在  2-用户密码不正确
	 */
	int login(User user);
	/**
	 * 用户登录
	 * @param username名称
	 * @param password密码
	 * @return登陆成功返回当前登录用户对象
	 */
	void login(String username,String password);

}
