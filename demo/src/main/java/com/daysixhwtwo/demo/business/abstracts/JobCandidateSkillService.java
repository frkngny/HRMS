package com.daysixhwtwo.demo.business.abstracts;

import java.util.List;

import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.entities.concretes.CandidateSkill;

public interface JobCandidateSkillService {
	void addCandidateSkill(CandidateSkill candidateSkill);
	DataResult<List<CandidateSkill>> getCandidateSkill();
}
