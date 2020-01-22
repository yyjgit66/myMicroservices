package com.yyj.apigateway.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.yyj.apigateway.exception.RateLimiterException;

@Component
public class RateFilter extends ZuulFilter{

	//做限流
	private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);
	@Override
	public Object run() {
		if(!RateFilter.RATE_LIMITER.tryAcquire()){
			throw  new RateLimiterException();
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SERVLET_DETECTION_FILTER_ORDER-1;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	
}
