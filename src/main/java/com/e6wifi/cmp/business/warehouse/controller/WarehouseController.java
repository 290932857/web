package com.e6wifi.cmp.business.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e6wifi.cmp.business.warehouse.entity.WarehouseEntity;
import com.e6wifi.cmp.business.warehouse.service.WarehouseService;
import com.e6wifi.cmp.common.model.ResponseJson;

/**
 * 
 * @author luo
 *
 */
@Controller
public class WarehouseController {

	@Autowired
	private WarehouseService warehouseService;
	
	/**
	 * 查询所有仓库信息仓库信息
	 * @return
	 */
	@RequestMapping(value="/warehouse/getWarehouse")
	@ResponseBody
	public ResponseJson getWarehouse() {
		ResponseJson json = new ResponseJson();
		try {
			List<WarehouseEntity> entities = warehouseService.geWarehouses(null);
			json.setData(entities);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMessage(e.getMessage());
		}
		return json;
	}
}
