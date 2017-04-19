package com.e6wifi.cmp.business.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.e6wifi.cmp.business.product.dao.ProductDao;
import com.e6wifi.cmp.business.product.entity.ProductEntity;

/**
 * 
 * @author luo
 *
 */
@Component
public class ProductService {
	
	@Autowired
	private ProductDao productDao;

	public List<ProductEntity> getProductByOrderOid(Long orderOid) throws Exception {
		return productDao.getProductByOrderOid(orderOid);
	}
	
	public List<ProductEntity> getProductList() throws Exception{
		return productDao.getProductList();
	}
}
