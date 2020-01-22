package com.yyj.order.service;

import com.yyj.order.dto.OrderDto;

public interface OrderService {
	/**
	 * 创建订单
	 * @param orderDto
	 * @return
	 */
	OrderDto create(OrderDto orderDto);
	
	/**
	 * 完结订单（只能卖家操作）
	 * @param orderId
	 * @return
	 */
	OrderDto finish(String orderId);
}
