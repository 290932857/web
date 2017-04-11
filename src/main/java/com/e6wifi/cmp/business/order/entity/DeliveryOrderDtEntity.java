package com.e6wifi.cmp.business.order.entity;

import com.e6wifi.cmp.common.entity.BaseEntity;

/**
 * 库存表
 * @author luo
 *
 */
public class DeliveryOrderDtEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 订单ID
	 */
	private Long orderOid;
	
	/**
	 * 产品ID
	 */
	private Long productOid;
	
	/**
	 * 产品数量
	 */
	private Long num;
	

	public Long getOrderOid() {
		return orderOid;
	}

	public void setOrderOid(Long orderOid) {
		this.orderOid = orderOid;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getProductOid() {
		return productOid;
	}

	public void setProductOid(Long productOid) {
		this.productOid = productOid;
	}
}
