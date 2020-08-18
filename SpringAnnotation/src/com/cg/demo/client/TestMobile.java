package com.cg.demo.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.demo.bean.Mobile;
import com.cg.demo.bean.Triangle;

public class TestMobile {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("spring.xml");

		Mobile mobile = applicationContext.getBean(Mobile.class);
		
		System.out.println(mobile.getSimInfo());

	}

}
