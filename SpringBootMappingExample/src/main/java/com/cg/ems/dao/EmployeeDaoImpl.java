package com.cg.ems.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ems.entity.Employee;
import com.cg.ems.exception.EmployeeException;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Employee findEmployeeById(int employeeId) throws EmployeeException {
		
		Employee employee = entityManager.find(Employee.class, employeeId);
		return employee;
	}

	@Override
	public List<Employee> findAllEmployees() throws EmployeeException {
		
		String qry = "SELECT e FROM Employee e";
		TypedQuery<Employee> query = entityManager.createQuery(qry,Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public Employee createEmployee(Employee employee) throws EmployeeException {
		entityManager.persist(employee);
		return employee;
	}

}
