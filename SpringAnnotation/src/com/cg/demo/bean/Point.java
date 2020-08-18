package com.cg.demo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Point {
	
	@Value("#{100}")
	private int x;
	
	@Value("#{200}")
	private int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Point() {
		super();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
