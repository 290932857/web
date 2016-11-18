package com.e6wifi.cmp.business.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e6wifi.cmp.business.order.entity.ProductOrderEntity;
import com.e6wifi.cmp.business.order.service.ProductOrderService;
import com.e6wifi.cmp.common.model.Page;

@Controller
public class ProductOrderController {
	
	@Autowired
	private ProductOrderService orderService;

	/**
	 * 获取订单
	 * @param page
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping("/order/productOrderList")
	@ResponseBody
	public Page getList(@RequestParam Integer page, @RequestParam Integer limit, ProductOrderEntity query) {
		Page pager = new Page(page, limit);
		if(query == null) {
			query = new ProductOrderEntity();
		}
		query.setPager(pager);
		orderService.getProductOrderPage(query);
		return pager;
	}
	
	/**
	 * 保存订单
	 */
	@RequestMapping("/order/saveProductOrder")
	@ResponseBody
	public void saveProductOrder() {
		
	}
}
