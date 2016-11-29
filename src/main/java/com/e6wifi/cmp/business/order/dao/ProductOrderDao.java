package com.e6wifi.cmp.business.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.e6wifi.cmp.business.order.entity.ProductOrderEntity;

public interface ProductOrderDao {

	/**
	 * 订单查询
	 * @param query
	 * @return
	 */
	public List<ProductOrderEntity> getProductOrderPage(ProductOrderEntity query);
	
	/**
	 * 查询订单
	 * @param oid
	 * @return
	 */
	public ProductOrderEntity getProductOrder(@Param("oid") long oid);
	
	/**
	 * 保存订单
	 * @param entity
	 * @return
	 */
	public Long insertOrder(ProductOrderEntity entity);
	
	/**
	 * 删除订单
	 * @param oid
	 * @return
	 */
	public Long deleteOrder(@Param("oid") Long oid);
	
	/**
	 * 更新订单
	 * @param orderEntity
	 * @return
	 */
	public Long updateOrder(ProductOrderEntity orderEntity);
}
