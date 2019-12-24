package com.yyj.order.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yyj.order.dataobject.OrderDetail;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

	@Autowired
	OrderDetailRepository orderDetailRepository; 
	@Test
	public void testSave() {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setDetailId("1233");
		orderDetail.setOrderId("1234567");
		orderDetail.setProductIcon("http:xxx.com");
		orderDetail.setProductId("1234567465413");
		orderDetail.setProductName("皮蛋粥");
		orderDetail.setProductPrice(new BigDecimal(5.5));
		orderDetail.setProductQuantity(2);
		OrderDetail od = orderDetailRepository.save(orderDetail);
		Assert.assertTrue(null != od);
	}

}
