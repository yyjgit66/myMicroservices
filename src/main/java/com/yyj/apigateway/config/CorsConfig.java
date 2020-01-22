package com.yyj.apigateway.config;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域处理
 * @author Administrator
 *
 */
@Configuration
public class CorsConfig {

	@Bean
	public CorsFilter corsFilter(){
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		//cookie可以跨域
		config.setAllowCredentials(true);
		//原始域 www.a.com
		config.setAllowedOrigins(Arrays.asList("*"));
		//允许的头
		config.setAllowedHeaders(Arrays.asList("*"));
		//允许的方法
		config.setAllowedMethods(Arrays.asList("*"));
		//缓存时间   相同类型在时间内就不检查了
		config.setMaxAge(300l);
		//所有域都可以跨域
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}
