package com.daysixhwtwo.demo.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daysixhwtwo.demo.entities.concretes.JobCandidate;
import com.daysixhwtwo.demo.entities.dtos.JobCandidateWithExperienceDto;
import com.daysixhwtwo.demo.entities.dtos.JobCandidateWithSchoolDto;

public interface JobCandidateDao extends JpaRepository<JobCandidate, Integer> {
	@Query("Select new com.daysixhwtwo.demo.entities.dtos.JobCandidateWithExperienceDto(jc, ce) From JobCandidate jc Inner Join CandidateExperience ce ON ce.candidateId=jc.id")
	List<JobCandidateWithExperienceDto> getJobCandidateWithExperience();
	
	@Query("Select new com.daysixhwtwo.demo.entities.dtos.JobCandidateWithSchoolDto(jc, cs) From JobCandidate jc Inner Join CandidateSchool cs ON cs.candidateId=jc.id")
	List<JobCandidateWithSchoolDto> getJobCandidateWithSchool();
}
