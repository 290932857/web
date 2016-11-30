package com.e6wifi.cmp.business.stock.entity;

import java.util.Date;

import com.e6wifi.cmp.common.entity.BaseEntity;

/**
 * 库存表
 * @author luo
 *
 */
public class StockEntity extends BaseEntity {

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
	private Long pOid;
	
	/**
	 * 产品数量
	 */
	private Long num;
	
	/**
	 * 入库日期
	 */
	private Date addDate;

	public Long getOrderOid() {
		return orderOid;
	}

	public void setOrderOid(Long orderOid) {
		this.orderOid = orderOid;
	}

	public Long getpOid() {
		return pOid;
	}

	public void setpOid(Long pOid) {
		this.pOid = pOid;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

}
