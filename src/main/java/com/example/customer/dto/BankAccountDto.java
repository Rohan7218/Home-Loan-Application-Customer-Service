package com.example.customer.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Data
public class BankAccountDto 
{
	@Enumerated(EnumType.STRING)
	private AccountTypeEnum accountType;

	private String accountHolderName;
	
	@Enumerated(EnumType.STRING)
	private accountStatusEnum accountStatus;
	
	private Long accountNumber;
}
