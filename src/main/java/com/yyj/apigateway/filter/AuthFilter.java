package com.yyj.apigateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.yyj.apigateway.constant.RedisConstant;
import com.yyj.apigateway.utils.CookieUtil;
import javax.servlet.http.Cookie;

/**
 * 权限拦截（区分买家和卖家）
 * @author Administrator
 *
 */
@Component
public class AuthFilter extends ZuulFilter{

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Override
	public Object run() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		  /**
		   * order/create 只能买家访问
		   * order/finish 只能卖家访问
		   * product/list 都可访问
		   */
		if("/order/order/create".equals(request.getRequestURI())){
			Cookie cookie = CookieUtil.get(request, "openid");
			if(null == cookie || StringUtils.isEmpty(cookie.getValue())){
				requestContext.setSendZuulResponse(false);
				requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
			}
		}
		
		if("/order/order/finish".equals(request.getRequestURI())){
			Cookie cookie = CookieUtil.get(request, "token");
			if(null == cookie 
					|| StringUtils.isEmpty(cookie.getValue())
					|| StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))){
				requestContext.setSendZuulResponse(false);
				requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
			}
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return false;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

}
