package com.yyj.order.service;

import com.yyj.order.dto.OrderDto;

public interface OrderService {
	/**
	 * 创建订单
	 * @param orderDto
	 * @return
	 */
	OrderDto create(OrderDto orderDto);
}
