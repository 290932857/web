package com.e6wifi.cmp.common.utils;

/**
 * 数据字典
 * 
 * @author Lijiacheng
 */
public class Constants {

	/**
	 * 用户Session
	 */
	public final static String USER_SESSION = "user_session";

	/**
	 * 短信的request_app
	 */
	public final static String REQUEST_APP = "custom_message";

	/**
	 * 短信的request_type
	 */
	public final static String REQUEST_TYPE = "custom_send_message";

	/**
	 * 发送短信的URL,测试环境
	 */
	public final static String URL = "http://111.13.47.150:20002/sms_api/sendMessage.html";
	
	/**
	 * 发送短信的URL,正式环境
	 */
	//public final static String URL = "http://sms.16wifi.com:20001/sms_api/sendMessage.html";

}
