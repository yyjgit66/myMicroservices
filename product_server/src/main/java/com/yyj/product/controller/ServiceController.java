package com.yyj.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

	@GetMapping("/getString")
	public String getString(){
		return "this is product`msg";
	}
}
