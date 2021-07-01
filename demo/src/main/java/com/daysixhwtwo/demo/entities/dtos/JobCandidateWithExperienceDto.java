package com.daysixhwtwo.demo.entities.dtos;


import com.daysixhwtwo.demo.entities.concretes.CandidateExperience;
import com.daysixhwtwo.demo.entities.concretes.JobCandidate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobCandidateWithExperienceDto {
	private JobCandidate jobCandidate;
	private CandidateExperience candidateExperience;
}
