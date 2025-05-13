package com.example.customer.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Data
public class CustomerStatusDTO {

	@Enumerated(EnumType.STRING)
	private CustomerStatusEnum customerStatus;
	
	
}
