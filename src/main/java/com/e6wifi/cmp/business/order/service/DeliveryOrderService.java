package com.e6wifi.cmp.business.order.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.e6wifi.cmp.business.order.dao.DeliveryOrderDao;
import com.e6wifi.cmp.business.order.entity.DeliveryOrderDtEntity;
import com.e6wifi.cmp.business.order.entity.DeliveryOrderEntity;
import com.e6wifi.cmp.business.stock.entity.StockEntity;
import com.e6wifi.cmp.business.stock.service.StockService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class DeliveryOrderService {

	@Autowired
	private DeliveryOrderDao deliveryOrderDao;
	
	@Autowired
	private StockService stockService;
	
	public void getDeliveryOrderPage (DeliveryOrderEntity query) {
		List<DeliveryOrderEntity> list = deliveryOrderDao.getDeliveryOrderPage(query);
		if(list != null && !list.isEmpty()) {
			query.getPager().setList(list);
		}
	}
	
	/**
	 * 保存发货单
	 * @param entity
	 * @param params
	 * @return
	 */
	public Long saveDeliveryOrder(DeliveryOrderEntity entity, String params) {
		if(entity != null) {
			//保存发货单以及详情信息
			long num = deliveryOrderDao.insertOrder(entity);
			if(num <= 0 && entity.getOid() == null) {
				return null;
			}
			
			List<StockEntity> entities = new ArrayList<StockEntity>();
			
			Gson gson = new Gson();
			Type type = new TypeToken<List<DeliveryOrderDtEntity>>(){}.getType();
			List<DeliveryOrderDtEntity> orderDtEntities = gson.fromJson(params, type);
			if(orderDtEntities != null && !orderDtEntities.isEmpty()) {
				for(DeliveryOrderDtEntity dtEntity : orderDtEntities) {
					//获取原来的订单OID
					Long orderOid = dtEntity.getOrderOid();
					
					//设置发送单ID
					dtEntity.setOrderOid(entity.getOid());
					
					//创建库存更新对象
					StockEntity stockEntity = new StockEntity();
					stockEntity.setNum(dtEntity.getNum());
					stockEntity.setProductOid(dtEntity.getProductOid());
					stockEntity.setOrderOid(orderOid);
					entities.add(stockEntity);
				}
			}
			deliveryOrderDao.insertOrderDt(orderDtEntities);
			
			//更新库存
			stockService.updateStocks(entities);
			
			//返回结果
			return entity.getOid();
		}
		return null;
	}
}
