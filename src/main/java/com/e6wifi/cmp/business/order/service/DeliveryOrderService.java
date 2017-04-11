package com.e6wifi.cmp.business.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.e6wifi.cmp.business.order.dao.DeliveryOrderDao;
import com.e6wifi.cmp.business.order.entity.DeliveryOrderEntity;

@Component
public class DeliveryOrderService {

	@Autowired
	private DeliveryOrderDao deliveryOrderDao;
	
	public void getDeliveryOrderPage (DeliveryOrderEntity query) {
		List<DeliveryOrderEntity> list = deliveryOrderDao.getDeliveryOrderPage(query);
		if(list != null && !list.isEmpty()) {
			query.getPager().setList(list);
		}
	}
}
