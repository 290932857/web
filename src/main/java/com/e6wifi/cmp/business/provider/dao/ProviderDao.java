package com.e6wifi.cmp.business.provider.dao;

import java.util.List;

import com.e6wifi.cmp.business.product.entity.ProductEntity;
import com.e6wifi.cmp.business.provider.entity.ProviderEntity;

public interface ProviderDao {

	public List<ProviderEntity> getProviderPage(ProviderEntity query);
	
	public List<ProductEntity> getProviderProductPage(ProviderEntity query);
	
	public List<ProductEntity> getProviderProductList(ProviderEntity query);
}
