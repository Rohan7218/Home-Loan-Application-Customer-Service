package com.example.customer.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.dto.BankAccountDto;
import com.example.customer.entity.BankAccountDetails;
import com.example.customer.repository.CustomerBankAccountRepository;
import com.example.customer.service.CustomerBankAccountService;
@Service
public class CustomerBankAccountServiceImpl implements CustomerBankAccountService
{
	@Autowired
	private CustomerBankAccountRepository customerBankAccountRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public String addCustomerBankAccount(BankAccountDto bankAccountDto, Integer accountId)
	{
		if(customerBankAccountRepository.findById(accountId).isPresent())
		{
			BankAccountDetails bankAccountDetails = modelMapper.map(bankAccountDto, BankAccountDetails.class);
											bankAccountDetails.setAccountId(accountId);
			customerBankAccountRepository.save(bankAccountDetails);
			return "!!!...Bank Details Added SuccessFully...!!!";
		}
			return null;
	}
}

