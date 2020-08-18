package com.cg.demo.dao;

import java.util.List;

import com.cg.demo.entity.Trainee;
import com.cg.demo.exception.TraineeException;



public interface TraineeDao {
	
	 public Trainee findTraineeById(int traineeId)  throws TraineeException ;
		
		public Trainee addTrainee(Trainee  trainee)     throws TraineeException;
		
		public Trainee updateTrainee(Trainee  trainee)  throws TraineeException;
		
		public List<Trainee>  findAllTrainees()         throws TraineeException;
		
		public Trainee deleteTraineeById(int traineeId) throws TraineeException;
	
}
