package com.cg.demo.pl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.demo.bean.Employee;

public class TestEmployee {

	public static void main(String[] args) {
		
ApplicationContext  ctx = new AnnotationConfigApplicationContext(com.cg.config.BeanConfiguration.class);
Employee  emp = ctx.getBean(Employee.class);	
System.out.println(emp);
	
	}

}
