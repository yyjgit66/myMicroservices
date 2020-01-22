package com.yyj.order.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yyj.order.converter.OrderForm2OrderDto;
import com.yyj.order.dto.OrderDto;
import com.yyj.order.enums.ResultEnum;
import com.yyj.order.exception.OrderException;
import com.yyj.order.form.OrderForm;
import com.yyj.order.service.OrderService;
import com.yyj.order.utils.ResultVOUtil;
import com.yyj.order.vo.ResultVO;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("hello")
	public String hello(){
		return "hello world";
		
	}
	
	/**
	 * 1.参数校验
	 * 2.查询商品信息
	 * 3.计算总价
	 * 4.扣库存
	 * 5.订单入库
	 */
	
	@PostMapping("/create")
	public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,BindingResult  bindingResult){
		if(bindingResult.hasErrors()){
			throw new OrderException(bindingResult.getFieldError().getDefaultMessage(),ResultEnum.PARAM_ERROR.getCode());
		}
		
		OrderDto orderDto = OrderForm2OrderDto.convert(orderForm);
		if(CollectionUtils.isEmpty(orderDto.getOrderDetailList())){
			throw new OrderException(ResultEnum.PARAM_ERROR);
		}
		OrderDto resulrt = orderService.create(orderDto);
		Map<String,String> map = new HashMap<>();
		map.put("orderId", resulrt.getOrderId());
		return ResultVOUtil.success(map);
	}
	
	/**
	 * 完结订单
	 * @param orderId
	 * @return
	 */
	@PostMapping("/finish")
	public ResultVO<OrderDto> finish(@RequestParam("orderId") String orderId){
		return ResultVOUtil.success(orderService.finish(orderId));
	}
}
