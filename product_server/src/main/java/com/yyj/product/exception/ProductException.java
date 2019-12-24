package com.yyj.product.exception;

import com.yyj.product.enums.ResultEnum;

public class ProductException extends RuntimeException{

	public Integer code;
	public ProductException(String message,Integer code){
		super(message);
		this.code=code;
	}
	
	public ProductException(ResultEnum reEnum){
		super(reEnum.getMessage());
		this.code=reEnum.getCode();
	}
}
