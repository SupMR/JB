package com.jzfactory.jd.student.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.internet.ParseException;

/**
 * 日期处理工具类
 * @author 阿少
 *
 */
public class DateUtil {
/**
 * 将字符串日期转换为date类型日期
 * @param str
 * @return
 */
	public static Date toDate(String str)
	{
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=sdf.parse(str);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
		
	}
	/**
	 * 将字符串日期转为date类型
	 * @param str
	 * @param formatStr
	 * @return
	 */
	public static Date toDate(String str,String formatStr)
	{
		SimpleDateFormat sdf=new SimpleDateFormat(formatStr);
		Date date=null;
		try {
			date=sdf.parse(str);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
	}
	/**
	 * 将日期类型格式化输出为字符串
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String toString(Date date,String formatStr)
	{

		SimpleDateFormat sdf=new SimpleDateFormat(formatStr);
	    return sdf.format(date);
	}
	public static void main(String[] args) {
		System.out.println(toString(new Date(),"yyyy-MM-dd HH:mm:ss"));
	}
}
