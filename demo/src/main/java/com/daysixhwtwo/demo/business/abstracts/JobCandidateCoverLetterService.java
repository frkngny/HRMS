package com.daysixhwtwo.demo.business.abstracts;

import java.util.List;

import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.entities.concretes.CandidateCoverLetter;

public interface JobCandidateCoverLetterService {
	void addCoverLetter(CandidateCoverLetter candidateCoverLetter);
	DataResult<List<CandidateCoverLetter>> getCoverLetters();
}
