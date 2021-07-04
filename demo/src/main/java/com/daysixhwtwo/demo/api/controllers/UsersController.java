package com.daysixhwtwo.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daysixhwtwo.demo.business.abstracts.EmployeeService;
import com.daysixhwtwo.demo.business.abstracts.EmployerService;
import com.daysixhwtwo.demo.business.abstracts.JobAdvertisementService;
import com.daysixhwtwo.demo.business.abstracts.JobCandidateService;
import com.daysixhwtwo.demo.business.abstracts.PersonelService;
import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.entities.concretes.Employee;
import com.daysixhwtwo.demo.entities.concretes.Employer;
import com.daysixhwtwo.demo.entities.concretes.JobAdvertisement;
import com.daysixhwtwo.demo.entities.concretes.JobCandidate;
import com.daysixhwtwo.demo.entities.concretes.Personel;
import com.daysixhwtwo.demo.entities.dtos.JobCandidateWithExperienceDto;
import com.daysixhwtwo.demo.entities.dtos.JobCandidateWithSchoolDto;

@RestController
@RequestMapping("/api/users")
public class UsersController<T> {
	
	@Autowired
	private PersonelService personelService;
	
	@Autowired
	private EmployerService employerService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	private JobCandidateService jobCandidateService;
	
	public UsersController() {}
	
	
	public UsersController(PersonelService personelService) {
		this.personelService = personelService;
	}
	
	
	public UsersController(EmployerService employerService) {
		this.employerService = employerService;
	}
	
	
	public UsersController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public UsersController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	public UsersController(JobCandidateService jobCandidateService) {
		this.jobCandidateService = jobCandidateService;
	}
	
	
	@GetMapping("/getallpersonel")
	public DataResult<List<Personel>> getAllPersonel() {
		return this.personelService.getAll();
	}
	
	@GetMapping("/getallemployer")
	public DataResult<List<Employer>> getAllEmployer() {
		return this.employerService.getAll();
	}
	
	@GetMapping("/getallemployee")
	public DataResult<List<Employee>> getAllEmployee() {
		return this.employeeService.getAll();
	}
	
	@GetMapping("/getJobAds")
	public List<JobAdvertisement> getAllAds(){
		return this.jobAdvertisementService.getAds();
	}
	
	@PostMapping("/addPersonel")
	public void addPersonel(@RequestBody Personel personel) {
		this.personelService.add(personel);
	}
	
	@PostMapping("/addEmployer")
	public void addEmployer(@RequestBody Employer employer) {
		this.employerService.add(employer);
	}
	
	@PostMapping("/addEmployee")
	public void addEmployee(@RequestBody Employee employee) {
		this.employeeService.add(employee);
	}
	
	@PostMapping("/addJobAdvertisement")
	public void addJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementService.addOpenPosition(jobAdvertisement);
	}
	
	@GetMapping("/get-ads-sorted-by-date")
	public List<JobAdvertisement> getAdsSortedByDate(@RequestParam String order){
		return this.jobAdvertisementService.getAdsSortedByDate(order);
	}
	
	@GetMapping("/getJobAdvertisementByCompanyName")
	public List<JobAdvertisement> getByCompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.getByCompanyName(companyName);
	}
	
	@PostMapping("/deleteJobAdvertisementById")
	public void deleteJobAdvertisementById(@RequestParam int id) {
		this.jobAdvertisementService.deleteAdvertisementById(id);
	}
	
	@PostMapping("/addJobCandidate")
	public void addJobCandidate(@RequestBody JobCandidate jobCandidate) {
		this.jobCandidateService.addJobCandidate(jobCandidate);
	}
	
	@GetMapping("/getJobCandidates")
	public DataResult<List<JobCandidate>> getJobCandidates(){
		return this.jobCandidateService.getJobCandidates();
	}
	
	@GetMapping("/getJobCandidateWithExperience")
	public DataResult<List<JobCandidateWithExperienceDto>> getJobCandidateWithExperience(){
		return this.jobCandidateService.getJobCandidateWithExperience();
	}
	
	@GetMapping("/getJobCandidateWithSchool")
	public DataResult<List<JobCandidateWithSchoolDto>> getJobCandidateWithSchool(){
		return this.jobCandidateService.getJobCandidateWithSchool();
	}
	
	@GetMapping("/getJobCandidateWithSchoolSortedByDate")
	public DataResult<List<JobCandidateWithSchoolDto>> getJobCandidateWithSchoolSortedByDate(@RequestParam String order){
		return this.jobCandidateService.getJobCandidateWithSchoolSortedByDate(order);
	}
	
	
	
}
