package com.daysixhwtwo.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.daysixhwtwo.demo.business.abstracts.JobCandidateService;

import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.core.utilities.results.ErrorDataResult;
import com.daysixhwtwo.demo.core.utilities.results.SuccessDataResult;

import com.daysixhwtwo.demo.dataAccess.abstracts.JobCandidateDao;

import com.daysixhwtwo.demo.entities.concretes.JobCandidate;
import com.daysixhwtwo.demo.entities.dtos.JobCandidateWithExperienceDto;
import com.daysixhwtwo.demo.entities.dtos.JobCandidateWithSchoolDto;

@Service
public class JobCandidateManager implements JobCandidateService {
	@Autowired
	private JobCandidateDao jobCandidateDao;
	

	
	public JobCandidateManager() {}
	
	
	public JobCandidateManager(JobCandidateDao jobCandidateDao) {
		this.jobCandidateDao = jobCandidateDao;
	}
	
	
	@Override
	public void addJobCandidate(JobCandidate jobCandidate) {
		this.jobCandidateDao.save(jobCandidate);
	}

	@Override
	public DataResult<List<JobCandidate>> getJobCandidates() {
		return new SuccessDataResult<List<JobCandidate>>(this.jobCandidateDao.findAll());
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
	public DataResult<List<JobCandidateWithSchoolDto>> getJobCandidateWithSchoolSortedByDate(String order) {
		Sort sort;
		if (order.equals("ASC")) {
			sort = Sort.by(Sort.Direction.ASC, "cs.schoolEndYear");
		} else if (order.equals("DESC")){
			sort = Sort.by(Sort.Direction.DESC, "cs.schoolEndYear");
		} else {
			return new ErrorDataResult<List<JobCandidateWithSchoolDto>>("order must be ASC or DESC");
		}
		return new SuccessDataResult<List<JobCandidateWithSchoolDto>>(this.jobCandidateDao.getJobCandidateWithSchoolSortedByDate(sort));
	}


	@Override
	public DataResult<JobCandidate> findJobCandidateById(int id) {
		return new SuccessDataResult<JobCandidate>(this.jobCandidateDao.findById(id));
	}
	
}
