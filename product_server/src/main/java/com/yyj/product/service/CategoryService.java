package com.yyj.product.service;

import java.util.List;

import com.yyj.product.dataobject.ProductCategory;

public interface CategoryService {
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
