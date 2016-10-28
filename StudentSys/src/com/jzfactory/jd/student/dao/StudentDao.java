package com.jzfactory.jd.student.dao;

import java.util.List;

import com.jzfactory.jd.student.bean.Clasz;
import com.jzfactory.jd.student.bean.Student;

/**
 * 学锟斤拷锟斤拷荽锟斤拷锟斤拷锟�
 * @author yangxuefeng 2016-9-1
 *
 */


public interface StudentDao {
	/**
	 * 锟斤拷锟揭伙拷锟窖э拷锟�
	 * @param stud
	 */
	void add(Student stud);
	/**
	 * 锟斤拷佣锟斤拷学锟斤拷
	 * @param sList
	 */
	void add(List<Student> sList);
	/**
	 * 通锟斤拷id删锟斤拷学锟斤拷
	 * @param id
	 */
	void delete(int id);
	
	/**
	 * 通锟斤拷嗉秈d删锟斤拷学锟斤拷
	 * @param claszId 锟洁级锟斤拷id
	 * @return 删锟斤拷锟窖э拷锟斤拷锟斤拷锟�
	 */
	int deleteByClsId(int claszId);
	/**
	 * 通锟斤拷嗉讹拷锟斤拷锟斤拷删锟斤拷学锟斤拷
	 * @param claszName 锟洁级锟斤拷锟斤拷锟�
	 * @return  删锟斤拷锟窖э拷锟斤拷锟斤拷锟�
	 */
	int deleteByClsName(String claszName);
	/**
	 * 锟睫革拷学锟斤拷锟斤拷息
	 * @param student
	 */
	void update(Student student);
	
	/**
	 * 锟睫革拷一锟斤拷学锟斤拷锟斤拷锟节的班级
	 * @param studList  学锟斤拷锟�
	 * @param ClaszId 锟铰的班级id
	 * @return 锟斤拷牡锟窖э拷锟斤拷锟斤拷锟�
	 */
	int updateClaszId(List<Student> studList,int ClaszId);
	
	/**
	 * 通锟斤拷id锟斤拷询学锟斤拷锟斤拷锟较�
	 * @param id 学锟斤拷锟絠d
	 * @return 学锟斤拷锟斤拷锟�
	 */
	Student findById(int id);
	/**
	 * 通锟斤拷锟斤拷撇锟斤拷锟窖э拷锟斤拷锟较拷锟街э拷锟侥ｏ拷锟斤拷询锟斤拷
	 * @param name 学锟斤拷锟斤拷锟斤拷锟�
	 * @return 学锟斤拷募锟斤拷锟�
	 */
	List<Student> findByName(String name);
	/**
	 * 通锟斤拷学锟斤拷学锟脚查看学锟斤拷锟斤拷息
	 * @param code 学锟斤拷
	 * @return
	 */
	Student findByCode(String code);
	
	/**	 * 锟斤拷锟斤拷锟斤拷锟斤拷学锟斤拷锟斤拷息
	 * @return
	 */
	List<Student> findAll();
	/**
	 * 通锟斤拷嗉秈d锟斤拷锟斤拷锟斤拷锟窖э拷锟斤拷锟较�
	 * @param claszId 锟洁级id
	 * @return 学锟斤拷锟�
	 */
	List<Student> findAllByClsId(int claszId);
	/**
	 * 锟斤拷询某锟斤拷学锟斤拷锟斤拷锟节的班级
	 * @param studId 学锟斤拷id
	 * @return
	 */
	Clasz findClsByStudId(int studId);
	
	/**
	 * 统锟斤拷某锟斤拷锟斤拷锟斤拷锟脚拷锟斤拷锟�
	 * @param claszId 锟铰憋拷 0-女锟斤拷锟斤拷锟斤拷  1-锟斤拷锟斤拷锟斤拷锟斤拷
	 * @return
	 */
	int[] countBySex(int claszId);
/**
 * 通过名字查找摸个班级同学信息
 * @param clsId
 * @param name
 * @return
 */
	public List<Student> findByName(int clsId,String name);
	/**
	 * 通过分页查询某个班级的同学信息
	 * @param clsId
	 * @param startIndex
	 * @param stopIndex
	 * @return
	 */
	public List<Student> findByPage(int clsId,int startIndex,int stopIndex);
}
