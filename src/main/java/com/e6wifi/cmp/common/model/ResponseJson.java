package com.e6wifi.cmp.common.model;

/**
 * 返回的json对象
 * 
 * @author luo
 */
public class ResponseJson {

	private boolean success;
	private String message;

	private Object data;

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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
