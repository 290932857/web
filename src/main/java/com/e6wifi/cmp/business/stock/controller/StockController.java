package com.e6wifi.cmp.business.stock.controller;

import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e6wifi.cmp.business.stock.entity.StockEntity;
import com.e6wifi.cmp.business.stock.service.StockService;
import com.e6wifi.cmp.common.model.Page;
import com.e6wifi.cmp.common.utils.StringUtils;

/**
 * 
 * @author luo
 *
 */
@Controller
public class StockController {

	@Autowired
	private StockService stockService;
	
	@RequestMapping("/stock/getStockList")
	@ResponseBody
	public Page getStockPage(@RequestParam Integer page, @RequestParam Integer limit, StockEntity query) {
		
		Page pager = new Page(page, limit);
		if(query == null) {
			query = new StockEntity();
		}
		if(!StringUtils.isEmpty(query.getProductName())) {
			query.setProductName(URLDecoder.decode(query.getProductName()));
		}
		query.setPager(pager);
		stockService.getStockPage(query);
		return pager;
	}
}
