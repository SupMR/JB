package com.jzfactory.jd.student.bean;

import java.util.Date;

import com.jzfactory.jd.student.util.DateUtil;



/**
 * 黑名单用户的实体类
 * @author 阿少
 *
 */
public class BlackTable {

    private int id;//�û�id
	
    private String username;
    
    private Date includeDate;
    
	private int removed;

	public String getFormatDate(){
		return DateUtil.toString(includeDate,"yyyy-MM-dd HH:mm:ss");
	}
	
	public BlackTable(int id, String username, Date includeDate, int removed) {
		super();
		this.id = id;
		this.username = username;
		this.includeDate = includeDate;
		this.removed = removed;
	}
	
	public BlackTable(){
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getIncludeDate() {
		return includeDate;
	}

	public void setIncludeDate(Date includeDate) {
		this.includeDate = includeDate;
	}

	public int getRemoved() {
		return removed;
	}

	public void setRemoved(int removed) {
		this.removed = removed;
	}
	
	
	
	
	
	
	
}
