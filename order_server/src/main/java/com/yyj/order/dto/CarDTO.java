package com.yyj.order.dto;

public class CarDTO {
	//商品id
	private String productId;
	//商品数量
	private Integer productQuantity;
	public CarDTO(){}
	public CarDTO(String productId,Integer productQuantity){
		this.productId=productId;
		this.productQuantity=productQuantity;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	

}
