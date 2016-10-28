package com.jzfactory.jd.student.bean;
/**
 * �����û�ʵ����
 * @author yangxf 2016-08-24
 *
 */
public class User {
	
	private int id;//�û�id
	
	private String name;//�û����
	
	private String password;//�û�����
	
	private String email;//�û�����
	
	private int status;

	public User(int id, String name, String password, String email, int status) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.status = status;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
	

}
