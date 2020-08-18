package com.cg.demo.bean;

import java.util.List;
import java.util.Set;

public class Employee {

	private int employeeId;
	
	private String employeeName;
	
	Set<String>   skill ;
	
public Set<String> getSkill() {
		return skill;
	}

	public void setSkill(Set<String> skill) {
		this.skill = skill;
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
	
	}
