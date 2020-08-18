package com.cg.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Triangle {
	
	@Autowired
	private Point point;
	
	public Triangle() {
		super();
	}

	public Triangle(Point point) {
		super();
		this.point = point;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public void draw()
	{
		System.out.println(" Triangle Draw");
		System.out.println(" Point x = "+point.getX()+" Point y = "+point.getY()); 
	}
	
}
