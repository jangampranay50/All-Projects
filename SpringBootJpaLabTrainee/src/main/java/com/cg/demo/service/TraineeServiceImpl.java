package com.cg.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.demo.dao.TraineeDao;
import com.cg.demo.entity.Trainee;
import com.cg.demo.exception.TraineeException;

@Service
public class TraineeServiceImpl implements TraineeService{

	@Autowired
	TraineeDao traineeDao;
	
	@Override
	public Trainee findTraineeById(int traineeId) throws TraineeException {
	
		Trainee trainee = traineeDao.findTraineeById(traineeId);
		
		if(trainee == null)
		{
			throw new TraineeException(traineeId+" Id Not Found");
		}
				
		return trainee;
	}

	@Override
	public Trainee addTrainee(Trainee trainee) throws TraineeException {
		traineeDao.addTrainee(trainee);
		return trainee;
	}

	@Override
	public Trainee updateTrainee(Trainee trainee) throws TraineeException {
		
		if(traineeDao.findTraineeById(trainee.getTraineeId()) != null)
		{
			traineeDao.updateTrainee(trainee);
		}
		else
		{
			throw new TraineeException(trainee.getTraineeId()+" Not Found");
		}
		
		return trainee;
	}

	@Override
	public List<Trainee> findAllTrainees() throws TraineeException {
		List<Trainee> list = traineeDao.findAllTrainees();
		
		if(list.isEmpty())
		{
			throw new TraineeException("Empty Record");
		}
		
		return list;
	}

	@Override
	public Trainee deleteTraineeById(int traineeId) throws TraineeException {
		
		Trainee trainee = traineeDao.deleteTraineeById(traineeId);
		
		if(trainee == null)
		{
			throw new TraineeException(trainee.getTraineeId()+" Not Found");
		}
				
		return trainee;
	}

}
