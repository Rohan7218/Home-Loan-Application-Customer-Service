package com.example.customer.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;


import com.example.customer.dto.CustomerDocumentDTO;

import com.example.customer.dto.AdditionalCustomerDetailsDTO;

import com.example.customer.entity.CustomerDetails;
import com.example.customer.service.CustomerService;
import com.google.common.net.MediaType;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ResponseEntity<String> addCustomer(@RequestBody CustomerDetails customerDetails) {
		String msg = customerService.addCustomer(customerDetails);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}


	@PostMapping(value = "/documents")
	public ResponseEntity<String> uploadDocuments(@ModelAttribute CustomerDocumentDTO customerDocumentDTO)
	{
		String msg=customerService.uploadDocuments(customerDocumentDTO);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}


	
	
	@PostMapping(value = "/addAdditionalDetails/{customerId}")
	public ResponseEntity<String> addAdditionalCustomerDetails(@RequestBody @Valid AdditionalCustomerDetailsDTO additionalCustomerDetailsDTO, @PathVariable Integer customerId){
		
		String msg = customerService. addAdditionalCustomerDetails(additionalCustomerDetailsDTO , customerId);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		
	}
	

}
