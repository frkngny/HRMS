package com.daysixhwtwo.demo.business.abstracts;

import com.daysixhwtwo.demo.entities.concretes.Employee;

public interface EmployeeCheckService {
	boolean checkIfReal(Employee employee);
	boolean checkIfAlreadyExists(Employee employee);
	boolean emailVerified(Employee employee);
}
