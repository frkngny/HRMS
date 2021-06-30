package com.daysixhwtwo.demo.business.abstracts;

import java.util.List;

import com.daysixhwtwo.demo.core.utilities.results.DataResult;
import com.daysixhwtwo.demo.entities.concretes.Personel;

public interface PersonelService {
	DataResult<List<Personel>> getAll();
	void add(Personel personel);
}
