package com.cg.demo.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.demo.bean.Employee;
import com.cg.demo.bean.Triangle;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
		
		//Triangle triangle = (Triangle) applicationContext.getBean("triangle");
		
		//Triangle triangle = applicationContext.getBean(Triangle.class,"triangle");
		
		Triangle triangle = applicationContext.getBean(Triangle.class);
		
		triangle.draw();
		
		Employee employee = (Employee) applicationContext.getBean("emp");

		System.out.println(employee.getEmployeeId());
		System.out.println(employee.getName());
		System.out.println(employee.getSalary());
		
		employee = (Employee) applicationContext.getBean("employee");
		
		System.out.println("**************************************");
		System.out.println(employee.getEmployeeId());
		System.out.println(employee.getName());
		System.out.println(employee.getSalary());
		
	}

}
