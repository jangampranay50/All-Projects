package com.cg.ems.service;

import java.util.List;

import com.cg.ems.entity.Employee;
import com.cg.ems.exception.EmployeeException;

public interface EmployeeService {

	public Employee findEmployeeById(int employeeId) throws EmployeeException;
	public List<Employee> findAllEmployees() throws EmployeeException;
	public Employee createEmployee(Employee employee) throws EmployeeException;
}
