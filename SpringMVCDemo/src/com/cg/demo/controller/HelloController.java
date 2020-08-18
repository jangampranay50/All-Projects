package com.cg.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.demo.bean.Employee;
import com.cg.demo.service.EmployeeService;

@Controller
public class HelloController 
{
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("showemp")
	public String showEmployeePage()
	{
		return "emp";
	}
	
	@RequestMapping("addemp")
	public String addEmployee(Employee employee,Model model)
	{
		int id = employeeService.createEmployee(employee);
		String message = "Employee Added Successfully with Id : "+id;
		model.addAttribute("message", message);
		
		return "success";
	}
	
	@RequestMapping("welcome")
	public String sayHello()
	{
		return "show";
	}
	
	@RequestMapping("hello")
	public ModelAndView sayWelcome()
	{
		String data = "Employee Id=1001";
		
		ModelAndView model = new ModelAndView("display","empid",data);
		return model;
	}
	
	@RequestMapping("info")
	public String sayHi(Model model)
	{
		String str = "John";
		int salary = 98000;
		model.addAttribute("empname", str);
		model.addAttribute("salary", salary);
		
		return "info";
	}
	
}
