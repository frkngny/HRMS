package com.daysixhwtwo.demo.business.abstracts;

import java.util.List;

import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.entities.concretes.CandidateLanguage;

public interface JobCandidateLanguageService {
	void addLanguage(CandidateLanguage candidateLanguage);
	DataResult<List<CandidateLanguage>> getCandidateLanguage();
	DataResult<List<CandidateLanguage>> getCandidateLanguageByCandidateId(int candidateId);
}
