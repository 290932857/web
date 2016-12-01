package com.e6wifi.cmp.business.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.e6wifi.cmp.business.order.entity.ProductOrderDtEntity;
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
	 * 查询当前订单详细
	 * @param order_oid
	 * @return
	 */
	public List<ProductOrderDtEntity> getProductOrderDts(@Param("orderOid") long orderOid);
	
	/**
	 * 保存订单
	 * @param entity
	 * @return
	 */
	public Long insertOrder(ProductOrderEntity entity);
	
	/**
	 * 添加订单详情
	 * @param stockEntities
	 * @return
	 */
	public Long insertOrderDt(List<ProductOrderDtEntity> stockEntities);
	
	/**
	 * 删除订单
	 * @param oid
	 * @return
	 */
	public Long deleteOrder(@Param("oid") Long oid);
	
	
	/**
	 * 删除订单详情
	 * @param oid
	 * @return
	 */
	public Long deleteOrderDtByOrderOid(@Param("orderOid") Long orderOid);
	
	/**
	 * 更新订单
	 * @param orderEntity
	 * @return
	 */
	public Long updateOrder(ProductOrderEntity orderEntity);
}
