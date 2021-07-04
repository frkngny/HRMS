package com.daysixhwtwo.demo.business.abstracts;

import java.util.List;

import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.entities.concretes.CandidateUrl;

public interface JobCandidateUrlService {
	void addUrl(CandidateUrl candidateUrl);
	DataResult<List<CandidateUrl>> getCandidateUrl();
}
