package com.zyf.springAOP.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // 切面需要被装配到IoC容器中
@Aspect // @Aspect定义切面
public class AspectDemo {
	// 定义切点
	// 语法：@Pointcut("execution(* 目标对象.连接点(..))")，*和目标对象之间要一个空格，否则报错
	@Pointcut("execution(* com.zyf.springAOP.service.UserService.printUserName(..))")
	public void pointCut() {
	}
	// 前置通知-切点前方法
	@Before("pointCut()")
	public void before() {
		System.out.println("执行方法：before");
	}
	// 后置通知-切点后方法
	@After("pointCut()")
	public void after() {
		System.out.println("执行方法：after");
	}
	// 事后返回通知-切点返回后方法
	@AfterReturning("pointCut()")
	public void afterReturning() {
		System.out.println("执行方法：afterReturning");
	}
	// 异常通知-切点异常后方法
	@AfterThrowing("pointCut()")
	public void afterThrowing() {
		System.out.println("执行方法：afterThrowing");
	}
	
	// 环绕通知
	// 环绕通知使用时，@Before的方法是在pj.proceed()调用时，且是在回调原来方法之前执行。一些书籍说慎用springbootAOP中的环绕通知！
	@Around("pointCut()")
	public void around(ProceedingJoinPoint pj) throws Throwable{
		System.out.println("执行方法：around...回调前");
		pj.proceed();//回调目标对象的原有方法
		
		System.out.println("执行方法：around...回调后");
	}
	
	/* 1.切面，@Aspect定义，所谓面，在这个面中可以定义流程中的各个元素:切点、通知。
	 * 2.切点，@Pointcut定义，切点就是我们定义的业务逻辑方法（即AOP中的目标对象.连接点）。
	 * 3.目标对象，即类的实例。
	 * 4.连接点，即类中业务逻辑方法。
	 * 5.通知，AOP流程中的方法，随着切点或在切点前或在切点后执行，或异常出现时执行。
	 * 6.织入，各类通知和切点按照一定顺序执行，形成一个流程，就是织入，也就是【面向切面编程，即AOP】
	 */
}
