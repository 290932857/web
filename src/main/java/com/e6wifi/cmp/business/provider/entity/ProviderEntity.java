package com.e6wifi.cmp.business.provider.entity;

import com.e6wifi.cmp.common.entity.BaseEntity;

/**
 * 供应商/客户
 * @author luo
 *
 */
public class ProviderEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 地址
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
	
	/**
	 * 供应商/客户类型区分  0 供应商  1客户
	 */
	private Integer type;

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
