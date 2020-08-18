package com.cg.demo.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.demo.bean.Point;
import com.cg.demo.bean.Square;

public class TestSquare {

	public static void main(String[] args) {
		
//		Square square = new Square();
//		
//		Point p1 = new Point(10,20);
//		Point p2 = new Point(30,40);
//		Point p3 = new Point(50,60);
//		Point p4 = new Point(70,80);
//		
//		List<Point> list = new ArrayList<Point>();
//		
//		list.add(p1);
//		list.add(p2);
//		list.add(p3);
//		list.add(p4);
//		
//		square.setPoints(list);
//		square.draw();
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring1.xml");
		
		Square square = (Square) applicationContext.getBean("square");
		square.draw();

	}

}
