package com.yyj.product.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	@Transactional
	public void decreaseStock(List<DecreaseStockInPut> carDtoList) {
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
		}
	}

}
