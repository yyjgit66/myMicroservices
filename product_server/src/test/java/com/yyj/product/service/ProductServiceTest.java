package com.yyj.product.service;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yyj.product.dataobject.ProductInfo;
import com.yyj.product.service.impl.ProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

	@Autowired
	ProductServiceImpl productServiceImpl;
	
	
	@Test
	public void testFindUpALL() {
		List<ProductInfo>  productInfo = productServiceImpl.findUpALL();
		Assert.assertTrue(productInfo.size() > 0);
	}

}
