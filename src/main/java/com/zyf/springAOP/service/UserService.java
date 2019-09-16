package com.zyf.springAOP.service;

import org.springframework.stereotype.Service;

import com.zyf.springAOP.pojo.User;

@Service
public class UserService {

	public void printUserName(User user) {
		System.out.println("用户的名字是" + user.getName());
	}
}
