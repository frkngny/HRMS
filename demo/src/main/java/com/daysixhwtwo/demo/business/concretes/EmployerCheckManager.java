package com.daysixhwtwo.demo.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daysixhwtwo.demo.business.abstracts.EmployerCheckService;
import com.daysixhwtwo.demo.dataAccess.abstracts.EmployerDao;
import com.daysixhwtwo.demo.entities.concretes.Employer;

@Service
public class EmployerCheckManager implements EmployerCheckService{
	
	private EmployerDao employerDao;
	
	public EmployerCheckManager() {}
	
	public EmployerCheckManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	public boolean emailVerified(Employer employer) {
		return true;
	}

	@Override
	public boolean emailAlreadyExists(Employer employer) {
		List<Employer> employerList = this.employerDao.findAll();
		
		boolean exists = false;
		for(Employer eachEmployer : employerList) {
			if(employer.getEmail().equals(eachEmployer.getEmail())) {
				exists = true;
				break;
			}
		}
		
		return exists;
	}

	@Override
	public boolean isConfirmed(Employer employer) {
		return true;
	}

}
