package com.cg.demo.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.demo.bean.Polygon;

public class TestLifeCycle {

	public static void main(String[] args) {
		
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
		
		Polygon polygon = applicationContext.getBean(Polygon.class);
		
		polygon.draw();
		
		applicationContext.registerShutdownHook();
		

	}

}
