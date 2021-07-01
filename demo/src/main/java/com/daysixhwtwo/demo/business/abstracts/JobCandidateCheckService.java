package com.daysixhwtwo.demo.business.abstracts;

import com.daysixhwtwo.demo.entities.concretes.CandidateSchool;

public interface JobCandidateCheckService {
	boolean isGraduated(CandidateSchool candidateSchool);
}
