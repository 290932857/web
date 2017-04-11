package com.e6wifi.cmp.business.order.entity;

import java.util.Date;

import com.e6wifi.cmp.common.entity.BaseEntity;

public class DeliveryOrderEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 订单号
	 */
	private String orderNo;
	
	/**
	 * 客户公司
	 */
	private Long customerOid;
	
	/**
	 * 客户公司名称
	 */
	private String customerName;
	
	/**
	 * 客户公司联系人
	 */
	private String providerLinkman;
	
	/**
	 * 客户公司电话
	 */
	private String providerTelphone;
	
	/**
	 * 客户公司传真
	 */
	private String providerFax;
	
	/**
	 * 下单日期
	 */
	private Date orderDate;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getCustomerOid() {
		return customerOid;
	}

	public void setCustomerOid(Long customerOid) {
		this.customerOid = customerOid;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProviderLinkman() {
		return providerLinkman;
	}

	public void setProviderLinkman(String providerLinkman) {
		this.providerLinkman = providerLinkman;
	}

	public String getProviderTelphone() {
		return providerTelphone;
	}

	public void setProviderTelphone(String providerTelphone) {
		this.providerTelphone = providerTelphone;
	}

	public String getProviderFax() {
		return providerFax;
	}

	public void setProviderFax(String providerFax) {
		this.providerFax = providerFax;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
}
