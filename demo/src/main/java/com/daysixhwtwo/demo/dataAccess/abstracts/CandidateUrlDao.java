package com.daysixhwtwo.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daysixhwtwo.demo.entities.concretes.CandidateUrl;

public interface CandidateUrlDao extends JpaRepository<CandidateUrl, Integer>{

}
