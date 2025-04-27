package com.example.customer.service;



import java.util.List;

import com.example.customer.dto.AdditionalCustomerDetailsDTO;
import com.example.customer.dto.CustomerDocumentDTO;
import com.example.customer.dto.UpdateCustomerDetailsDTO;
import com.example.customer.dto.getCustomerDetailsDTO;
import com.example.customer.entity.CustomerDetails;

public interface CustomerService {
	String addCustomer(CustomerDetails customerDetails);

	String uploadDocuments(CustomerDocumentDTO customerDocumentDTO, Integer personalDocumentId);


	String addAdditionalCustomerDetails(AdditionalCustomerDetailsDTO additionalCustomerDetailsDTO , Integer customerId);



	String updateCustomerDetails(UpdateCustomerDetailsDTO updateCustomerDetailsDTO, Integer customerId);

	



	getCustomerDetailsDTO getCustomerDetails(Integer customerId);

	List<CustomerDetails> getAllCustomerDetails();


}
