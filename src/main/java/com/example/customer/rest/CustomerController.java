package com.example.customer.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.dto.AdditionalCustomerDetailsDTO;
import com.example.customer.dto.CustomerDocumentDTO;
import com.example.customer.dto.getCustomerDetailsDTO;
import com.example.customer.entity.CustomerDetails;
import com.example.customer.service.CustomerService;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ResponseEntity<String> addCustomer(@RequestBody CustomerDetails customerDetails) {
		String msg = customerService.addCustomer(customerDetails);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@PostMapping(value = "/documents/{personalDocumentId}")
	public ResponseEntity<String> uploadDocuments(@ModelAttribute CustomerDocumentDTO customerDocumentDTO,
			@PathVariable Integer personalDocumentId) {
		String msg = customerService.uploadDocuments(customerDocumentDTO, personalDocumentId);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@PostMapping(value = "/addAdditionalDetails/{customerId}")
	public ResponseEntity<String> addAdditionalCustomerDetails(
			@RequestBody @Valid AdditionalCustomerDetailsDTO additionalCustomerDetailsDTO,
			@PathVariable Integer customerId) {

		String msg = customerService.addAdditionalCustomerDetails(additionalCustomerDetailsDTO, customerId);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);

	}

	@GetMapping(value = "/getCustomer/{customerId}")
	public ResponseEntity<getCustomerDetailsDTO> getCustomerDetails(@PathVariable Integer customerId) {

		getCustomerDetailsDTO getCustomer = customerService.getCustomerDetails(customerId);
		return new ResponseEntity<getCustomerDetailsDTO>(getCustomer, HttpStatus.OK);

	}

	@GetMapping(value = "/getAllCustomers")
	public ResponseEntity<List<CustomerDetails>> getAllCustomerDetails() {

		List<CustomerDetails> getAllCustomers = customerService.getAllCustomerDetails();

		if (!getAllCustomers.isEmpty()) {
			return new ResponseEntity<List<CustomerDetails>>(getAllCustomers, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<CustomerDetails>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
