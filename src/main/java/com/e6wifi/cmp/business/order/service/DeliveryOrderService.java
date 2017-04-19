package com.e6wifi.cmp.business.order.service;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.e6wifi.cmp.business.order.dao.DeliveryOrderDao;
import com.e6wifi.cmp.business.order.entity.DeliveryOrderDtEntity;
import com.e6wifi.cmp.business.order.entity.DeliveryOrderEntity;
import com.e6wifi.cmp.business.order.entity.ProductOrderEntity;
import com.e6wifi.cmp.business.product.entity.ProductEntity;
import com.e6wifi.cmp.business.product.service.ProductService;
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
	
	@Autowired
	private ProductService productService;
	
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
	 * @throws ParseException 
	 */
	public Long saveDeliveryOrder(DeliveryOrderEntity entity, String params) throws ParseException {
		if(entity != null) {
			//保存发货单以及详情信息
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			entity.setDeliveryDate(sdf.parse(entity.getOrderDateStr()));
			long num = deliveryOrderDao.insertOrder(entity);
			if(num <= 0 && entity.getOid() == null) {
				return null;
			}
			
			List<StockEntity> entities = new ArrayList<StockEntity>();
			
			Gson gson = new Gson();
			Type type = new TypeToken<List<DeliveryOrderDtEntity>>(){}.getType();
			List<DeliveryOrderDtEntity> orderDtEntities = gson.fromJson(params, type);
			if(orderDtEntities != null && !orderDtEntities.isEmpty()) {
				Iterator<DeliveryOrderDtEntity> iterator = orderDtEntities.iterator();
				while(iterator.hasNext()) {
					DeliveryOrderDtEntity dtEntity = iterator.next();
					if(dtEntity == null) {
						iterator.remove();
						continue;
					}
					//获取原来的订单OID
					Long orderOid = dtEntity.getOrderOid();
					
					//设置发送单ID
					dtEntity.setOrderOid(entity.getOid());
					
					// @ TODO  判断库存和送货单中数量
					
					
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
	
	
	public DeliveryOrderEntity getDeliveryOrder(Long oid) throws Exception {
		if(oid == null) {
			throw new Exception("oid为空");
		}
		DeliveryOrderEntity entity = deliveryOrderDao.getDeliveryOrder(oid);
		if(entity != null) {
			return entity;
		}
		throw new Exception("未查询到该订单");
	}
	
	
	public List<ProductEntity> getDeliveryOrderDts(Long oid) throws Exception {
		if(oid == null) {
			throw new Exception("oid为空");
		}
		List<ProductEntity> list = productService.getProductByDeliveryOrderOid(oid);
		return list;
	}
}
