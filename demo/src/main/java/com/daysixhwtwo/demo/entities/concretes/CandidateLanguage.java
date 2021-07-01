package com.daysixhwtwo.demo.entities.concretes;

import javax.validation.constraints.Max;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateLanguage {
	
	
	private String knownLanguages;
	
	@Max(value=5)
	private int languageLevel;
}
