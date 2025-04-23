package com.example.customer.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.entity.CibilDetails;
import com.example.customer.entity.CustomerDetails;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public String addCustomer(CustomerDetails customerDetails) 
	{								  
		 CibilDetails cibilDetails=new CibilDetails();					  
						   cibilDetails.setCibilEligibility(customerDetails.getCibilId().getCibilEligibility());
						   cibilDetails.setCibilScore(customerDetails.getCibilId().getCibilScore());
						   cibilDetails.setCibilRemark(customerDetails.getCibilId().getCibilRemark());
						   cibilDetails.setPanCardNo(customerDetails.getPanCardNo());
						   
		customerDetails.setCibilId(cibilDetails);
		 CustomerDetails customerDetailsSaved = customerRepository.save(customerDetails);
		 cibilDetails.setCustomerId(customerDetailsSaved.getCustomerId());
		 customerRepository.save(customerDetailsSaved);
		 
								  
		return "!!!!....Customer Saved SuccessFully....!!!!";
	}
}
