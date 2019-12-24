package com.yyj.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yyj.product.common.ProductInfoOutPut;
import com.yyj.product.dataobject.ProductInfo;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>{
	List<ProductInfo> findByProductStatus(Integer productStatus);
	List<ProductInfo> findByproductIdIn(List<String> productIdList);
}
