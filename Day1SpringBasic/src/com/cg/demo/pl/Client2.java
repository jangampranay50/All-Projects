package com.cg.demo.pl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.demo.bean.Triangle;

public class Client2 {

	public static void main(String[] args) {
		
	ApplicationContext  ctx = new ClassPathXmlApplicationContext("bean1.xml");
	
	Triangle  triangle = ctx.getBean(Triangle.class,"trg");
	triangle.draw();

	}

}
