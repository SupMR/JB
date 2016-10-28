package com.jzfactory.jd.student.bean;

import java.util.List;

/**
 * 创建班级实体类
 * @author yangxuefeng 2016-9-1
 *
 */
public class Clasz {
	
	private int id;//主键
	
	private String name;//班级名称
	
	private String t_name;//班主任姓名

	private List<Student> studList;//班级下的学生

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

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public List<Student> getStudList() {
		return studList;
	}

	public void setStudList(List<Student> studList) {
		this.studList = studList;
	}

	@Override
	public String toString() {
		return "Clasz [id=" + id + ", name=" + name + ", t_name=" + t_name
				+ ", studList=" + studList + "]";
	}

	public Clasz(int id, String name, String t_name, List<Student> studList) {
		super();
		this.id = id;
		this.name = name;
		this.t_name = t_name;
		this.studList = studList;
	}

	public Clasz() {
		super();
	}
	
}
