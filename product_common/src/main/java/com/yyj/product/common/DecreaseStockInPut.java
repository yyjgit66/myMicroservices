package com.yyj.product.common;

public class DecreaseStockInPut {
	//商品id
    private String productId;
	//商品数量
    private Integer productQuantity;
    
	public String getProductId() {
		return productId;
	}
	public DecreaseStockInPut(){}
	
	public DecreaseStockInPut(String productId,Integer productQuantity){
		this.productId=productId;
		this.productQuantity=productQuantity;
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
