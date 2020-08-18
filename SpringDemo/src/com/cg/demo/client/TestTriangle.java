package com.cg.demo.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.demo.bean.Point;
import com.cg.demo.bean.Triangle;

public class TestTriangle {

	public static void main(String[] args) {
		
//		Triangle triangle = new Triangle();
//		
//		Point point = new Point();
//		
//		point.setX(100); point.setY(200);
//		
//		triangle.setPoint(point);
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		
		Triangle triangle = applicationContext.getBean(Triangle.class);
		triangle.draw();

	}

}
