package com.cg.demo.dao;

import com.cg.demo.bean.Employee;

public interface EmployeeDao 
{
	public int createEmployee(Employee employee);
	public Employee find(int id);
}
