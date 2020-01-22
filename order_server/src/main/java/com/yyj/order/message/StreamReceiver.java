package com.yyj.order.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.yyj.order.dto.OrderDto;

/**
 * 接收端
 * @author Administrator
 *
 */
@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {

	@StreamListener(StreamClient.INPUT)
	@SendTo(StreamClient.INPUT2)
	public String process(OrderDto  message){
		System.out.print(message.getOrderId());
		return "received";
	}
	
	
	@StreamListener(StreamClient.INPUT2)
	public void process2(String  message){
		System.out.print("22222"+message);
	}
}
