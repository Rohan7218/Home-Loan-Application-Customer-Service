package com.example.customer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.dto.BankAccountDto;
import com.example.customer.service.CustomerBankAccountService;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerBankAccountController 
{
	@Autowired
	private CustomerBankAccountService customerBankAccountService;
	
	@PostMapping(value = "/{accountId}")
	public ResponseEntity<String> addCustomerBankAccount(@RequestBody BankAccountDto bankAccountDto,@PathVariable Integer  accountId)
	{
		String msg=customerBankAccountService.addCustomerBankAccount(bankAccountDto, accountId);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	
}
