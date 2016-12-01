package com.e6wifi.cmp.business.warehouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.e6wifi.cmp.business.warehouse.entity.WarehouseEntity;

/**
 * 
 * @author luo
 *
 */
public interface WarehouseDao {

	/**
	 * 获取仓库
	 * @return
	 */
	public List<WarehouseEntity> geWarehouses(@Param("oid") String oid);
}
