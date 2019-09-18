package com.zyf.springAOP.service;

import org.springframework.stereotype.Service;

@Service
public class AspectOrderServiceImpl implements AspectOrderService {

	@Override
	public void printOrderTest() {
		System.out.println("多切面测试...");
	}
}
