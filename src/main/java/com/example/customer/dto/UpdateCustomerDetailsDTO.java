package com.example.customer.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Data
public class UpdateCustomerDetailsDTO{
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;

	private LocalDate dateOfBirth;
	
	private Integer age;
	
	private String emailId;

	private Long contactNo;

	private String cityName;
		
	private Long alternateContactNumber;
	
	@Enumerated(EnumType.STRING)
	private CustomerMaritalStatus maritalStatus;

	
}
