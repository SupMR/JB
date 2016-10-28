package com.jzfactory.jd.student.bean;

import java.util.Date;
import java.util.List;

/**
 * ����ѧ��ʵ����
 * @author yangxuefeng 2016-9-1
 *
 */
public class Student {
	
	private int id;//����
	
	private String name;//ѧ������
	
	private String code;//ѧ������
	
	private int sex;//�Ա� 0-Ů  1-��
	
	private Date birth;//��������
	
	private int class_id;//�༶id

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
