package com.yyj.product.service;


import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yyj.product.dataobject.ProductCategory;
import com.yyj.product.service.impl.CategoryServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
	@Autowired
	CategoryServiceImpl categoryServiceImpl;
	@Test
	public void testFindByCategoryTypeIn() {
		List<ProductCategory>  productCategoryList = 	categoryServiceImpl.findByCategoryTypeIn(Arrays.asList(1,22));
		Assert.assertTrue(productCategoryList.size() > 0);
		
	}

}
