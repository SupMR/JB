package com.jzfactory.jd.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jzfactory.jd.bean.Master;
/**
 * 测试Hibernate三种状态
 * @author 阿少
 *
 */
public class TestStutusDAD extends BaseHibernateDAO {

	/**
	 * 测试临时状态到持久状态的转变
	 */
	public void testT2P()
	{
		Master master=new Master();
		//临时态
		master.setName("陈老师");
		master.setSex(1);
		Session session=getSession();
		Transaction trans=session.beginTransaction();
		session.save(master);
		trans.commit();
		//持久状态
		master.setSex(0);
		session.close();
		//游离态
		master.setName("aaaa");
		//临时态
		master.setId(1000);
	}
	/**
	 * 测试临时状态到持久状态后，更改属性提交。
	 */
	public void testT2P2Update()
	{
		Master master=new Master();
		master.setName("王来时");
		master.setSex(0);
		Session session=getSession();
		Transaction trans=session.beginTransaction();
		session.save(master);
		master.setName("小南");
		trans.commit();
		session.close();
		
	}
	/**
	 * 测试持久状态修改后提交
	 */
	public void testP2Update()
	{
		Session session=getSession();
		Master master=(Master)session.get(Master.class, 1);
		Transaction trans=session.getTransaction();
		//此处保存无意义
		session.save(master);
		
		master.setSex(1);
		master.setName("孔圣人");
		trans.commit();
		session.close();
		
	}
	/**
	 * 将持久态转换为游离态后更新提交
	 * clear 或 evict 或 session关闭
	 */
	public void testP2D2Update()
	{
		Session session=getSession();
		//持久化状态
		Master master=(Master)session.get(Master.class, 1);
		//将持久对象转换为游离
		session.evict(master);
		Transaction trans=session.getTransaction();
		//游离对象
		master.setName("李老师");
		trans.commit();
		session.close();
	}
	/**
	 * 将持久态转换为临时态
	 */
	public void testP2T()
	{
		Session session=getSession();
		Master master=(Master)session.get(Master.class, 1);
		Transaction trans=session.getTransaction();
		session.delete(master);
		master.setName("aaaaa");
		session.close();
	}
	/**
	 * 同步持久化对象
	 */
	public void testRefresh()
	{
		Session session=getSession();
		Master master=(Master)session.get(Master.class, 2);
		System.out.println("before:"+master.getName());
		Transaction trans=session.beginTransaction();
		trans.commit();
		session.refresh(master);
		System.out.println("after:"+master.getName());
		session.close();
		
				
	}
	/**
	 * 将游离态转换成持久态
	 */
	public void testD2P()
	{
		Session session=getSession();
		
		Transaction trans=session.beginTransaction();
		Master master=new Master();
		master.setId(3);
		master.setName("栋老师");
        master.setSex(1);
		session.update(master);
		String name=master.getName();
		trans.commit();
	}
	/**
	 * 持久状态修改id (报错)
	 */
	public void testP2EditId()
	{
        Session session=getSession();
		
		Transaction trans=session.beginTransaction();
		Master master=(Master)session.get(Master.class, 2);
		master.setId(100);
		trans.commit();
		session.close();
	}
	/**
	 * 游离态转换为暂时状态
	 */
	public void testD2S()
	{
		  Session session=getSession();
		  Transaction trans=session.beginTransaction();
		  //临时态
		  Master master=new Master();
		  //游离态
		  master.setId(3);
		  session.delete(master);
		  //临时态
		  master.setSex(0);
		  trans.commit();
		  session.close();
	}
	/**
	 * 测试重复的持久化对象
	 */
	public void testDuplicateP()
	{
		  Session session=getSession();
		  Transaction trans=session.beginTransaction();
		  Master master=(Master)session.get(Master.class, 2);
		  //临时态
		  Master master2=new Master();
		  //游离态
		  master2.setId(2);
		  master2.setName("天天");
		  session.update(master2);
		  //持久态
		  System.out.println(master2);
		  trans.commit();
		  session.close();
	}
	/**
	 * 消除重复的持久化对象
	 */
	public void testRemoveDupli()
	{
		  Session session=getSession();
		  Transaction trans=session.beginTransaction();
		  Master master=(Master)session.get(Master.class, 2);
		  //临时态
		  Master master2=new Master();
		  //游离态
		  master2.setId(2);
		  master2.setName("天天");
		  session.merge(master2);
		  //持久态
		  System.out.println(master);
		  System.out.println(master2);
		  trans.commit();
		  session.close();
		  

	}
 
	public static void main(String[] args) {
		
		TestStutusDAD dao=new TestStutusDAD();
		dao.testRemoveDupli();
	}
}
