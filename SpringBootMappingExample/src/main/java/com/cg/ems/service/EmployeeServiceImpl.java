package com.cg.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.entity.Employee;
import com.cg.ems.exception.EmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Employee findEmployeeById(int employeeId) throws EmployeeException {
		
		Employee employee = employeeDao.findEmployeeById(employeeId);
		
		if(employee == null)
		{
			throw new EmployeeException("ID NOT FOUND");
		}
		return employee;
	}

	@Override
	public List<Employee> findAllEmployees() throws EmployeeException {
		List<Employee> list = employeeDao.findAllEmployees();
		if(list.isEmpty())
		{
			throw new EmployeeException("Record Empty");
		}
		return list;
	}

	@Override
	public Employee createEmployee(Employee employee) throws EmployeeException {
		Employee emp = employeeDao.createEmployee(employee);
		return emp;
	}

}
