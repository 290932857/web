package com.e6wifi.cmp.common.utils;

import java.util.Random;

/**
 * 字符串处理类
 *
 * @author luo
 * @date 2016年1月7日
 *
 */
public class StringUtils {

	/**
	 * mac地址处理掉所有分隔符
	 * @param mac
	 * @return
	 */
	public static String getMacNoSpecChar(String mac) {
		if(isEmpty(mac)) {
			return null;
		}
		String regex="[^a-zA-Z0-9]";
		return mac.replaceAll(regex, "").trim().toLowerCase();
	}
	
	/**
	 * 获取随机数
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getSixRadam(final int min, final int max) {
		Random rand = new Random(); 
		int tmp = Math.abs(rand.nextInt());
	    return tmp % (max - min + 1) + min;
	}
	
	/**
	 * 将mac地址转换为以冒号分割小写格式
	 * @param sourceMac
	 * @return
	 */
	public static String macToLocation(String sourceMac){
		
		if(isEmpty(sourceMac))
			return null;
		String clear_mac=sourceMac.replace(":", "").replace("-", "").trim();
		if(clear_mac.length()!=12)
			return null;
		StringBuilder tar_mac=new StringBuilder();
		for (int i=0;i<clear_mac.length();i+=2) {
			if(tar_mac.toString().length()>0)
				tar_mac.append(":");
			tar_mac.append(clear_mac.substring(i,i+2));
		}
		return tar_mac.toString().toLowerCase();
	}
	
	/**
	 *	去掉mac地址分隔符并改为小写
	 * @param sourceMac
	 * @return
	 */
	public static String macToLower(String sourceMac){
		if(isEmpty(sourceMac))
			return null;
		return sourceMac.replace(":", "").replace("-", "").trim().toLowerCase();
	}
	
	public static String macToPb(String sourceMac) {
		if(isEmpty(sourceMac))
			return "";
		return sourceMac.replace(":", "-").trim().toLowerCase();
	}
	
	public static String getValue(String value){
		if(value == null || value.equals("null") || value.trim().length() == 0) {
			return "";
		}
		return value.trim();
	}
	
	public static boolean isEmpty(String str) {
		return (str == null || "".equals(str.trim()) || "null".equals(str));
	}
	
	public static boolean isEmpty(Object obj) {
		return (obj == null || "".equals(obj));
	}
	
	public static void main(String[] args) {
		String mac = "00:14:51:23:68:9a";
		System.out.println(getMacNoSpecChar(mac));
		
		String mac1 = "00-14-51-23-68-9a";
		System.out.println(getMacNoSpecChar(mac1));
	}
	
}
