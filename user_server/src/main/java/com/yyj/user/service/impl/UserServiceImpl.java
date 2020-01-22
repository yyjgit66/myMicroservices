package com.yyj.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyj.user.dataobject.UserInfo;
import com.yyj.user.repository.UserInfoRepository;
import com.yyj.user.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserInfoRepository userInfoRepository; 
	@Override
	public UserInfo findByOpenid(String openid) {
		return userInfoRepository.findByOpenid(openid);
	}

}
