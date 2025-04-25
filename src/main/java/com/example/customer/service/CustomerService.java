package com.example.customer.service;

import com.example.customer.dto.CustomerDocumentDTO;
import com.example.customer.entity.CustomerDetails;

public interface CustomerService {
	String addCustomer(CustomerDetails customerDetails);

	String uploadDocuments(CustomerDocumentDTO customerDocumentDTO);

	

	

}
