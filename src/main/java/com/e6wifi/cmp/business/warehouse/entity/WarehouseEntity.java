package com.e6wifi.cmp.business.warehouse.entity;

import com.e6wifi.cmp.common.entity.BaseEntity;

/**
 * 仓库
 * @author luo
 *
 */
public class WarehouseEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 仓库名称
	 */
	private String name;
	
	/**
	 * 仓库地址
	 */
	private String address;
	
	/**
	 * 仓库联系人
	 */
	private String linkmanName;
	
	/**
	 * 仓库电话
	 */
	private String linkmanTelephone;

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

	public String getLinkmanName() {
		return linkmanName;
	}

	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}

	public String getLinkmanTelephone() {
		return linkmanTelephone;
	}

	public void setLinkmanTelephone(String linkmanTelephone) {
		this.linkmanTelephone = linkmanTelephone;
	}
	
}
