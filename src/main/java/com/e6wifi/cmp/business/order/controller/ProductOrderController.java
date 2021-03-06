package com.e6wifi.cmp.business.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e6wifi.cmp.business.order.entity.ProductOrderEntity;
import com.e6wifi.cmp.business.order.service.ProductOrderService;
import com.e6wifi.cmp.business.product.entity.ProductEntity;
import com.e6wifi.cmp.common.model.Page;
import com.e6wifi.cmp.common.model.ResponseJson;

/**
 * 进货单
 * @author luo
 *
 */
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
	@RequestMapping(value="/order/saveProductOrder", method=RequestMethod.POST)
	@ResponseBody
	public ResponseJson saveProductOrder(ProductOrderEntity entity, @RequestParam String params) {
		ResponseJson json = new ResponseJson();
		//保存订单
		orderService.insertOrder(entity, params);
		//保存库存表
		json.setSuccess(true);
		return json;
	}
	
	/**
	 * 签收订单
	 * @param entity
	 * @return
	 */
	@RequestMapping(value="/order/signProductOrder", method=RequestMethod.POST)
	@ResponseBody
	public ResponseJson signProductOrder(ProductOrderEntity entity) {
		ResponseJson json = new ResponseJson();
		try {
			entity.setState(2);
			long num = orderService.signProductOrder(entity);
			if(num > 0) {
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
				json.setMessage("签收入库失败");
			}
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMessage(e.getMessage());
		}
		return json;
	}
	
	/**
	 * 删除订单
	 * @param params
	 * @return
	 */
	@RequestMapping(value="/order/deleteProductOrder", method=RequestMethod.POST)
	@ResponseBody
	public ResponseJson deleteProductOrder(@RequestParam Long[] params) {
		ResponseJson json = new ResponseJson();
		try {
			long num = orderService.deleteProductOrder(params);
			if(num > 0) {
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
				json.setMessage("删除失败");
			}
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMessage(e.getMessage());
		}
		return json;
	}
	
	/**
	 * 获取单个订单信息
	 * @param oid
	 * @return
	 */
	@RequestMapping(value="/order/getProductOrder")
	@ResponseBody
	public ResponseJson getProductOrder(@RequestParam Long oid) {
		ResponseJson json = new ResponseJson();
		try {
			json.setSuccess(true);
			ProductOrderEntity entity = orderService.getProductOrder(oid);
			json.setData(entity);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMessage(e.getMessage());
		}
		return json;
	}
	
	/**
	 * 获取订单中的所有产品
	 * @param oid
	 * @return
	 */
	@RequestMapping(value="/order/getOrderForProduct")
	@ResponseBody
	public ResponseJson getProductOrderDetail(@RequestParam Long oid) {
		ResponseJson json = new ResponseJson();
		try {
			json.setSuccess(true);
			List<ProductEntity> entity = orderService.getProductByOrderOid(oid);
			json.setData(entity);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMessage(e.getMessage());
		}
		return json;
	}
}
