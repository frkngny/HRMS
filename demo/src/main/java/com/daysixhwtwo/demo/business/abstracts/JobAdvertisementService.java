package com.daysixhwtwo.demo.business.abstracts;

import java.util.List;

import com.daysixhwtwo.demo.entities.concretes.JobAdvertisement;


public interface JobAdvertisementService {
	List<JobAdvertisement> getAds();
	void addOpenPosition(JobAdvertisement jobAdvertisement);
	List<JobAdvertisement> getAdsSortedByDate(String order);
	List<JobAdvertisement> getByCompanyName(String companyName);
	void deleteAdvertisementById(int id);
}
