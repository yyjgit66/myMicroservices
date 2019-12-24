package com.yyj.order.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientService {

	//@Autowired
	//ProductClient productClient;
//	@Autowired
//	LoadBalancerClient loadBalancerClient;
//	@Autowired
//	RestTemplate restTemplate;
	@GetMapping("/getPrdouctString")
	public String getStringProduct(){
		//第一种方式url写死
//		RestTemplate restTemplate = new RestTemplate();
//		String obj =  restTemplate.getForObject("http://localhost:8080/getString",String.class);
		
		//第二种方式通过LoadBalancerClient获取url
//		RestTemplate restTemplate = new RestTemplate();
//		ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//		serviceInstance.getHost();
//		serviceInstance.getPort();
//		String url = String.format("http://%s:%s", serviceInstance.getHost(),serviceInstance.getPort())+"/getString";
//		String obj = restTemplate.getForObject(url, String.class);
//		String obj = productClient.productMsg();
//		return obj;
		return null;
	}
	
//	@GetMapping("/getProudctInfoList")
//	public String getProudctInfoList(){
//		List<ProductInfo> infoList = productClient.listForOrder(Arrays.asList("157875196366160022"));
//		System.out.println("uuuuuuuuuuuuu"+infoList);
//		return "ok";
//	}
//	
//	@GetMapping("/getProductDecreaseStock")
//	public String getProductDecreaseStock(){
//	 	productClient.decreaseStock(Arrays.asList(new CarDTO("157875227953464068",2)));
//	 	return "Ok";
//		
//	} 
	
}
