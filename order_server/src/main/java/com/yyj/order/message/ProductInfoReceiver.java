package com.yyj.order.message;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yyj.product.common.ProductInfoOutPut;

@Component
public class ProductInfoReceiver {
	
	private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@RabbitListener(queuesToDeclare=@Queue("productInfo"))
	public void proess(String message){
		List<ProductInfoOutPut> pot =   JSON.parseArray(message,ProductInfoOutPut.class);

		System.out.println("从productInfo队列接收到消息"+pot);
		
		//放入redis缓存中
		for (ProductInfoOutPut productInfoOutPut : pot) {
			 stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutPut.getProductId()),String.valueOf(productInfoOutPut.getProductStock()));
		}
	}
}
