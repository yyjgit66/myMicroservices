package com.yyj.apigateway.exception;

public class RateLimiterException extends RuntimeException{

	private Integer code;
	private String message;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RateLimiterException(Integer code,String message){
		super(message);
		this.code=code;
	}
	

	public RateLimiterException(){}
	
}
