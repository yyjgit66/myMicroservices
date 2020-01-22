package com.yyj.order.enums;

public enum ResultEnum {
	PARAM_ERROR(1,"参数错误"),
	ORDER_NOT_EXIST(3,"订单不存在"),
	ORDER_STATUS_ERROR(4,"订单状态错误"),
	ORDER_DETAIL_NOT_EXIST(5,"订单详情不存在");
	private Integer code;
	private String message;
	ResultEnum(Integer code,String message){
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
