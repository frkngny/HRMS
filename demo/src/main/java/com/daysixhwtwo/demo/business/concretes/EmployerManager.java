package com.daysixhwtwo.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daysixhwtwo.demo.business.abstracts.EmployerCheckService;
import com.daysixhwtwo.demo.business.abstracts.EmployerService;
import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.core.utilities.results.SuccessDataResult;
import com.daysixhwtwo.demo.dataAccess.abstracts.EmployerDao;
import com.daysixhwtwo.demo.entities.concretes.Employer;

@Service
public class EmployerManager extends BaseUserManager implements EmployerService {
	
	private EmployerDao employerDao;
	private EmployerCheckService employerCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerCheckService employerCheckService) {
		this.employerDao = employerDao;
		this.employerCheckService = employerCheckService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public void add(Employer employer) {
		
		if(this.employerCheckService.emailVerified(employer) || this.employerCheckService.isConfirmed(employer)) {
			if(!this.employerCheckService.emailAlreadyExists(employer)) {
				this.employerDao.save(employer);
				super.save(employer);
			} else {
				super.cannotSave("email already exists.");
			}
		} else {
			super.cannotSave("email needs verification or personel should confirm.");
		}
		
	}
	
}
