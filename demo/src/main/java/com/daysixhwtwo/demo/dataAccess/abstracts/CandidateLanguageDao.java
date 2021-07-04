package com.daysixhwtwo.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daysixhwtwo.demo.entities.concretes.CandidateLanguage;

public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage, Integer>{
	List<CandidateLanguage> getByCandidateId(int candidateId);
}
