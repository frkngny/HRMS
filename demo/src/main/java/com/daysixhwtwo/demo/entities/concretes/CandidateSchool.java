package com.daysixhwtwo.demo.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidate_schools")
public class CandidateSchool {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="candidate_id")
	private int candidateId;
	
	@Column(name="school_names")
	private String schoolName;
	
	@Column(name="department")
	private String department;
	
	@Column(name="start_year")
	private int schoolStartYear;
	
	@Column(name="end_year")
	private int schoolEndYear;
	
	@Column(name="graduated")
	private boolean graduated;
}
