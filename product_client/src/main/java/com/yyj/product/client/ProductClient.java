package com.yyj.product.client;

import java.util.List;

//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yyj.product.common.DecreaseStockInPut;
import com.yyj.product.common.ProductInfoOutPut;
//@FeignClient(name="product",fallback= ProductClient.ProductClientFallback.class) 由于m3版本有问题feign服务降级等升级后在做
@FeignClient(name="product")
public interface ProductClient {
	@PostMapping("/product/listForOrder")
	public List<ProductInfoOutPut> listForOrder(@RequestBody List<String> productList);
	
	@PostMapping("/product/decreaseStock")
	public void decreaseStock(@RequestBody List<DecreaseStockInPut> carDtoList);
	
//	@Component
//	static class ProductClientFallback implements ProductClient{
//
//		@Override
//		public List<ProductInfoOutPut> listForOrder(List<String> productList) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public void decreaseStock(List<DecreaseStockInPut> carDtoList) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
}
