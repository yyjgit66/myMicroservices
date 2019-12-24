package com.yyj.order.converter;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yyj.order.dataobject.OrderDetail;
import com.yyj.order.dto.OrderDto;
import com.yyj.order.enums.ResultEnum;
import com.yyj.order.exception.OrderException;
import com.yyj.order.form.OrderForm;

public class OrderForm2OrderDto {
	public static OrderDto convert(OrderForm orderForm){
		Gson gson = new Gson();
		OrderDto orderDto = new OrderDto();
		orderDto.setBuyerName(orderForm.getName());
		orderDto.setBuyerPhone(orderForm.getPhone());
		orderDto.setBuyerAddress(orderForm.getAddress());
		orderDto.setBuyerOpenid(orderForm.getOpenid());
		List<OrderDetail> list = new ArrayList<>();
		try {
			list = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
		orderDto.setOrderDetailList(list);
		return orderDto;
	}
}
