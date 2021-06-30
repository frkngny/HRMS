package com.daysixhwtwo.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daysixhwtwo.demo.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>  {
	List<JobAdvertisement> getByCompanyName(String companyName);
}
