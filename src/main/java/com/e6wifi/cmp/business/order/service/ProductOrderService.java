package com.e6wifi.cmp.business.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.e6wifi.cmp.business.order.dao.ProductOrderDao;
import com.e6wifi.cmp.business.order.entity.ProductOrderEntity;

@Component
public class ProductOrderService {
	
	@Autowired
	private ProductOrderDao productOrderDao;

	public void getProductOrderPage (ProductOrderEntity query) {
		List<ProductOrderEntity> list = productOrderDao.getProductOrderPage(query);
		if(list != null && !list.isEmpty()) {
			query.getPager().setList(list);
		}
	}
}
