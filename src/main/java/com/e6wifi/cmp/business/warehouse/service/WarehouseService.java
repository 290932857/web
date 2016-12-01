package com.e6wifi.cmp.business.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.e6wifi.cmp.business.warehouse.dao.WarehouseDao;
import com.e6wifi.cmp.business.warehouse.entity.WarehouseEntity;

/**
 * 
 * @author luo
 *
 */
@Component
public class WarehouseService {

	@Autowired
	private WarehouseDao warehouseDao;
	
	/**
	 * 查询仓库信息
	 * @param oid
	 * @return
	 * @throws Exception
	 */
	public List<WarehouseEntity> geWarehouses(String oid) throws Exception {
		return warehouseDao.geWarehouses(oid);
	}
}
