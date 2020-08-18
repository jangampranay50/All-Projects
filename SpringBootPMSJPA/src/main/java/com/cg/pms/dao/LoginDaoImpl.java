package com.cg.pms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.pms.entity.Login;
import com.cg.pms.exception.LoginException;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Login validate(String userName, String userPass) throws LoginException {
		
		String qry = "SELECT e FROM Login e  where e.userName=:user and e.userPass=:pass";
		TypedQuery<Login> query = entityManager.createQuery(qry,Login.class);
		query.setParameter("user", userName);
		query.setParameter("pass", userPass);
		List<Login> list = query.getResultList();
		Login login = null;
		if(!list.isEmpty())
			login = list.get(0);
		
		return login;
	}

	@Override
	public Login create(Login login) throws LoginException {
		
		entityManager.persist(login);
		
		return login;
	}

	@Override
	public Login findUser(String userName) throws LoginException {
		
		Login login = entityManager.find(Login.class,userName);
		
		return login;
	}

}
