package com.yyj.product.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductVO {
	@JsonProperty("name")
	private String categoryName;
	@JsonProperty("type")
	private Integer categoryType;
	@JsonProperty("foods")
	List<ProductInfoVO> productInfoList;
	
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}
	public List<ProductInfoVO> getProductInfoList() {
		return productInfoList;
	}
	public void setProductInfoList(List<ProductInfoVO> productInfoList) {
		this.productInfoList = productInfoList;
	}
	
	

}
