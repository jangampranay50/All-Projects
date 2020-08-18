package com.cg.demo.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.demo.bean.Triangle;

public class TestAutoWiring {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext =
						new ClassPathXmlApplicationContext("bean.xml");
		
		Triangle triangle = applicationContext.getBean(Triangle.class);
		triangle.draw();


	}

}
