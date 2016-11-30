package com.e6wifi.cmp.common.model;

/**
 * 返回的json对象
 * 
 * @author luo
 */
public class ResponseJson {

	private boolean success;
	private String message;

	private Object obj;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
