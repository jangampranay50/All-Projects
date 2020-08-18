package com.cg.demo.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.demo.bean.Triangle;

public class TestScope {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
		
		Triangle t1 = (Triangle) applicationContext.getBean("triangle");
		t1.draw();
		
		Triangle t2 = (Triangle) applicationContext.getBean("triangle");
		t2.draw();
		
		if(t1==t2)
		{
			System.out.println("Single instance i.e Singleton Design Pattern");
		}
		else
		{
			System.out.println("Multiple instance i.e Prototype Design Pattern");
		}
	}

}
