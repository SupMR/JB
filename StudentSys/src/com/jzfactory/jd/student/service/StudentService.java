
package com.jzfactory.jd.student.service;

import java.util.List;
import java.util.Map;

import com.jzfactory.jd.student.bean.Clasz;
import com.jzfactory.jd.student.bean.Student;

/**
 * 瀛︾敓涓氬姟閫昏緫澶勭悊鎺ュ彛
 * @author 闃垮皯
 *
 */
public interface StudentService {
   /**
    * 鑾峰彇鎵�湁鐝骇鐨勫悕绉板拰id
    * @return
    */
	Map<Integer,String> getClaszNameWithId();
	/**
	 * 缁熻鏌愪釜鐝骇鐨勭敺濂崇敓浜烘暟
	 * @param claszId
	 * @return鏁扮粍涓嬫爣0-濂�
	 */
	int[] countBySex(int claszId);
	/**
	 * 閫氳繃鐝骇鐨刬d鑾峰彇鏌愪釜鐝骇瀵硅薄
	 * @param claszId
	 * @return
	 */
	Clasz getClasz(int claszId);
	/**
	 * 娣诲姞瀛︾敓
	 * @param s
	 */
	void add(Student s);
	/**
	 * 鍒犻櫎瀛︾敓
	 * @param studId
	 */
	void deleteStudent(int studId);
	/**
	 * 鏇存柊瀛︾敓鐨勪俊鎭�
	 * @param stud
	 */
	void updateStudent(Student stud);
	/**
	 * 閫氳繃鍚嶅瓧杩涜妯＄硦鏌ヨ
	 * @param name
	 * @return
	 */
	List<Student> findByName(int clsId,String name);
	/**
	 * 获取当前页的信息
	 * @param currPage
	 * @return
	 */
	List<Student> findByPage(int clsId,int count,int currPage);
}
