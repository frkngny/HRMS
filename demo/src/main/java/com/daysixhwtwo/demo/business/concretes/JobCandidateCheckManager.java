package com.daysixhwtwo.demo.business.concretes;

import org.springframework.stereotype.Service;

import com.daysixhwtwo.demo.business.abstracts.JobCandidateCheckService;
import com.daysixhwtwo.demo.entities.concretes.CandidateSchool;

@Service
public class JobCandidateCheckManager implements JobCandidateCheckService {

	@Override
	public boolean isGraduated(CandidateSchool candidateSchool) {
		if(candidateSchool.isGraduated()) {
			return true;
		}
		return false;
	}

}
