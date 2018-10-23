package com.bwf.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取当前时间
 * @author Administrator
 *
 */
public class DateTime {
	
	public static String returnDateTime() {
		Date day=new Date();    

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		return df.format(day);
		
	}
}
