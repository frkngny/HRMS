package com.daysixhwtwo.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daysixhwtwo.demo.business.abstracts.EmployeeCheckService;
import com.daysixhwtwo.demo.business.abstracts.EmployeeService;
import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.core.utilities.results.ErrorResult;
import com.daysixhwtwo.demo.core.utilities.results.Result;
import com.daysixhwtwo.demo.core.utilities.results.SuccessDataResult;
import com.daysixhwtwo.demo.dataAccess.abstracts.EmployeeDao;
import com.daysixhwtwo.demo.entities.concretes.Employee;
import com.daysixhwtwo.demo.core.utilities.results.SuccessResult;

@Service
public class EmployeeManager extends BaseUserManager implements EmployeeService  {
	
	
	private EmployeeDao employeeDao;
	private EmployeeCheckService employeeCheckService;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,EmployeeCheckService employeeCheckService) {
		this.employeeDao = employeeDao;
		this.employeeCheckService = employeeCheckService;
	}
	
	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
	}
	
	
	@Override
	public Result add(Employee employee) {
		if(this.employeeCheckService.checkIfReal(employee)) {
			if(!this.employeeCheckService.checkIfAlreadyExists(employee) && this.employeeCheckService.emailVerified(employee)) {
				this.employeeDao.save(employee);
				return new SuccessResult(super.save(employee));
			} else {
				return new ErrorResult(super.userExists());
			}
		} else {
			return new ErrorResult(super.invalidTC());
		}
		
		
	}

}
