package com.cg.demo.pl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.demo.bean.Triangle;

public class Client {

	public static void main(String[] args) {
		
		  ApplicationContext  ctx = new ClassPathXmlApplicationContext("bean.xml");	
		  Triangle  triangle  = ctx.getBean(Triangle.class);
		  triangle.draw();
		 

	}

}
