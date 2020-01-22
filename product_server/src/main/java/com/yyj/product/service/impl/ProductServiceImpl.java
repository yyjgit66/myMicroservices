package com.yyj.product.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.rabbitmq.tools.json.JSONUtil;
import com.yyj.product.common.DecreaseStockInPut;
import com.yyj.product.common.ProductInfoOutPut;
import com.yyj.product.dataobject.ProductInfo;
import com.yyj.product.enums.ProductStatusEnum;
import com.yyj.product.enums.ResultEnum;
import com.yyj.product.exception.ProductException;
import com.yyj.product.repository.ProductInfoRepository;
import com.yyj.product.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductInfoRepository productInfoRepository;
	
	@Autowired
	AmqpTemplate amqpTemplate;
	
	@Override
	public List<ProductInfo> findUpALL() {
		return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}

	@Override
	public List<ProductInfoOutPut> findList(List<String> productIdList) {
		return  productInfoRepository.findByproductIdIn(productIdList).stream().map(e->{
			ProductInfoOutPut pop = new ProductInfoOutPut();
			BeanUtils.copyProperties(e, pop);
			return pop;
		}).collect(Collectors.toList());
	}

	@Override
	public void decreaseStock(List<DecreaseStockInPut> carDtoList) {
		List<ProductInfo> productInfoList = decreaseStockProess(carDtoList);
		List<ProductInfoOutPut> potList =  productInfoList.stream().map(e->{
			 ProductInfoOutPut pot = new ProductInfoOutPut();
		     BeanUtils.copyProperties(e, pot);
		     return pot;
		}).collect(Collectors.toList());
		  //发送mq消息
		  String temp = JSON.toJSONString(potList);
		  amqpTemplate.convertAndSend("productInfo",temp);
	}
	
	@Transactional
	public List<ProductInfo> decreaseStockProess(List<DecreaseStockInPut> carDtoList) {
		List<ProductInfo> productInfoList = new ArrayList<>();
		for(DecreaseStockInPut carDto : carDtoList){
			Optional<ProductInfo> productInfoOptional = 	productInfoRepository.findById(carDto.getProductId());
			if(!productInfoOptional.isPresent()){
				throw new ProductException(ResultEnum.PRODUCT_NOT_EXISTS);
			}
			ProductInfo productInfo = productInfoOptional.get();
			  Integer stock = productInfo.getProductStock()-carDto.getProductQuantity();
			  if(stock < 0){
				  throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
			  }
			  productInfo.setProductStock(stock);
			  productInfoRepository.save(productInfo);
			  productInfoList.add(productInfo);
		}
		return productInfoList;
	}

}
