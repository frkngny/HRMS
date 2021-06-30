package com.daysixhwtwo.demo.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lombok brings getters and setters
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_advertisement")
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="job_position")
	private String jobPosition;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="open_positions")
	private int openPositions;
	
	@Column(name="deadline")
	private Date deadline;
	
	@Column(name="publish_date")
	private Date publishDate;

}
