package com.yyj.product.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yyj.product.common.DecreaseStockInPut;
import com.yyj.product.common.ProductInfoOutPut;
@FeignClient(name="product")
public interface ProductClient {
	@PostMapping("/product/listForOrder")
	public List<ProductInfoOutPut> listForOrder(@RequestBody List<String> productList);
	
	@PostMapping("/product/decreaseStock")
	public void decreaseStock(@RequestBody List<DecreaseStockInPut> carDtoList);
}
