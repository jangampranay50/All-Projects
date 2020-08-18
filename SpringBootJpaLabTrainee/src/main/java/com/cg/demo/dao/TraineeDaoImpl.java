package com.cg.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.demo.entity.Trainee;
import com.cg.demo.exception.TraineeException;

@Repository
@Transactional
public class TraineeDaoImpl implements TraineeDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Trainee findTraineeById(int traineeId) throws TraineeException {
		Trainee trainee = entityManager.find(Trainee.class, traineeId);
		return trainee;
	}

	@Override
	public Trainee addTrainee(Trainee trainee) throws TraineeException {
		entityManager.persist(trainee);
		return trainee;
	}

	@Override
	public Trainee updateTrainee(Trainee trainee) throws TraineeException {
		entityManager.merge(trainee);
		return trainee;
	}

	@Override
	public List<Trainee> findAllTrainees() throws TraineeException {
		String qry = "SELECT t FROM Trainee t";
		TypedQuery<Trainee> query = entityManager.createQuery(qry,Trainee.class);
		List<Trainee> list = query.getResultList();
		return list;
	}

	@Override
	public Trainee deleteTraineeById(int traineeId) throws TraineeException {
		Trainee trainee = entityManager.find(Trainee.class, traineeId);
		if(trainee!=null)
		{
			entityManager.remove(trainee);
		}
		return trainee;
	}

	
}
