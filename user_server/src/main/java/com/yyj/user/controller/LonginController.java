package com.yyj.user.controller;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yyj.user.constant.CookieConstant;
import com.yyj.user.constant.RedisConstant;
import com.yyj.user.dataobject.UserInfo;
import com.yyj.user.enums.ResultEnum;
import com.yyj.user.enums.RoleEnum;
import com.yyj.user.service.UserService;
import com.yyj.user.utils.CookieUtil;
import com.yyj.user.utils.ResultVOUtil;
import com.yyj.user.vo.ResultVO;

@RestController
@RequestMapping("/login")
public class LonginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	/**
	 * 买家登录
	 * @param openid
	 * @param response
	 * @return
	 */
	@GetMapping("/buyer")
	public ResultVO buyer(@RequestParam("openid") String openid,HttpServletResponse response){
		UserInfo userInfo = userService.findByOpenid(openid);
		//openid和数据库里的是否匹配
		if(null == userInfo){
			return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
		}
		//2.判断角色
		if(RoleEnum.BUYER.getCode() != userInfo.getRole()){
			return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
		}
		
		//3.cookie里设置openid=abc
		CookieUtil.set(response, CookieConstant.OPENID, openid, CookieConstant.EXPIRE);
		
		return ResultVOUtil.success();
	}
	
	
	/**
	 * 卖家登录
	 * @param openid
	 * @param response
	 * @return
	 */
	@GetMapping("/seller")
	public ResultVO seller(@RequestParam("openid") String openid,
			HttpServletResponse response,
			HttpServletRequest request){
		Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
		if(cookie != null && 
				StringUtils.isNotEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))){
			return ResultVOUtil.success();
		}
		UserInfo userInfo = userService.findByOpenid(openid);
		//openid和数据库里的是否匹配
		if(null == userInfo){
			return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
		}
		//2.判断角色
		if(RoleEnum.SELLER.getCode() != userInfo.getRole()){
			return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
		}
		
		//3.存入redis
		String token = UUID.randomUUID().toString();
		Integer expire = CookieConstant.EXPIRE;
		stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE, token), 
				openid,
				expire,
				TimeUnit.SECONDS);
		
		//4.cookie里设置openid=abc
		CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);
		
		return ResultVOUtil.success();
	}
}
