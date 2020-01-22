package com.yyj.order.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyj.order.dto.OrderDto;
import com.yyj.order.message.StreamClient;

@RestController
public class SendMessageController {

	@Autowired
	private StreamClient streamClient;
	
	@GetMapping("/sendMessage")
	public void process(){
		 OrderDto oo = new OrderDto();
		 oo.setOrderId("123456");
		streamClient.output().send(MessageBuilder.withPayload(oo).build());
	}
}
