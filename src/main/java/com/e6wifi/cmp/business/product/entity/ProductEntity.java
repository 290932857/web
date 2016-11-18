package com.e6wifi.cmp.business.product.entity;

import java.util.Date;

import com.e6wifi.cmp.common.entity.BaseEntity;

/**
 * 产品
 * @author luo
 *
 */
public class ProductEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 供应商ID
	 */
	private Long providerOid;
	
	/**
	 * 产品名称
	 */
	private String pName;
	
	/**
	 * 产品型号
	 */
	private Integer type;
	
	/**
	 * 产品外形
	 */
	private Integer outline;
	
	/**
	 * 包装外形
	 */
	private Integer packType;
	
	/**
	 * 备注
	 */
	private String description;
	
	/**
	 * 单位
	 */
	private Integer unitType;
	
	/**
	 * 单价
	 */
	private Double price;
	
	/**
	 * 入库日期
	 */
	private Date addDate;
	
	/**
	 * 数量
	 */
	private Integer num = 0;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Long getProviderOid() {
		return providerOid;
	}

	public void setProviderOid(Long providerOid) {
		this.providerOid = providerOid;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getOutline() {
		return outline;
	}

	public void setOutline(Integer outline) {
		this.outline = outline;
	}

	public Integer getPackType() {
		return packType;
	}

	public void setPackType(Integer packType) {
		this.packType = packType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUnitType() {
		return unitType;
	}

	public void setUnitType(Integer unitType) {
		this.unitType = unitType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
}
