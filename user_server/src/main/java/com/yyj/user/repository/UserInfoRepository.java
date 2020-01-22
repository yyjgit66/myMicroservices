package com.yyj.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yyj.user.dataobject.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, String>{

	UserInfo findByOpenid(String openid);
}
