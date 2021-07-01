package com.daysixhwtwo.demo.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidate_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "candidates"})
public class CandidateExperience {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="candidate_id")
	private int candidateId;
	
	@Column(name="worked_company_name")
	private String workedCompanyName;
	
	@Column(name="worked_position")
	private String workedPosition;
	
	@Column(name="start_year")
	private int workStartYear;
	
	@Column(name="end_year")
	private int workEndYear;
	
	@ManyToOne
	@JoinColumn(name="job_candidate_id")
	private JobCandidate candidates;

}
