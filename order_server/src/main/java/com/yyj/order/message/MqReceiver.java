package com.yyj.order.message;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收mq的消息
 * @author Administrator
 *
 */
@Component
public class MqReceiver {

	//@RabbitListener(queues="myQueue")
	//自动创建队列 	@RabbitListener(queuesToDeclare= @Queue("myQueue"))
    // 自动创建，exchange和queue绑定
	@RabbitListener(bindings=@QueueBinding(
				value= @Queue("myQueue"),
				exchange= @Exchange("myExchange")
			))
	private void process(String messages){
		System.out.println("MqReceiver"+messages);
	}
	
	
	/**
	 * 数码供应商   接收消息
	 * @param messages
	 */
	@RabbitListener(bindings=@QueueBinding(
			exchange= @Exchange("myOrder"),
			key="computer",
			value= @Queue("computerOrder")
			
		))
	private void processComputer(String messages){
		System.out.println("computer MqReceiver"+messages);
	}
	
	/**
	 * 水果供应商  接收消息
	 * @param messages
	 */
	@RabbitListener(bindings=@QueueBinding(
			exchange= @Exchange("myOrder"),
			key="fruit",
			value= @Queue("fruitOrder")
			
		))
	private void processFruit(String messages){
		System.out.println("fruit MqReceiver"+messages);
	}
}
