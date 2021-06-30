package com.daysixhwtwo.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.daysixhwtwo.demo.business.abstracts.JobAdvertisementService;
import com.daysixhwtwo.demo.dataAccess.abstracts.JobAdvertisementDao;
import com.daysixhwtwo.demo.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	public JobAdvertisementManager() {}
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public List<JobAdvertisement> getAds() {
		return this.jobAdvertisementDao.findAll();
	}

	@Override
	public void addOpenPosition(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
	}

	@Override
	public List<JobAdvertisement> getAdsSortedByDate(String order) {
		Sort sort;
		if (order.equals("ASC")) {
			sort = Sort.by(Sort.Direction.ASC, "deadline");
		} else {
			sort = Sort.by(Sort.Direction.DESC, "deadline");
		}
		
		return this.jobAdvertisementDao.findAll(sort);
	}

	@Override
	public List<JobAdvertisement> getByCompanyName(String companyName) {
		return this.jobAdvertisementDao.getByCompanyName(companyName);
	}

	@Override
	public void deleteAdvertisementById(int id) {
		this.jobAdvertisementDao.deleteById(id);
	}
	

}
