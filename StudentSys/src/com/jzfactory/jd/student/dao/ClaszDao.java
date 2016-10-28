package com.jzfactory.jd.student.dao;

import java.util.List;

import com.jzfactory.jd.student.bean.Clasz;

/**
 * �༶��ݴ�����
 * @author yangxuefeng 2016-9-1
 *
 */

public interface ClaszDao {
	/**
	 * ��Ӱ༶
	 * ���°༶��ѧ�������ѧ����ѧ��Ҳ�������
	 * @param cls
	 */
	void add(Clasz cls);
	/**
	 * ͨ��༶idɾ��༶
	 * @param claszId �༶��id
	 * @param isDelStud �Ƿ���Թ���ɾ��ѧ�� true-����
	 * @return �Ƿ�ɾ��ɹ� true-�ɹ�
	 */
	boolean delete(int clasId,boolean isDelStud);
	/**
	 * ��İ༶����Ϣ
	 * @param cls 
	 */
	void update(Clasz cls);
	/**
	 * ��ѯ���а༶
	 * @return
	 */
	List<Clasz> findAll();
	/**
	 * ͨ��༶id��ѯ�ð༶(�����ð༶�µ�ѧ��)
	 * @param id
	 * @return
	 */
	Clasz findById(int id);
	/**
	 * ͨ��༶��Ʋ�ѯ�༶(֧��ģ���ѯ)
	 * @param name �༶�����
	 * @return
	 */
	List<Clasz> findByName(String name);
	
	
	
	

}
