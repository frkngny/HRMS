package com.daysixhwtwo.demo.entities.concretes;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lombok brings getters and setters
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String firstName;
	
	@Column(name="surname")
	private String lastName;
	
	@Email
	@NotNull
	@NotBlank
	@Column(name="email")
	private String email;
	
	@NotNull
	@NotBlank
	@Column(name="password")
	private String password;
	
	
}
