package com.e6wifi.cmp.business.stock.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.e6wifi.cmp.business.stock.entity.StockEntity;

/**
 * 
 * @author luo
 *
 */
public interface StockDao {
	
	
	public List<StockEntity> getStockPage(StockEntity query);

	/**
	 * 添加库存
	 * @param stockEntities
	 * @return
	 */
	public Long insertStocks(List<StockEntity> stockEntities);
	
	/**
	 * 通过订单号删除的库存
	 * @param orderOid
	 * @return
	 */
	public Long deleteStockByOrderOid(@Param("orderOid")Long orderOid);
	
	/**
	 * 更新库存
	 * @param entities
	 * @return
	 */
	public Long updateStocks(List<StockEntity> entities);
}
