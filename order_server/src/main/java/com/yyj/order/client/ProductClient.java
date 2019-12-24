package com.yyj.order.client;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yyj.order.dataobject.ProductInfo;
import com.yyj.order.dto.CarDTO;


public interface ProductClient {

	@GetMapping("getString")
	public String productMsg();
	
	@PostMapping("/product/listForOrder")
	public List<ProductInfo> listForOrder(@RequestBody List<String> productList);
	
	@PostMapping("/product/decreaseStock")
	public void decreaseStock(@RequestBody List<CarDTO> carDtoList);
}
