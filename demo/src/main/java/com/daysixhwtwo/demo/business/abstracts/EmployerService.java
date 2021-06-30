package com.daysixhwtwo.demo.business.abstracts;

import java.util.List;

import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	void add(Employer employer);
}
