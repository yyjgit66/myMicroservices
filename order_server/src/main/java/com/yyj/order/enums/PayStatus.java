package com.yyj.order.enums;

public enum PayStatus {
	NEW(0,"等待支付"),
	FINISHED(1,"支付成功");
	private Integer code;
	private String message;
	PayStatus(Integer code,String message){
		this.code=code;
		this.message=message;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
