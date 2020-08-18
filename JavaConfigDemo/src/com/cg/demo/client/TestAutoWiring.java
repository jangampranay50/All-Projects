package com.cg.demo.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.demo.bean.Triangle;
import com.cg.demo.config.BeanConfiguration;

public class TestAutoWiring {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext =
						new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		Triangle triangle = applicationContext.getBean(Triangle.class);
		triangle.draw();


	}

}
