package com.daysixhwtwo.demo.business.abstracts;


import java.util.List;

import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.entities.concretes.CandidateExperience;

public interface JobCandidateExperienceService {
	void addCandidateExperience(CandidateExperience candidateExperience);
	DataResult<List<CandidateExperience>> getAll();
}
