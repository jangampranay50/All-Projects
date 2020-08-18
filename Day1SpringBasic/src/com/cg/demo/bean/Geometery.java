package com.cg.demo.bean;

public class Geometery {

	
	private Shape  shape ;
	
	public void display()
	{
		shape.draw();
	}

   public Shape getShape() {
		return shape;
	}
   public void setShape(Shape shape) {
		this.shape = shape;
	}
	
	
}
