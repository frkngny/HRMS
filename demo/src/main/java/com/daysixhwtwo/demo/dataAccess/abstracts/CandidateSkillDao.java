package com.daysixhwtwo.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daysixhwtwo.demo.entities.concretes.CandidateSkill;

public interface CandidateSkillDao extends JpaRepository<CandidateSkill, Integer> {

}
