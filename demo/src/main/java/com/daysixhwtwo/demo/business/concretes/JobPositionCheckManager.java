package com.daysixhwtwo.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daysixhwtwo.demo.business.abstracts.JobPositionCheckService;
import com.daysixhwtwo.demo.dataAccess.abstracts.JobPositionDao;
import com.daysixhwtwo.demo.entities.concretes.JobPosition;

@Service
public class JobPositionCheckManager implements JobPositionCheckService{
	
	private JobPositionDao jobPositionDao;
	
	public JobPositionCheckManager() {}
	
	@Autowired
	public JobPositionCheckManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public boolean positionAlreadyExists(JobPosition jobPosition) {
		List<JobPosition> jobPositions = this.jobPositionDao.findAll();
		
		boolean exists = false;
		for(JobPosition position : jobPositions) {
			if(jobPosition.getJobPosition().equals(position.getJobPosition())) {
				exists = true;
				break;
			}
		}
		return exists;
	}

}
