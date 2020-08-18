package com.cg.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.entity.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("employee/{eid}")
	public ResponseEntity<Employee> findEmployee(@PathVariable("eid") int employeeId) throws EmployeeException
	{
		Employee employee = employeeService.findEmployeeById(employeeId);
		ResponseEntity<Employee> re = new ResponseEntity<>(employee,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("employee")
	public ResponseEntity<List<Employee>> findAllEmployee() throws EmployeeException
	{
		List<Employee> list = employeeService.findAllEmployees();
		ResponseEntity<List<Employee>> re = new ResponseEntity<>(list,HttpStatus.OK);
		return re;
	}
	
	@PostMapping("employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws EmployeeException
	{
		Employee emp = employeeService.createEmployee(employee);
		ResponseEntity<Employee> re = new ResponseEntity<>(emp,HttpStatus.OK);
		return re;
	}
}
