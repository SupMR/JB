package com.jzfactory.jd.student.service;

import com.jzfactory.jd.student.bean.Clasz;
import com.jzfactory.jd.student.bean.Student;

/**
 * 班级处理接口
 * @author 阿少
 *
 */
public interface ClaszService {

	void add(Clasz c);
	/**
	 * 删除学生
	 * @param studId
	 */
	void deleteClasz(int clasId);
	/**
	 * 更新学生的信息
	 * @param stud
	 */
	void updateClasz(Clasz clas);
}
