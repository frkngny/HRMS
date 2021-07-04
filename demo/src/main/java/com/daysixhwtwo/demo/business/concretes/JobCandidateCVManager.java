package com.daysixhwtwo.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daysixhwtwo.demo.business.abstracts.JobCandidateCheckService;
import com.daysixhwtwo.demo.business.abstracts.JobCandidateCoverLetterService;
import com.daysixhwtwo.demo.business.abstracts.JobCandidateExperienceService;
import com.daysixhwtwo.demo.business.abstracts.JobCandidateLanguageService;
import com.daysixhwtwo.demo.business.abstracts.JobCandidateSchoolService;
import com.daysixhwtwo.demo.business.abstracts.JobCandidateSkillService;
import com.daysixhwtwo.demo.business.abstracts.JobCandidateUrlService;
import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.core.utilities.results.SuccessDataResult;
import com.daysixhwtwo.demo.dataAccess.abstracts.CandidateCoverLetterDao;
import com.daysixhwtwo.demo.dataAccess.abstracts.CandidateExperienceDao;
import com.daysixhwtwo.demo.dataAccess.abstracts.CandidateLanguageDao;
import com.daysixhwtwo.demo.dataAccess.abstracts.CandidateSchoolDao;
import com.daysixhwtwo.demo.dataAccess.abstracts.CandidateSkillDao;
import com.daysixhwtwo.demo.dataAccess.abstracts.CandidateUrlDao;
import com.daysixhwtwo.demo.entities.concretes.CandidateCoverLetter;
import com.daysixhwtwo.demo.entities.concretes.CandidateExperience;
import com.daysixhwtwo.demo.entities.concretes.CandidateLanguage;
import com.daysixhwtwo.demo.entities.concretes.CandidateSchool;
import com.daysixhwtwo.demo.entities.concretes.CandidateSkill;
import com.daysixhwtwo.demo.entities.concretes.CandidateUrl;

@Service
public class JobCandidateCVManager implements JobCandidateExperienceService, JobCandidateSchoolService, JobCandidateLanguageService, JobCandidateUrlService, JobCandidateSkillService, JobCandidateCoverLetterService {
	@Autowired
	private CandidateExperienceDao candidateExperienceDao;
	
	@Autowired
	private CandidateSchoolDao candidateSchoolDao;
	
	@Autowired
	private JobCandidateCheckService jobCandidateCheckService;
	
	@Autowired
	private CandidateLanguageDao candidateLanguageDao;
	
	@Autowired
	private CandidateUrlDao candidateUrlDao;
	
	@Autowired
	private CandidateSkillDao candidateSkillDao;
	
	@Autowired
	private CandidateCoverLetterDao candidateCoverLetterDao;
	
	public JobCandidateCVManager() {}

	public JobCandidateCVManager(CandidateExperienceDao candidateExperienceDao) {
		this.candidateExperienceDao = candidateExperienceDao;
	}
	
	public JobCandidateCVManager(CandidateSchoolDao candidateSchoolDao) {
		this.candidateSchoolDao = candidateSchoolDao;
	}
	
	public JobCandidateCVManager(JobCandidateCheckService jobCandidateCheckService) {
		this.jobCandidateCheckService = jobCandidateCheckService;
	}
	
	public JobCandidateCVManager(CandidateLanguageDao candidateLanguageDao) {
		this.candidateLanguageDao = candidateLanguageDao;
	}
	
	public JobCandidateCVManager(CandidateUrlDao candidateUrlDao) {
		this.candidateUrlDao = candidateUrlDao;
	}
	
	public JobCandidateCVManager(CandidateSkillDao candidateSkillDao) {
		this.candidateSkillDao = candidateSkillDao;
	}
	
	public JobCandidateCVManager(CandidateCoverLetterDao candidateCoverLetterDao) {
		this.candidateCoverLetterDao = candidateCoverLetterDao;
	}
	
	@Override
	public void addCandidateExperience(CandidateExperience candidateExperience) {
		this.candidateExperienceDao.save(candidateExperience);
	}
	
	@Override
	public DataResult<List<CandidateExperience>> getAll() {
		return new SuccessDataResult<List<CandidateExperience>>(this.candidateExperienceDao.findAll());
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


	@Override
	public void addLanguage(CandidateLanguage candidateLanguage) {
		this.candidateLanguageDao.save(candidateLanguage);
	}


	@Override
	public DataResult<List<CandidateLanguage>> getCandidateLanguage() {
		return new SuccessDataResult<List<CandidateLanguage>>(this.candidateLanguageDao.findAll());
	}


	@Override
	public DataResult<List<CandidateLanguage>> getCandidateLanguageByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateLanguage>>(this.candidateLanguageDao.getByCandidateId(candidateId));
	}


	@Override
	public DataResult<List<CandidateExperience>> getCandidateExperienceByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateExperience>>(this.candidateExperienceDao.getByCandidateId(candidateId));
	}
	
	@Override
	public void addUrl(CandidateUrl candidateUrl) {
		this.candidateUrlDao.save(candidateUrl);
	}

	@Override
	public DataResult<List<CandidateUrl>> getCandidateUrl() {
		return new SuccessDataResult<List<CandidateUrl>>(this.candidateUrlDao.findAll());
	}

	@Override
	public void addCandidateSkill(CandidateSkill candidateSkill) {
		this.candidateSkillDao.save(candidateSkill);
		
	}

	@Override
	public DataResult<List<CandidateSkill>> getCandidateSkill() {
		return new SuccessDataResult<List<CandidateSkill>>(this.candidateSkillDao.findAll());
	}

	@Override
	public void addCoverLetter(CandidateCoverLetter candidateCoverLetter) {
		this.candidateCoverLetterDao.save(candidateCoverLetter);
		
	}

	@Override
	public DataResult<List<CandidateCoverLetter>> getCoverLetters() {
		return new SuccessDataResult<List<CandidateCoverLetter>>(this.candidateCoverLetterDao.findAll());
	}

	
}
