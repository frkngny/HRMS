package com.daysixhwtwo.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daysixhwtwo.demo.business.abstracts.JobCandidateCoverLetterService;
import com.daysixhwtwo.demo.business.abstracts.JobCandidateExperienceService;
import com.daysixhwtwo.demo.business.abstracts.JobCandidateLanguageService;
import com.daysixhwtwo.demo.business.abstracts.JobCandidateSchoolService;
import com.daysixhwtwo.demo.business.abstracts.JobCandidateSkillService;
import com.daysixhwtwo.demo.business.abstracts.JobCandidateUrlService;
import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.entities.concretes.CandidateCoverLetter;
import com.daysixhwtwo.demo.entities.concretes.CandidateExperience;
import com.daysixhwtwo.demo.entities.concretes.CandidateLanguage;
import com.daysixhwtwo.demo.entities.concretes.CandidateSchool;
import com.daysixhwtwo.demo.entities.concretes.CandidateSkill;
import com.daysixhwtwo.demo.entities.concretes.CandidateUrl;

@RestController
@RequestMapping("/api/users/candidate_cv")
public class CandidatesCvController {
	@Autowired
	private JobCandidateExperienceService jobCandidateExperienceService;
	
	@Autowired
	private JobCandidateSchoolService jobCandidateSchoolService;
	
	@Autowired
	private JobCandidateLanguageService jobCandidateLanguageService;
	
	@Autowired
	private JobCandidateUrlService jobCandidateUrlService;
	
	@Autowired
	private JobCandidateSkillService jobCandidateSkillService;
	
	@Autowired
	private JobCandidateCoverLetterService jobCandidateCoverLetterService;
	
	public CandidatesCvController() {}
	
	public CandidatesCvController(JobCandidateExperienceService jobCandidateExperienceService) {
		this.jobCandidateExperienceService = jobCandidateExperienceService;
	}
	
	public CandidatesCvController(JobCandidateSchoolService jobCandidateSchoolService) {
		this.jobCandidateSchoolService = jobCandidateSchoolService;
	}
	
	public CandidatesCvController(JobCandidateLanguageService jobCandidateLanguageService) {
		this.jobCandidateLanguageService = jobCandidateLanguageService;
	}
	
	public CandidatesCvController(JobCandidateUrlService jobCandidateUrlService) {
		this.jobCandidateUrlService = jobCandidateUrlService;
	}
	
	public CandidatesCvController(JobCandidateSkillService jobCandidateSkillService) {
		this.jobCandidateSkillService = jobCandidateSkillService;
	}
	
	public CandidatesCvController(JobCandidateCoverLetterService jobCandidateCoverLetterService) {
		this.jobCandidateCoverLetterService = jobCandidateCoverLetterService;
	}
	
	@PostMapping("/addJobCandidateExperience")
	public void addCandidateExperience(@RequestBody CandidateExperience candidateExperience) {
		this.jobCandidateExperienceService.addCandidateExperience(candidateExperience);
	}
	
	@GetMapping("/getJobCandidateExperience")
	public DataResult<List<CandidateExperience>> getJobCandidateExperience(){
		return this.jobCandidateExperienceService.getAll();
	}
	
	@GetMapping("/getJobCandidateExperienceByCandidateId")
	public DataResult<List<CandidateExperience>> getCandidateExperienceByCandidateId(@RequestParam int candidateId){
		return this.jobCandidateExperienceService.getCandidateExperienceByCandidateId(candidateId);
	}
	
	
	@PostMapping("/addJobCandidateSchool")
	public void addJobCandidateSchool(@RequestBody CandidateSchool candidateSchool){
		this.jobCandidateSchoolService.addSchool(candidateSchool);
	}
	
	@GetMapping("/getJobCandidateSchool")
	public DataResult<List<CandidateSchool>> getJobCandidateSchool(){
		return this.jobCandidateSchoolService.getAllSchool();
	}

	@PostMapping("/addJobCandidateLanguage")
	public void addLanguage(@RequestBody CandidateLanguage candidateLanguage) {
		this.jobCandidateLanguageService.addLanguage(candidateLanguage);
	}
	
	@GetMapping("/getJobCandidateLanguageByCandidateId")
	public DataResult<List<CandidateLanguage>> getCandidateLanguageByCandidateId(@RequestParam int candidateId){
		return this.jobCandidateLanguageService.getCandidateLanguageByCandidateId(candidateId);
	}
	
	
	@PostMapping("/addJobCandidateUrl")
	public void addJobCandidateUrl(@RequestBody CandidateUrl candidateUrl) {
		this.jobCandidateUrlService.addUrl(candidateUrl);
	}
	
	@GetMapping("/getJobCandidateUrl")
	public DataResult<List<CandidateUrl>> getCandidateUrl(){
		return this.jobCandidateUrlService.getCandidateUrl();
	}
	
	@PostMapping("/addJobCandidateSkill")
	public void addCandidateSkill(@RequestBody CandidateSkill candidateSkill) {
		this.jobCandidateSkillService.addCandidateSkill(candidateSkill);
	}
	
	@GetMapping("/getJobCandidateSkill")
	public DataResult<List<CandidateSkill>> getCandidateSkill() {
		return this.jobCandidateSkillService.getCandidateSkill();
	}
	
	@PostMapping("/addJobCandidateCoverLetter")
	public void addCoverLetter(@RequestBody CandidateCoverLetter candidateCoverLetter) {
		this.jobCandidateCoverLetterService.addCoverLetter(candidateCoverLetter);
	}
	
	@GetMapping("/getJobCandidateCoverLetter")
	public DataResult<List<CandidateCoverLetter>> getCoverLetters(){
		return this.jobCandidateCoverLetterService.getCoverLetters();
	}
	
}
