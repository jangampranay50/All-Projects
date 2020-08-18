package com.cg.demo.service;

import com.cg.demo.bean.Employee;

public interface EmployeeService 
{
	public int createEmployee(Employee employee);
	public Employee find(int id);
}
