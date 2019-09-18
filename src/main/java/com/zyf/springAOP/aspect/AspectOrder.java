package com.zyf.springAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectOrder {
	// 定义切点
	@Pointcut("execution(* com.zyf.springAOP.service.AspectOrderServiceImpl.printOrderTest(..))")
	public void pointCut() {
	}
}
