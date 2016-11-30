package com.e6wifi.cmp.business.stock.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.e6wifi.cmp.business.stock.entity.StockEntity;

public interface StockDao {

	/**
	 * 
	 * @param stockEntities
	 * @return
	 */
	public Long insertOrUpdateStock(List<StockEntity> stockEntities);
	
	/**
	 * 通过订单号删除的订单详细数据
	 * @param orderOid
	 * @return
	 */
	public Long deleteStockByOrderOid(@Param("orderOid")Long orderOid);
}
