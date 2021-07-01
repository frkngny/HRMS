package com.daysixhwtwo.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daysixhwtwo.demo.business.abstracts.JobCandidateExperienceService;
import com.daysixhwtwo.demo.business.abstracts.JobCandidateCheckService;
import com.daysixhwtwo.demo.business.abstracts.JobCandidateSchoolService;
import com.daysixhwtwo.demo.business.abstracts.JobCandidateService;
import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.core.utilities.results.SuccessDataResult;
import com.daysixhwtwo.demo.dataAccess.abstracts.CandidateExperienceDao;
import com.daysixhwtwo.demo.dataAccess.abstracts.CandidateSchoolDao;
import com.daysixhwtwo.demo.dataAccess.abstracts.JobCandidateDao;
import com.daysixhwtwo.demo.entities.concretes.CandidateExperience;
import com.daysixhwtwo.demo.entities.concretes.CandidateSchool;
import com.daysixhwtwo.demo.entities.concretes.JobCandidate;
import com.daysixhwtwo.demo.entities.dtos.JobCandidateWithExperienceDto;
import com.daysixhwtwo.demo.entities.dtos.JobCandidateWithSchoolDto;

@Service
public class JobCandidateManager implements JobCandidateService, JobCandidateExperienceService, JobCandidateSchoolService {
	@Autowired
	private JobCandidateDao jobCandidateDao;
	
	@Autowired
	private CandidateExperienceDao candidateExperienceDao;
	
	@Autowired
	private CandidateSchoolDao candidateSchoolDao;
	
	@Autowired
	private JobCandidateCheckService jobCandidateCheckService;
	
	public JobCandidateManager() {}
	
	
	public JobCandidateManager(JobCandidateDao jobCandidateDao) {
		this.jobCandidateDao = jobCandidateDao;
	}
	
	public JobCandidateManager(CandidateExperienceDao candidateExperienceDao) {
		this.candidateExperienceDao = candidateExperienceDao;
	}
	
	public JobCandidateManager(CandidateSchoolDao candidateSchoolDao) {
		this.candidateSchoolDao = candidateSchoolDao;
	}
	
	public JobCandidateManager(JobCandidateCheckService jobCandidateCheckService) {
		this.jobCandidateCheckService = jobCandidateCheckService;
	}
	
	@Override
	public void addJobCandidate(JobCandidate jobCandidate) {
		this.jobCandidateDao.save(jobCandidate);
	}

	@Override
	public void addCandidateExperience(CandidateExperience candidateExperience) {
		this.candidateExperienceDao.save(candidateExperience);
	}


	@Override
	public DataResult<List<JobCandidate>> getJobCandidates() {
		return new SuccessDataResult<List<JobCandidate>>(this.jobCandidateDao.findAll());
	}


	@Override
	public DataResult<List<CandidateExperience>> getAll() {
		return new SuccessDataResult<List<CandidateExperience>>(this.candidateExperienceDao.findAll());
	}


	@Override
	public DataResult<List<JobCandidateWithExperienceDto>> getJobCandidateWithExperience() {
		return new SuccessDataResult<List<JobCandidateWithExperienceDto>>(this.jobCandidateDao.getJobCandidateWithExperience());
	}


	@Override
	public DataResult<List<JobCandidateWithSchoolDto>> getJobCandidateWithSchool() {
		return new SuccessDataResult<List<JobCandidateWithSchoolDto>>(this.jobCandidateDao.getJobCandidateWithSchool());
	}


	@Override
	public void addSchool(CandidateSchool candidateSchool) {
		if(!this.jobCandidateCheckService.isGraduated(candidateSchool)) {
			candidateSchool.setSchoolEndYear(0);
		}
		this.candidateSchoolDao.save(candidateSchool);
	}


	@Override
	public DataResult<List<CandidateSchool>> getAllSchool() {
		return new SuccessDataResult<List<CandidateSchool>>(this.candidateSchoolDao.findAll());
	}
	

}
