package com.cg.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.demo.bean.Employee;
import com.cg.demo.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public int createEmployee(Employee employee) {
		int employeeId = employeeDao.createEmployee(employee);
		return employeeId;
	}

	@Override
	public Employee find(int id) {
		
		return null;
	}
	
}
