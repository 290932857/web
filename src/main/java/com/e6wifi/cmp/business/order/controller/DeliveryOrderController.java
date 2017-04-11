package com.e6wifi.cmp.business.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e6wifi.cmp.business.order.entity.DeliveryOrderEntity;
import com.e6wifi.cmp.business.order.service.DeliveryOrderService;
import com.e6wifi.cmp.business.sys.user.controller.LoginController;
import com.e6wifi.cmp.common.model.Page;

/**
 * 出货单
 * @author luo
 *
 */
@Controller
public class DeliveryOrderController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private DeliveryOrderService deliveryOrderService;
	
	@RequestMapping("/order/deliveryOrderList")
	@ResponseBody
	public Page getList(@RequestParam Integer page, @RequestParam Integer limit, DeliveryOrderEntity query) {
		Page pager = new Page(page, limit);
		if(query == null) {
			query = new DeliveryOrderEntity();
		}
		query.setPager(pager);
		deliveryOrderService.getDeliveryOrderPage(query);
		return pager;
	}
}
