package com.yyj.product.vo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductInfoVO {
	@JsonProperty("id")
	private String productId;
	@JsonProperty("name")
	private String productName;
	@JsonProperty("price")
	private BigDecimal productPrice;
	@JsonProperty("desription")
	private String productDesription;
	@JsonProperty("icon")
	private String productIcon;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDesription() {
		return productDesription;
	}
	public void setProductDesription(String productDesription) {
		this.productDesription = productDesription;
	}
	public String getProductIcon() {
		return productIcon;
	}
	public void setProductIcon(String productIcon) {
		this.productIcon = productIcon;
	}
	
	
}
