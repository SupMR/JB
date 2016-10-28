package com.jzfactory.jd.student.bean;

import java.util.Date;
import java.util.List;

/**
 * 创建学生实体类
 * @author yangxuefeng 2016-9-1
 *
 */
public class Student {
	
	private int id;//主键
	
	private String name;//学生姓名
	
	private String code;//学生编码
	
	private int sex;//性别 0-女  1-男
	
	private Date birth;//出生日期
	
	private int class_id;//班级id

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", code=" + code
				+ ", sex=" + sex + ", birth=" + birth + ", class_id="
				+ class_id + "]";
	}

	public Student(int id, String name, String code, int sex, Date birth,
			int class_id) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.sex = sex;
		this.birth = birth;
		this.class_id = class_id;
	}

	public Student() {
		super();
	}


	


}
