package com.e6wifi.cmp.business.provider.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.e6wifi.cmp.business.product.entity.ProductEntity;
import com.e6wifi.cmp.business.provider.dao.ProviderDao;
import com.e6wifi.cmp.business.provider.entity.ProviderEntity;

@Component
public class ProviderService {

	@Autowired
	private ProviderDao providerDao;

	public void getProviderPage (ProviderEntity query) {
		List<ProviderEntity> list = providerDao.getProviderPage(query);
		if(list != null && !list.isEmpty()) {
			query.getPager().setList(list);
		}
	}
	
	public void getProviderProductPage(ProviderEntity query) {
		List<ProductEntity> list = providerDao.getProviderProductPage(query);
		if(list != null && !list.isEmpty()) {
			query.getPager().setList(list);
		}
	}
	
	public List<ProductEntity> getProviderProductList(ProviderEntity query) {
		List<ProductEntity> list = providerDao.getProviderProductList(query);
		if(list != null && !list.isEmpty()) {
			return list;
		}
		return new ArrayList<ProductEntity>();
	}
	
	public List<ProductEntity> getProviderList(ProviderEntity query) {
		List<ProductEntity> list = providerDao.getProviderList(query);
		if(list != null && !list.isEmpty()) {
			return list;
		}
		return new ArrayList<ProductEntity>();
	}
}
