package com.intercorp.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;	
	
	@Column(length = 30, nullable = false)
	private String Name;
	
	@Column(length = 50, nullable = false)
	private String Lastname;
	
	@Column(nullable = false)
	private int Age;
	
	@Column(nullable = false)
	private LocalDate Birthdate;
	
}
