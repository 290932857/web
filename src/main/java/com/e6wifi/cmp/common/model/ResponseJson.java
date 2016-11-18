package com.e6wifi.cmp.common.model;

import java.util.List;

/**
 * 返回的json对象
 * 
 * @author Lijiacheng
 */
public class ResponseJson {

	private boolean success;
	private String message;

	private List<?> objs;

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

	public List<?> getObjs() {
		return objs;
	}

	public void setObjs(List<?> objs) {
		this.objs = objs;
	}

}
