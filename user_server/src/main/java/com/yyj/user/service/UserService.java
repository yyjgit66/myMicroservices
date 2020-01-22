package com.yyj.user.service;

import com.yyj.user.dataobject.UserInfo;

public interface UserService {

	/**
	 * 通过openid查询用户信息
	 * @param openid
	 * @return
	 */
	UserInfo findByOpenid(String openid);
}
