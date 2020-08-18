package com.cg.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.demo.bean.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public int createEmployee(Employee employee) 
	{
		entityManager.persist(employee);
				
		return employee.getEmployeeId();
	}

	@Override
	public Employee find(int id) {
		
		return null;
	}
	
}
