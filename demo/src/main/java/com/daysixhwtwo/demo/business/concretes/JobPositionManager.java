package com.daysixhwtwo.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daysixhwtwo.demo.business.abstracts.JobPositionCheckService;
import com.daysixhwtwo.demo.business.abstracts.JobPositionService;
import com.daysixhwtwo.demo.dataAccess.abstracts.JobPositionDao;
import com.daysixhwtwo.demo.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;
	private JobPositionCheckService jobPositionCheckService;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao, JobPositionCheckService jobPositionCheckService) {
		this.jobPositionDao = jobPositionDao;
		this.jobPositionCheckService = jobPositionCheckService;
	}
	
	@Override
	public List<JobPosition> getPositions() {
		return this.jobPositionDao.findAll();
	}

	@Override
	public void addPosition(JobPosition jobPosition) {
		if(!jobPositionCheckService.positionAlreadyExists(jobPosition)) {
			this.jobPositionDao.save(jobPosition);
			System.out.println("Position added: " + jobPosition.getJobPosition());
		} else {
			System.out.println("Position already exists: " + jobPosition.getJobPosition());
		}
		
	}

}
