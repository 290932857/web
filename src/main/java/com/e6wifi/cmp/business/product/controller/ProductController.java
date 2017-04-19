package com.e6wifi.cmp.business.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e6wifi.cmp.business.product.entity.ProductEntity;
import com.e6wifi.cmp.business.product.service.ProductService;
import com.e6wifi.cmp.common.model.ResponseJson;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/product/productList")
	@ResponseBody
	public ResponseJson getProductList() {
		ResponseJson json = new ResponseJson();
		try {
			List<ProductEntity> entities = productService.getProductList();
			json.setSuccess(true);
			json.setData(entities);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMessage(e.getMessage());
		}
		return json;
	}
}
