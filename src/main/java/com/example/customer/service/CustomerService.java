package com.example.customer.service;


import com.example.customer.dto.CustomerDocumentDTO;

import com.example.customer.dto.AdditionalCustomerDetailsDTO;

import com.example.customer.entity.CustomerDetails;

public interface CustomerService {
	String addCustomer(CustomerDetails customerDetails);


	String uploadDocuments(CustomerDocumentDTO customerDocumentDTO);

	

	
	String addAdditionalCustomerDetails(AdditionalCustomerDetailsDTO additionalCustomerDetailsDTO , Integer customerId);


}
