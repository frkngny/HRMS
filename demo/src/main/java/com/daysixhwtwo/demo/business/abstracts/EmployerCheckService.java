package com.daysixhwtwo.demo.business.abstracts;

import com.daysixhwtwo.demo.entities.concretes.Employer;

public interface EmployerCheckService {
	boolean emailVerified(Employer employer);
	boolean emailAlreadyExists(Employer employer);
	boolean isConfirmed(Employer employer);
}
