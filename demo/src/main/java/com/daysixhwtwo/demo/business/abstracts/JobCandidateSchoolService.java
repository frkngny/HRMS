package com.daysixhwtwo.demo.business.abstracts;

import java.util.List;

import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.entities.concretes.CandidateSchool;

public interface JobCandidateSchoolService {
	void addSchool(CandidateSchool candidateSchool);
	DataResult<List<CandidateSchool>> getAllSchool();
}
