package com.yyj.user.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	/**
	 * 设置cookie
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 */
	public static void set(HttpServletResponse response,
			                 String name,
			                 String value,
			                 int maxAge){
		Cookie cookie = new Cookie(name,value);
		cookie.setPath("/");
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}
	
	
	/**
	 * 获取cookie
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 */
	public static Cookie get(HttpServletRequest request,String name){
		Cookie[] cookie = request.getCookies();
		if(cookie != null ){
			for(Cookie ck : cookie){
				if(name.equals(ck.getName())){
					return ck;
				}
			}
		}
		return null;
	}
}
