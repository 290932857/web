package com.e6wifi.cmp.common.entity;

import java.io.Serializable;
import java.util.Date;

import com.e6wifi.cmp.common.model.Page;
import com.google.gson.Gson;

public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *  唯一标识OID
	 */
	private Long oid;
	
	/**
	 * 添加时间
	 */
	private Date createTime;
	
	/**
	 * 添加人
	 */
	private Long createUserId;
	
	private Page pager;
	
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Page getPager() {
		return pager;
	}

	public void setPager(Page pager) {
		this.pager = pager;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
