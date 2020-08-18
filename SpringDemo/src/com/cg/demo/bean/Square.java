package com.cg.demo.bean;

import java.util.List;

public class Square 
{
	private List<Point> points;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> point) {
		this.points = point;
	}
	
	public void draw()
	{
		System.out.println("Square Draw");
		System.out.println("Square Points");
		
		for(Point point : points)
		{
			System.out.println("X = "+point.getX()+" y = "+point.getY());
		}
	}
}
