package com.jzfactory.jd.student.service;



import java.util.List;

import com.jzfactory.jd.student.bean.BlackTable;



/**
 * ����ҵ���߼�������
 * @author songwp 2016-09-13
 *
 */
public interface BlackService {
	
	/**
	 * ��ȡ���еĺ����û���Ϣ
	 * @return
	 */
	List<BlackTable> getAll();
	/**
	 * ͨ�����ֲ��ҵ����û�
	 * @param name
	 * @return
	 */
	BlackTable findByName(String name);
	/**
	 * �������û�
	 * @param black
	 */
	void saveBlack(BlackTable black);
     /**
      * �����û�
      * @param black
      * 
      */
	void updateBlack(BlackTable black);
	/**
	 * ��ȡ�����е��û���Ϣ
	 * @return
	 */
	List<BlackTable> getInTable();
	/**
	 * �ж��û��Ƿ��ں�����
	 * @param name
	 * @return true-�� false-����
	 */
	boolean isInBlack(String name);
}
