package com.e6wifi.cmp.business.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.e6wifi.cmp.business.product.entity.ProductEntity;

/**
 * 产品dao
 * @author luo
 *
 */
public interface ProductDao {

	/**
	 * 通过订单ID查询产品信息
	 * @param orderOid
	 * @return
	 */
	public List<ProductEntity> getProductByOrderOid(@Param("orderOid") Long orderOid);
	
	/**
	 * 通过发货单号获取产品信息
	 * @param orderOid
	 * @return
	 */
	public List<ProductEntity> getProductByDeliveryOrderOid(@Param("orderOid") Long orderOid);
	
	/**
	 * 获取所有物料信息
	 * @return
	 */
	public List<ProductEntity> getProductList();
}
