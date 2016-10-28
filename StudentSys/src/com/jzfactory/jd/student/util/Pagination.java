package com.jzfactory.jd.student.util;
/**
 * ��ҳ���ݴ�������
 * @author ����
 *
 */
public class Pagination {
	
	private int count;//��������
	private int pageSize;//ÿҳ��������
	private int currPage;//��ǰҳ
	
	public Pagination(int count,int pageSize)
	{
		this.pageSize=pageSize;
		this.count=count;
	}
	/**
	 * ��ȡ��ҳ��
	 * @return
	 */
	public int getPageCount()
	{
		if(count<=pageSize)
			return 1;
		int size=count/pageSize;
		if(count%pageSize!=0)
			size++;
		return size;
		
	}

/**
 * ���õ�ǰ��ҳ��
 * @param page
 */
	public void setCurrPage(int page)
	{
		if(page<=0)
			this.currPage=1;
		if(page>this.getPageCount())
			this.currPage=this.getPageCount();
		else
			this.currPage=page;
	}
	/**
	 * ��ȡ��ʼ���ݵ��±�
	 * @return
	 */
	public int getStartIndex()
	{
		return (currPage-1)*pageSize+1;
	}
	/**
	 * ��ȡ���ݽ����±�
	 * @return
	 */
	public int getStopIndex()
	{
		int cnt=currPage*pageSize;
		if(cnt>count)
			return count;
		else
			return cnt;
		
	}
}
