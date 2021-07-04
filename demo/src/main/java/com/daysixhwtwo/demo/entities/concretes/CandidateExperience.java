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
@Table(name="candidate_experiences")
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
	

}
