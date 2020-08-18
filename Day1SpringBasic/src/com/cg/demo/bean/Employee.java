package com.cg.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {

	private int employeeId;
	
	private String employeeName;
	
	private double employeeSalary;

	@Autowired
	private Address  address ;
	
	
	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	
	
	

	public Employee(int employeeId, String employeeName, double employeeSalary, Address address) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.address = address;
	}



	public Employee() {
		super();
	}



	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}


	public void init()
	{
		System.out.println("  bean  init method called ");
	}

	public void destroy()
	{
		System.out.println( " bean destroy method called ");
	}



	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSalary="
				+ employeeSalary + ", address=" + address + "]";
	}
	
	
	
}
