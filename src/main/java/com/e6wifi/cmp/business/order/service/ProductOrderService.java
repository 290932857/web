package com.e6wifi.cmp.business.order.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.e6wifi.cmp.business.order.dao.ProductOrderDao;
import com.e6wifi.cmp.business.order.entity.ProductOrderDtEntity;
import com.e6wifi.cmp.business.order.entity.ProductOrderEntity;
import com.e6wifi.cmp.business.product.entity.ProductEntity;
import com.e6wifi.cmp.business.product.service.ProductService;
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
	
	@Autowired
	private ProductService productService;
	
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
			entity.setState(1);
			entity.setOrderDate(new Date());
			long num = productOrderDao.insertOrder(entity);
			if(num <= 0 && entity.getOid() == null) {
				return null;
			}
			Gson gson = new Gson();
			Type type = new TypeToken<List<ProductOrderDtEntity>>(){}.getType();
			List<ProductOrderDtEntity> orderDtEntities = gson.fromJson(params, type);
			if(orderDtEntities != null && !orderDtEntities.isEmpty()) {
				for(ProductOrderDtEntity dtEntity : orderDtEntities) {
					dtEntity.setOrderOid(entity.getOid());
				}
			}
			productOrderDao.insertOrderDt(orderDtEntities);
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
				productOrderDao.deleteOrderDtByOrderOid(oid);
				productOrderDao.deleteOrder(oid);
			} catch (Exception e) {
				throw new Exception("删除订单失败");
			}
		}
		return 1l;
	}
	
	/**
	 * 签收订单
	 * @return
	 * @throws Exception
	 */
	public Long signProductOrder(ProductOrderEntity orderEntity) throws Exception {
		//判断订单是否签收
		ProductOrderEntity dbEntity = productOrderDao.getProductOrder(orderEntity.getOid());
		
		//已签收订单无法再次签收
		if(dbEntity.getState() == 2 || dbEntity.getState() == 3) {
			throw new Exception("该订单已经签收入库或者过期无法再次签收入库");
		}
		
		//更新订单状态
		long num = updateProductOrderState(orderEntity);
		if(num > 0) {
			//添加库存表
			List<ProductOrderDtEntity> productEntities = productOrderDao.getProductOrderDts(orderEntity.getOid());
			if(productEntities != null && productEntities.size() > 0) {
				List<StockEntity> entities = new ArrayList<StockEntity>();
				for(ProductOrderDtEntity dtEntity : productEntities) {
					StockEntity stock = new StockEntity();
					stock.setOrderOid(orderEntity.getOid());
					stock.setProductOid(dtEntity.getProductOid());
					stock.setProviderOid(dbEntity.getProviderOid());
					stock.setWarehouseOid(dbEntity.getWarehouseOid());
					stock.setNum(dtEntity.getNum());
					stock.setAddDate(new Date());
					entities.add(stock);
				}
				stockService.insertStocks(entities);
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
		
		long num = productOrderDao.updateOrder(orderEntity);
		if(num > 0) {
			return num;
		}
		throw new Exception("更新订单状态失败");
	}
	
	/**
	 * 查询订单
	 * @param oid
	 * @return
	 * @throws Exception
	 */
	public ProductOrderEntity getProductOrder(Long oid) throws Exception {
		if(oid == null) {
			throw new Exception("oid为空");
		}
		ProductOrderEntity entity = productOrderDao.getProductOrder(oid);
		if(entity != null) {
			return entity;
		}
		throw new Exception("未查询到该订单");
	}
	
	/**
	 * 通过订单ID查询产品信息
	 * @param oid
	 * @return
	 * @throws Exception
	 */
	public List<ProductEntity> getProductByOrderOid(Long oid) throws Exception {
		if(oid == null) {
			throw new Exception("oid为空");
		}
		List<ProductEntity> list = productService.getProductByOrderOid(oid);
		return list;
	}
	
	/**
	 * 通过订单ID查询产品信息
	 * @param oid
	 * @return
	 * @throws Exception
	 */
	public ProductOrderEntity getOrderByOrderOid(Long oid) throws Exception {
		if(oid == null) {
			throw new Exception("oid为空");
		}
		ProductOrderEntity entity = getProductOrder(oid);
		if(entity != null) {
			List<ProductEntity> list = productService.getProductByOrderOid(oid);
			entity.setProductEntities(list);
		}
		return entity;
	}
}
