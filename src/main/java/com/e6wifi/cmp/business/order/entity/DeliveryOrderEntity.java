package com.e6wifi.cmp.business.order.entity;

import java.util.Date;

import com.e6wifi.cmp.common.entity.BaseEntity;

public class DeliveryOrderEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 发送单号
	 */
	private String orderNo;
	
	/**
	 * 客户公司ID
	 */
	private Integer customerOid;
	
	/**
	 * 客户公司名称
	 */
	private String customerName;
	
	/**
	 * 客户公司联系人
	 */
	private String customerLinkman;
	
	/**
	 * 客户公司电话
	 */
	private String customerTelphone;
	
	/**
	 * 客户公司传真
	 */
	private String customerFax;
	
	/**
	 * 出货日期
	 */
	private Date deliveryDate;
	
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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerLinkman() {
		return customerLinkman;
	}

	public void setCustomerLinkman(String customerLinkman) {
		this.customerLinkman = customerLinkman;
	}

	public String getCustomerTelphone() {
		return customerTelphone;
	}

	public void setCustomerTelphone(String customerTelphone) {
		this.customerTelphone = customerTelphone;
	}

	public String getCustomerFax() {
		return customerFax;
	}

	public void setCustomerFax(String customerFax) {
		this.customerFax = customerFax;
	}

	public Integer getCustomerOid() {
		return customerOid;
	}

	public void setCustomerOid(Integer customerOid) {
		this.customerOid = customerOid;
	}
	
}
