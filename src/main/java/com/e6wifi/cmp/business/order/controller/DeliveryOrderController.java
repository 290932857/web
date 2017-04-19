package com.e6wifi.cmp.business.order.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e6wifi.cmp.business.order.entity.DeliveryOrderEntity;
import com.e6wifi.cmp.business.order.entity.ProductOrderEntity;
import com.e6wifi.cmp.business.order.service.DeliveryOrderService;
import com.e6wifi.cmp.business.product.entity.ProductEntity;
import com.e6wifi.cmp.business.sys.user.controller.LoginController;
import com.e6wifi.cmp.common.model.Page;
import com.e6wifi.cmp.common.model.ResponseJson;

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
	
	/**
	 * 获取发货单列表
	 * @param page
	 * @param limit
	 * @param query
	 * @return
	 */
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
	
	/**
	 * 保存发货单
	 * @param entity
	 * @param params
	 * @return
	 */
	@RequestMapping(value="/order/saveDeliveryOrder", method=RequestMethod.POST)
	@ResponseBody
	public ResponseJson saveProductOrder(DeliveryOrderEntity entity, @RequestParam String params) {
		ResponseJson json = new ResponseJson();
		//保存订单
		try {
			deliveryOrderService.saveDeliveryOrder(entity, params);
			json.setSuccess(true);
		} catch (ParseException e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		//保存库存表
		return json;
	}
	
	@RequestMapping(value="/order/getDeliveryOrder", method=RequestMethod.POST)
	@ResponseBody
	public ResponseJson getDeliveryOrder(Long oid) throws Exception {
		ResponseJson json = new ResponseJson();
		try {
			json.setSuccess(true);
			DeliveryOrderEntity entity = deliveryOrderService.getDeliveryOrder(oid);
			json.setData(entity);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMessage(e.getMessage());
		}
		return json;
	}
	
	/**
	 * 获取发货单中所有产品
	 * @param oid
	 * @return
	 */
	@RequestMapping(value="/order/getProductForDeliveryOrder")
	@ResponseBody
	public ResponseJson getProductOrderDetail(@RequestParam Long oid) {
		ResponseJson json = new ResponseJson();
		try {
			json.setSuccess(true);
			List<ProductEntity> entity = deliveryOrderService.getDeliveryOrderDts(oid);
			json.setData(entity);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMessage(e.getMessage());
		}
		return json;
	}
}
