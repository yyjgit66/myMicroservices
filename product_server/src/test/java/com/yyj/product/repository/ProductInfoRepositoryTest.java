package com.yyj.product.repository;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yyj.product.dataobject.ProductInfo;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
	@Autowired
	ProductInfoRepository productInfoRepository;
	@Test
	public void testFindByProductStatus() {
		List<ProductInfo> productInfoList =  productInfoRepository.findByProductStatus(0);
		Assert.assertTrue(productInfoList.size() > 0);
	}

}
