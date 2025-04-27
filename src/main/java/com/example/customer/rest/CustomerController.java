package com.example.customer.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.dto.AdditionalCustomerDetailsDTO;
import com.example.customer.dto.CustomerDocumentDTO;
import com.example.customer.dto.getCustomerDetailsDTO;
import com.example.customer.dto.UpdateCustomerDetailsDTO;
import com.example.customer.entity.CustomerDetails;
import com.example.customer.service.CustomerService;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CustomerController.class);

	
	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ResponseEntity<String> addCustomer(@RequestBody CustomerDetails customerDetails) {
		LOGGER.info("CustomerController : PostMapping : addCustomer : Entry");
		String msg = customerService.addCustomer(customerDetails);
		LOGGER.info("CustomerController : PostMapping : addCustomer : Exit");
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@PostMapping(value = "/documents/{personalDocumentId}")
	public ResponseEntity<String> uploadDocuments(@ModelAttribute CustomerDocumentDTO customerDocumentDTO,
			@PathVariable Integer personalDocumentId) {
		LOGGER.info("CustomerController : PostMapping : uploadDocuments : Entry");
		String msg = customerService.uploadDocuments(customerDocumentDTO, personalDocumentId);
		LOGGER.info("CustomerController : PostMapping : uploadDocuments : Exit");
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@PostMapping(value = "/addAdditionalDetails/{customerId}")
	public ResponseEntity<String> addAdditionalCustomerDetails(
			@RequestBody @Valid AdditionalCustomerDetailsDTO additionalCustomerDetailsDTO,
			@PathVariable Integer customerId) {
		LOGGER.info("CustomerController : PostMapping : addAdditionalCustomerDetails : Entry");
		String msg = customerService.addAdditionalCustomerDetails(additionalCustomerDetailsDTO, customerId);
		LOGGER.info("CustomerController : PostMapping : addAdditionalCustomerDetails : Exit");
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);

	}

	@GetMapping(value = "/getCustomer/{customerId}")
	public ResponseEntity<getCustomerDetailsDTO> getCustomerDetails(@PathVariable Integer customerId) {

		LOGGER.info("CustomerController : GetMapping : getCustomerDetails : Entry");
		getCustomerDetailsDTO getCustomer = customerService.getCustomerDetails(customerId);
		LOGGER.info("CustomerController : GetMapping : getCustomerDetails : Exit");
		return new ResponseEntity<getCustomerDetailsDTO>(getCustomer, HttpStatus.OK);

	}

	@GetMapping(value = "/getAllCustomers")
	public ResponseEntity<List<CustomerDetails>> getAllCustomerDetails() {

		LOGGER.info("CustomerController : GetMapping : getAllCustomerDetails : Entry");
		List<CustomerDetails> getAllCustomers = customerService.getAllCustomerDetails();

		if (!getAllCustomers.isEmpty()) {
			LOGGER.info("CustomerController : GetMapping : getAllCustomerDetails : Exit");
			return new ResponseEntity<List<CustomerDetails>>(getAllCustomers, HttpStatus.OK);
		} else {
			LOGGER.info("CustomerController : GetMapping : getAllCustomerDetails : Exit");
			return new ResponseEntity<List<CustomerDetails>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/updateCustomerDetails/{customerId}")
	public ResponseEntity<String> updateCustomerDetails(@RequestBody UpdateCustomerDetailsDTO updateCustomerDetailsDTO,@PathVariable Integer customerId)
	{
		LOGGER.info("CustomerController : PutMapping : updateCustomerDetails : Entry");
		String msg=customerService.updateCustomerDetails(updateCustomerDetailsDTO,customerId);
		LOGGER.info("CustomerController : PutMapping : updateCustomerDetails : Exit");
		return new ResponseEntity<String>(msg, HttpStatus.OK);
  }
}
