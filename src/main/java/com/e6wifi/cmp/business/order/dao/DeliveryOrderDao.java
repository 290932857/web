package com.e6wifi.cmp.business.order.dao;

import java.util.List;

import com.e6wifi.cmp.business.order.entity.DeliveryOrderDtEntity;
import com.e6wifi.cmp.business.order.entity.DeliveryOrderEntity;

public interface DeliveryOrderDao {

	
	/**
	 * 出货单查询
	 * @param query
	 * @return
	 */
	public List<DeliveryOrderEntity> getDeliveryOrderPage(DeliveryOrderEntity query);
	
	/**
	 * 保存发货单
	 * @param entity
	 * @return
	 */
	public Long insertOrder(DeliveryOrderEntity entity);
	
	/**
	 * 保存发货单详情
	 * @param deliveryOrderDtEntities
	 * @return
	 */
	public Long insertOrderDt(List<DeliveryOrderDtEntity> deliveryOrderDtEntities);
}
