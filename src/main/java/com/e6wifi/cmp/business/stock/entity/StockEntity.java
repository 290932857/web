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
	private Long productOid;
	
	/**
	 * 供应商ID
	 */
	private Long providerOid;
	
	/**
	 * 仓库ID
	 */
	private Long warehouseOid;
	
	/**
	 * 产品数量
	 */
	private Long num;
	
	/**
	 * 入库日期
	 */
	private Date addDate;
	
	
	//-------------以下字段为虚拟字段
	private String providerName;
	private String productName;
	private String productType;
	private String productOutline;
	private String productPackType;
	private Double productPrice;
	private Double totalPrice;
	private String warehouseName;

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

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Long getProductOid() {
		return productOid;
	}

	public void setProductOid(Long productOid) {
		this.productOid = productOid;
	}

	public Long getProviderOid() {
		return providerOid;
	}

	public void setProviderOid(Long providerOid) {
		this.providerOid = providerOid;
	}

	public Long getWarehouseOid() {
		return warehouseOid;
	}

	public void setWarehouseOid(Long warehouseOid) {
		this.warehouseOid = warehouseOid;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductOutline() {
		return productOutline;
	}

	public void setProductOutline(String productOutline) {
		this.productOutline = productOutline;
	}

	public String getProductPackType() {
		return productPackType;
	}

	public void setProductPackType(String productPackType) {
		this.productPackType = productPackType;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
