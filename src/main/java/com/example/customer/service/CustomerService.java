package com.example.customer.service;

import com.example.customer.dto.AdditionalCustomerDetailsDTO;
import com.example.customer.entity.CustomerDetails;

public interface CustomerService 
{
	String addCustomer(CustomerDetails customerDetails);

	String addAdditionalCustomerDetails(AdditionalCustomerDetailsDTO additionalCustomerDetailsDTO , Integer customerId);

}
