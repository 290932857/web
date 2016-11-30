package com.e6wifi.cmp.business.order.entity;

import java.util.Date;
import java.util.List;

import com.e6wifi.cmp.business.product.entity.ProductEntity;
import com.e6wifi.cmp.common.entity.BaseEntity;

/**
 * 产品订单
 * @author luo
 *
 */
public class ProductOrderEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 订单号
	 */
	private String orderNo;
	
	/**
	 * 仓库ID
	 */
	private Long warehouseOid;
	
	/**
	 * 供应商ID
	 */
	private Long providerOid;
	
	/**
	 * 供应商名称
	 */
	private String providerName;
	
	/**
	 * 供应商联系人
	 */
	private String providerLinkman;
	
	/**
	 * 供应商电话
	 */
	private String providerTelphone;
	
	/**
	 * 供应商传真
	 */
	private String providerFax;
	
	/**
	 * 下单日期
	 */
	private Date orderDate;
	
	/**
	 * 订单状态
	 */
	private Integer state;
	
	/**
	 * 订单备注
	 */
	private String description;
	
	
	private List<ProductEntity> productEntities;
	
	
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getProviderOid() {
		return providerOid;
	}

	public void setProviderOid(Long providerOid) {
		this.providerOid = providerOid;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
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

	public Long getWarehouseOid() {
		return warehouseOid;
	}

	public void setWarehouseOid(Long warehouseOid) {
		this.warehouseOid = warehouseOid;
	}

	public List<ProductEntity> getProductEntities() {
		return productEntities;
	}

	public void setProductEntities(List<ProductEntity> productEntities) {
		this.productEntities = productEntities;
	}
}
