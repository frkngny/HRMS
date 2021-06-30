package com.daysixhwtwo.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daysixhwtwo.demo.business.abstracts.EmployeeCheckService;
import com.daysixhwtwo.demo.dataAccess.abstracts.EmployeeDao;
import com.daysixhwtwo.demo.entities.concretes.Employee;

@Service
public class EmployeeCheckManager implements EmployeeCheckService {
	
	private EmployeeDao employeeDao;
	
	public EmployeeCheckManager() {}
	
	@Autowired
	public EmployeeCheckManager(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public boolean checkIfReal(Employee employee) {
		return true;
	}

	@Override
	public boolean checkIfAlreadyExists(Employee employee) {
		List<Employee> employees = this.employeeDao.findAll();
		
		boolean exists = false;
		for(Employee eachEmployee : employees) {
			if(employee.getTcno() == eachEmployee.getTcno() || employee.getEmail().equals(eachEmployee.getEmail())) {
				exists = true;
				break;
			}
		}
		
		return exists;
	}

	@Override
	public boolean emailVerified(Employee employee) {
		return true;
	}
}
