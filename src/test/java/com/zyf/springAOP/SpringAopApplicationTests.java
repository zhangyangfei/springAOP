package com.zyf.springAOP;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.zyf.springAOP.config.BeanConfig;
import com.zyf.springAOP.pojo.User;
import com.zyf.springAOP.service.AspectOrderService;
import com.zyf.springAOP.service.UserService;
import com.zyf.springAOP.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAopApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private AspectOrderService aspectOrderService;
	@Test
	public void aspectOrderTest() {
		aspectOrderService.printOrderTest();
	}
	
	@Autowired
	private UserService userService;
//	@Test
	public void aspectTest() {
		User user = getUser();
		user.setName("zyf");
//		user =null;
		userService.printUserName(user);
	}

//	@Test
	public void beanTest() {
		System.out.println(getUser());
	}

	@SuppressWarnings("resource")
	User getUser() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
		User user = ac.getBean(User.class);
		return user;
	}
}
