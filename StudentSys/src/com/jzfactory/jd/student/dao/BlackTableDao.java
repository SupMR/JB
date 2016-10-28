package com.jzfactory.jd.student.dao;



import java.util.List;

import com.jzfactory.jd.student.bean.BlackTable;



/**
 * ������ݷ��ʽӿ�
 * @author songwp 2016-09-12
 *
 */
public interface BlackTableDao {
	
	/**
	 * ��Ӻ������
	 * @param bt
	 */
    void insert(BlackTable bt);
    /**
     * ͨ�������޸ĺ������
     * @param bt
     */
    void updateByName(BlackTable bt);
    /**
     * ��ȡȫ���ĺ������
     * @return
     */
    List<BlackTable> findAll();
    /**
     * ��ȡ���л��ں�����û���Ϣ
     * @return
     */
    List<BlackTable> findInTable();
    /**
     * ͨ�����ֲ�ѯ�û�
     * @param name
     * @return
     */
    BlackTable findByName(String name);
    
}
