package com.cg.demo.pl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.demo.bean.Circle;
import com.cg.demo.bean.Geometery;
import com.cg.demo.bean.Polygon;
import com.cg.demo.bean.Shape;
import com.cg.demo.bean.Square;
import com.cg.demo.bean.Triangle;

public class Client {

	public static void main(String[] args) {
		
	  ApplicationContext  ctx = new ClassPathXmlApplicationContext("bean.xml");
	  Geometery  geo  = ctx.getBean(Geometery.class);
	  
	  geo.display();
	}

}
