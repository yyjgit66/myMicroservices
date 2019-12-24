package com.yyj.product.service;

import java.util.List;

import com.yyj.product.common.DecreaseStockInPut;
import com.yyj.product.common.ProductInfoOutPut;
import com.yyj.product.dataobject.ProductInfo;

public interface ProductService {
	/**
	 * 查询所有在架商品列表
	 * @return
	 */
	List<ProductInfo> findUpALL();
	
	/**
	 * 查询所有商品信息给订单服务
	 * @return
	 */
	List<ProductInfoOutPut> findList(List<String> productIdList);
	
	/**
	 * 扣库存
	 * @param carDtoList
	 */
	void decreaseStock(List<DecreaseStockInPut> carDtoList);
}
