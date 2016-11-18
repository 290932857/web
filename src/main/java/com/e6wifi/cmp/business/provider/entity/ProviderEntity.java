package com.e6wifi.cmp.business.provider.entity;

import com.e6wifi.cmp.common.entity.BaseEntity;

public class ProviderEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 供应商名称
	 */
	private String name;
	
	/**
	 * 供应商地址
	 */
	private String address;
	
	/**
	 * 联系人
	 */
	private String linkman;
	
	/**
	 * 联系人电话
	 */
	private String linkmanTelphone;
	
	/**
	 * 传真
	 */
	private String fax;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkmanTelphone() {
		return linkmanTelphone;
	}

	public void setLinkmanTelphone(String linkmanTelphone) {
		this.linkmanTelphone = linkmanTelphone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
}
