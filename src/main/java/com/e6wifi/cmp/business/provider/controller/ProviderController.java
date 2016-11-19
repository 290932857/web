package com.e6wifi.cmp.business.provider.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e6wifi.cmp.business.product.entity.ProductEntity;
import com.e6wifi.cmp.business.provider.entity.ProviderEntity;
import com.e6wifi.cmp.business.provider.service.ProviderService;
import com.e6wifi.cmp.common.model.Page;

@Controller
public class ProviderController {
	
	@Autowired
	private ProviderService providerService;

	/**
	 * 供应商
	 * @param page
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping("/provider/getProviderPage")
	@ResponseBody
	public Page getList(@RequestParam Integer page, @RequestParam Integer limit, ProviderEntity query) {
		Page pager = new Page(page, limit);
		if(query == null) {
			query = new ProviderEntity();
		}
		query.setPager(pager);
		providerService.getProviderPage(query);
		return pager;
	}
	
	/**
	 * 供应商所有的产品信息
	 * @param page
	 * @param limit
	 * @param query
	 * @return
	 */
	@RequestMapping("/provider/getProviderProductPage")
	@ResponseBody
	public Page getProductPage(@RequestParam Integer page, @RequestParam Integer limit, ProviderEntity query) {
		Page pager = new Page(page, limit);
		if(query == null) {
			query = new ProviderEntity();
		}
		query.setPager(pager);
		if(query.getOid() != null) {
			providerService.getProviderProductPage(query);
		}
		return pager;
	}
	
	@RequestMapping("/provider/getProviderProductList")
	@ResponseBody
	public List<ProductEntity> getProductList(ProviderEntity query) {
		if(query == null) {
			query = new ProviderEntity();
		}
		if(query.getOid() != null) {
			return providerService.getProviderProductList(query);
		}
		return new ArrayList<ProductEntity>();
	}
}