package com.daysixhwtwo.demo.business.abstracts;

import com.daysixhwtwo.demo.entities.concretes.JobPosition;

public interface JobPositionCheckService {
	boolean positionAlreadyExists(JobPosition jobPosition);
}
