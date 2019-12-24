package com.yyj.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyj.product.dataobject.ProductCategory;
import com.yyj.product.repository.ProductCategoryRepository;
import com.yyj.product.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	ProductCategoryRepository productCategoryRepository;
	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType) {
		return productCategoryRepository.findByCategoryTypeIn(categoryType);
	}

}
