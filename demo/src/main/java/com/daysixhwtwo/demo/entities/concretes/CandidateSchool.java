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
@Table(name="candidate_schools")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "candidates"})
public class CandidateSchool {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="candidate_id")
	private int candidateId;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="department")
	private String department;
	
	@Column(name="start_year")
	private int schoolStartYear;
	
	@Column(name="end_year")
	private int schoolEndYear;
	
	@Column(name="graduated")
	private boolean graduated;
	
	@ManyToOne
	@JoinColumn(name="job_candidate_id")
	private JobCandidate candidates;
}
