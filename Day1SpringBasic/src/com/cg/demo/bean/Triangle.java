package com.cg.demo.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Triangle {

	 private String triangleName;
	 private int type;
	 

	 private Point  point ;
	 
	 
	 
	 
  public Point getPoint() {
		return point;
	}


	public void setPoint(Point point) {
		this.point = point;
	}


public Triangle(String triangleName, int type) {
		super();
		this.triangleName = triangleName;
		this.type = type;
	}

    
	public Triangle() {
		super();
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getTriangleName() {
		return triangleName;
	}


	public void setTriangleName(String triangleName) {
		this.triangleName = triangleName;
	}
    
	 public void draw()
	    {
	    	System.out.println(" Triangle Draw ");
	    	System.out.println(" Name = "+this.triangleName);
	    	System.out.println(" Type = "+this.type);
	    	System.out.println( " X = "+ getPoint().getX());
	    	System.out.println(" Y = " + point.getY());
	    }



	@PreDestroy
	public void destroy() throws Exception {
System.out.println(" Destroy Called ");
		
	}


	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		System.out.println(" After properties called");
		
	}
	 
}
