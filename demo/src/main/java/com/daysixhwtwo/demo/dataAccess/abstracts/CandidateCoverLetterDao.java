package com.daysixhwtwo.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daysixhwtwo.demo.entities.concretes.CandidateCoverLetter;

public interface CandidateCoverLetterDao extends JpaRepository<CandidateCoverLetter, Integer> {

}
