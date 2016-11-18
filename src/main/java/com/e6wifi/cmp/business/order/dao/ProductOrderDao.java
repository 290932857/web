package com.e6wifi.cmp.business.order.dao;

import java.util.List;

import com.e6wifi.cmp.business.order.entity.ProductOrderEntity;

public interface ProductOrderDao {

	public List<ProductOrderEntity> getProductOrderPage(ProductOrderEntity query);
}
