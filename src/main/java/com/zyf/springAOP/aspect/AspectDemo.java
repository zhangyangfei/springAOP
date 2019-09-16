package com.zyf.springAOP.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	// 通知-切点前方法
	@Before("pointCut()")
	public void before() {
		System.out.println("执行方法：before");
	}
	// 通知-切点后方法
	@After("pointCut()")
	public void after() {
		System.out.println("执行方法：after");
	}
	// 通知-切点返回后方法
	@AfterReturning("pointCut()")
	public void afterReturning() {
		System.out.println("执行方法：afterReturning");
	}
	// 通知-切点异常后方法
	@AfterThrowing("pointCut()")
	public void afterThrowing() {
		System.out.println("执行方法：afterThrowing");
	}
	
	/* 1.切面，@Aspect定义，所谓面，在这个面中可以定义流程中的各个元素:切点、通知。
	 * 2.切点，@Pointcut定义，切点就是我们定义的业务逻辑方法（即AOP中的目标对象.连接点）。
	 * 3.目标对象，即类的实例。
	 * 4.连接点，即类中业务逻辑方法。
	 * 5.通知，AOP流程中的方法，随着切点或在切点前或在切点后执行，或异常出现时执行。
	 * 6.织入，各类通知和切点按照一定顺序执行，形成一个流程，就是织入，也就是【面向切面编程，即AOP】
	 */
}
