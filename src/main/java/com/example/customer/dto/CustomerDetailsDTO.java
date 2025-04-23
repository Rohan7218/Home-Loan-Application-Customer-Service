package com.example.customer.dto;

import javax.persistence.Column;

import lombok.Data;

@Data
public class CustomerDetailsDTO
{
	private String firstName;
	
	private String lastName;

	private String emailId;

	private Long contactNo;

	private String panCardNo;

	private String cityName;
		
	private Integer cibilScore;
	
	private String cibilEligibility;
	
	private String cibilRemark;
	
	private Integer enquiryId;
	
}
