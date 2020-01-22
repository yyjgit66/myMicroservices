package com.yyj.order.repository;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * 发送mq消息测试
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MqSenderTest {
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Test
	public void test(){
		amqpTemplate.convertAndSend("myQueue", "now:"+LocalDate.now());
	}
	

	@Test
	public void sendOrder(){
		amqpTemplate.convertAndSend("myOrder", "computer","now:"+LocalDate.now());
	}
}
