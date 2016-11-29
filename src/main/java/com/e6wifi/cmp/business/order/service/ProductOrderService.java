package com.e6wifi.cmp.business.order.service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.e6wifi.cmp.business.order.dao.ProductOrderDao;
import com.e6wifi.cmp.business.order.entity.ProductOrderEntity;
import com.e6wifi.cmp.business.stock.entity.StockEntity;
import com.e6wifi.cmp.business.stock.service.StockService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 产品订单Service
 * @author luo
 *
 */
@Component
public class ProductOrderService {
	
	@Autowired
	private ProductOrderDao productOrderDao;
	
	@Autowired
	private StockService stockService;

	public void getProductOrderPage (ProductOrderEntity query) {
		List<ProductOrderEntity> list = productOrderDao.getProductOrderPage(query);
		if(list != null && !list.isEmpty()) {
			query.getPager().setList(list);
		}
	}
	
	/**
	 * 保存订单
	 * @param entity 订单实体
	 * @param params 订单产品详细
	 * @return
	 */
	public Long insertOrder(ProductOrderEntity entity, String params) {
		if(entity != null) {
			//订单保存
			long num = productOrderDao.insertOrder(entity);
			if(num <= 0 && entity.getOid() == null) {
				return null;
			}
			Gson gson = new Gson();
			Type type = new TypeToken<List<StockEntity>>(){}.getType();
			List<StockEntity> stockEntities = gson.fromJson(params, type);
			if(stockEntities != null && !stockEntities.isEmpty()) {
				for(StockEntity stockEntity : stockEntities) {
					stockEntity.setOrderOid(entity.getOid());
					stockEntity.setAddDate(new Date());
				}
			}
			stockService.insertOrUpdateStock(stockEntities);
			return entity.getOid();
		}
		return null;
	}
	
	/**
	 * 删除订单
	 * @return
	 */
	public Long deleteProductOrder(Long[] oids) throws Exception {
		if(oids == null || oids.length == 0) {
			throw new Exception("请选中需要删除的订单再删除");
		}
		
		for(Long oid : oids) {
			ProductOrderEntity dbEntity = productOrderDao.getProductOrder(oid);
			
			//已签收订单无法删除
			if(dbEntity.getState() != null && (dbEntity.getState() == 2 || dbEntity.getState() == 3)) {
				throw new Exception("已签收或过期订单无法删除");
			}
			
			//删除订单
			try {
				stockService.deleteByOrderOid(oid);
				productOrderDao.deleteOrder(oid);
			} catch (Exception e) {
				throw new Exception("删除订单失败");
			}
		}
		return 1l;
	}
	
	/**
	 * 更新订单状态
	 * @return
	 * @throws Exception
	 */
	public Long updateProductOrderState(ProductOrderEntity orderEntity) throws Exception {
		if(orderEntity == null) {
			throw new Exception("订单信息为空");
		}
		
		//判断订单是否已经签收
		ProductOrderEntity dbEntity = productOrderDao.getProductOrder(orderEntity.getOid());
		
		//已签收订单无法删除
		if(dbEntity.getState() == 2 || dbEntity.getState() == 3) {
			throw new Exception("该订单已经签收或者过期无法再次签收");
		}
		
		long num = productOrderDao.updateOrder(orderEntity);
		if(num > 0) {
			return num;
		}
		throw new Exception("更新订单状态失败");
	}
}
