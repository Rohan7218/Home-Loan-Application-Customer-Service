package com.example.customer.serviceimpl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.dto.BankAccountDto;
import com.example.customer.entity.BankAccountDetails;
import com.example.customer.repository.CustomerBankAccountRepository;
import com.example.customer.service.CustomerBankAccountService;
@Service
public class CustomerBankAccountServiceImpl implements CustomerBankAccountService
{
	private static final Logger LOGGER=LoggerFactory.getLogger(CustomerBankAccountServiceImpl.class);

	@Autowired
	private CustomerBankAccountRepository customerBankAccountRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public String addCustomerBankAccount(BankAccountDto bankAccountDto, Integer accountId)
	{
		if(customerBankAccountRepository.findById(accountId).isPresent())
		{
			LOGGER.debug("CustomerBankAccountServiceImpl : addCustomerBankAccount : Entry");
			BankAccountDetails bankAccountDetails = modelMapper.map(bankAccountDto, BankAccountDetails.class);
											bankAccountDetails.setAccountId(accountId);
			customerBankAccountRepository.save(bankAccountDetails);
			LOGGER.debug("CustomerBankAccountServiceImpl : addCustomerBankAccount : Exit");
			return "!!!...Bank Details Added SuccessFully...!!!";
		}
		LOGGER.debug("CustomerBankAccountServiceImpl : addCustomerBankAccount : Exit");
			return null;
	}
}

