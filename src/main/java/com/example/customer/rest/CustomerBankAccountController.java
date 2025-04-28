package com.example.customer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.dto.BankAccountDto;
import com.example.customer.response.ApiResponse;
import com.example.customer.service.CustomerBankAccountService;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerBankAccountController 
{
	private static final Logger LOGGER=LoggerFactory.getLogger(CustomerBankAccountController.class);

	
	@Autowired
	private CustomerBankAccountService customerBankAccountService;
	
	@PostMapping(value = "/{accountId}")
	public ResponseEntity<ApiResponse<String>> addCustomerBankAccount(@RequestBody BankAccountDto bankAccountDto,@PathVariable Integer  accountId)
	{
		LOGGER.info("CustomerBankAccountController : PostMapping : addCustomerBankAccount : Entry");
		String msg=customerBankAccountService.addCustomerBankAccount(bankAccountDto, accountId);
		LOGGER.info("CustomerBankAccountController : PostMapping : addCustomerBankAccount : Exit");
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.CREATED);
	}
	
	
}
