package com.bwf.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 对用户密码进行MD5加密
 * @author admin
 *
 */
public class MD5Encoding {
	static MessageDigest md5;
	static{
	 try {
		md5 = MessageDigest.getInstance("MD5");
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}
	
	public static String encodingMd5(String str){
		char[] chars = str.toCharArray();
		byte[] bytes = new byte[chars.length];
		for(int i=0;i<chars.length;i++){
			bytes[i] = (byte)chars[i];
		}
		
		byte[] md5byte = md5.digest(bytes);
		
		StringBuffer sbf = new StringBuffer();
		for(int i=0;i<md5byte.length;i++){
			int val = ((int)md5byte[i])&0xff;
			if(val<16){
				sbf.append("0");
			}
			sbf.append(Integer.toHexString(val));
		}
		
		return sbf.toString().toUpperCase();
	}
}
