package com.example.customer.service;

import com.example.customer.dto.BankAccountDto;

public interface CustomerBankAccountService
{

	String addCustomerBankAccount(BankAccountDto bankAccountDto, Integer accountId);

}
