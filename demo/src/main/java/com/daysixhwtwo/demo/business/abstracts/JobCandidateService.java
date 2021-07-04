package com.daysixhwtwo.demo.business.abstracts;

import java.util.List;

import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.entities.concretes.JobCandidate;
import com.daysixhwtwo.demo.entities.dtos.JobCandidateWithExperienceDto;
import com.daysixhwtwo.demo.entities.dtos.JobCandidateWithSchoolDto;

public interface JobCandidateService {
	void addJobCandidate(JobCandidate jobCandidate);
	DataResult<List<JobCandidate>> getJobCandidates();
	DataResult<List<JobCandidateWithExperienceDto>> getJobCandidateWithExperience();
	DataResult<List<JobCandidateWithSchoolDto>> getJobCandidateWithSchool();
	DataResult<List<JobCandidateWithSchoolDto>> getJobCandidateWithSchoolSortedByDate(String order);
	
	DataResult<JobCandidate> findJobCandidateById(int id);
}
