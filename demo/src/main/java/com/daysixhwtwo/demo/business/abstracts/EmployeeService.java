package com.daysixhwtwo.demo.business.abstracts;

import java.util.List;

import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.core.utilities.results.Result;
import com.daysixhwtwo.demo.entities.concretes.Employee;

public interface EmployeeService {
	DataResult<List<Employee>> getAll();
	Result add(Employee employee);
	
}
