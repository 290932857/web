package com.e6wifi.cmp.business.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.e6wifi.cmp.business.stock.dao.StockDao;
import com.e6wifi.cmp.business.stock.entity.StockEntity;

/**
 * 库存Service
 * @author luo
 *
 */
@Component
public class StockService {
	
	@Autowired
	private StockDao stockDao;
	
	/**
	 *  库存查询
	 * @param query
	 */
	public void getStockPage (StockEntity query) {
		List<StockEntity> list = stockDao.getStockPage(query);
		if(list != null && !list.isEmpty()) {
			query.getPager().setList(list);
		}
	}

	/**
	 * 库存更新
	 * @return
	 */
	public Long insertStocks(List<StockEntity> stockEntities) {
		long num = stockDao.insertStocks(stockEntities);
		if(num > 0) {
			return num;
		}
		return 0l;
	}
	
	/**
	 * 删除
	 * @param orderOid
	 * @return
	 */
	public Long deleteByOrderOid(Long orderOid) {
		return stockDao.deleteStockByOrderOid(orderOid);
	}
}
