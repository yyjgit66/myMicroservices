package com.yyj.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yyj.product.dataobject.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
