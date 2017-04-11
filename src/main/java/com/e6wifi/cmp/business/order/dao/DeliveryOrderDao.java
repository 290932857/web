package com.e6wifi.cmp.business.order.dao;

import java.util.List;

import com.e6wifi.cmp.business.order.entity.DeliveryOrderEntity;

public interface DeliveryOrderDao {

	
	/**
	 * 出货单查询
	 * @param query
	 * @return
	 */
	public List<DeliveryOrderEntity> getDeliveryOrderPage(DeliveryOrderEntity query);
}
