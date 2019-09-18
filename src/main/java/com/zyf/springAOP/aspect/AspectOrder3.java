package com.zyf.springAOP.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class AspectOrder3 {
	// 定义切点
	@Pointcut("execution(* com.zyf.springAOP.service.AspectOrderServiceImpl.printOrderTest(..))")
	public void pointCut() {
	}

	@Before("pointCut()")
	public void befor() {
		System.out.println("AspectOrder3...befor...");
	}
	
	@After("pointCut()")
	public void after() {
		System.out.println("AspectOrder3...after...");
	}
	
	@AfterReturning("pointCut()")
	public void afterReturning() {
		System.out.println("AspectOrder3...afterReturning...");
	}
}
