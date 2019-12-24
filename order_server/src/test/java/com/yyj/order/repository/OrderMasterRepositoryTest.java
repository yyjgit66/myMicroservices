package com.yyj.order.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yyj.order.dataobject.OrderMaster;
import com.yyj.order.enums.OrderStatusEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

	@Autowired
	OrderMasterRepository orderMasterRepository;
	@Test
	public void testSave() {
		OrderMaster om = new OrderMaster();
		om.setOrderId("1234567");
		om.setBuyerName("师兄");
		om.setBuyerPhone("1854652491425");
		om.setBuyerAddress("慕课网总部");
		om.setBuyerOpenid("110110");
		om.setOrderAmount(new BigDecimal(2.5));
		om.setOrderStatus(OrderStatusEnum.NEW.getCode());
		om.setPayStatus(OrderStatusEnum.NEW.getCode());
		
		OrderMaster resultOrder= orderMasterRepository.save(om);
		Assert.assertTrue(null != resultOrder);
	}

}
