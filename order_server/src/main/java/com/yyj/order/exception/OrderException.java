package com.yyj.order.exception;

import com.yyj.order.enums.ResultEnum;


public class OrderException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Integer code;
	public OrderException(String message,Integer code){
		super(message);
		this.code=code;
	}
	
	public OrderException(ResultEnum resultEnum){
		super(resultEnum.getMessage());
		this.code=resultEnum.getCode();
		
	}
}
