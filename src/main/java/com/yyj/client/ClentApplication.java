package com.yyj.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClentApplication {
    public static void main(String[] args) {
		SpringApplication.run(ClentApplication.class, args);
	}
}
