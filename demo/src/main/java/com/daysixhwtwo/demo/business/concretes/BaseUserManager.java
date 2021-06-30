package com.daysixhwtwo.demo.business.concretes;

import com.daysixhwtwo.demo.entities.concretes.Employee;
import com.daysixhwtwo.demo.entities.concretes.Employer;
import com.daysixhwtwo.demo.entities.concretes.Personel;

public class BaseUserManager {
	public String save(Personel personel) {
		return "Saved to db: " + personel.getFirstName();
	}
	
	public String save(Employee employee) {
		return "Saved to db: " + employee.getFirstName();
	}
	
	public String save(Employer employer) {
		return "Saved to db: " + employer.getFirstName();
	}
	
	public String userExists() {
		return "Cannot save the user because user already exists.";
	}
	
	public String invalidTC() {
		return "Invalid TC no!";
	}
	
	public String cannotSave(String cause) {
		return "Cannot save the user because " + cause;
	}
	
}
