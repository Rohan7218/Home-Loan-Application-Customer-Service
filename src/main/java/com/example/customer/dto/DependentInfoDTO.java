package com.example.customer.dto;

import lombok.Data;

@Data
public class DependentInfoDTO 
{
	private Integer noOfFamilyMember;
	
	private Integer noOfChild;
	
	private String maritalStatus;
	
	private String dependentMember;
	
	private Double familyIncome;
}
