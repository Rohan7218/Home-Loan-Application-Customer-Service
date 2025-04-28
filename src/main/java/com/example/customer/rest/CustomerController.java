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
import com.example.customer.response.ApiResponse;
import com.example.customer.service.CustomerService;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CustomerController.class);

	
	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ResponseEntity<ApiResponse<String>> addCustomer(@RequestBody CustomerDetails customerDetails) {
		LOGGER.info("CustomerController : PostMapping : addCustomer : Entry");
		String msg = customerService.addCustomer(customerDetails);
		LOGGER.info("CustomerController : PostMapping : addCustomer : Exit");
		
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.CREATED);
	}

	@PostMapping(value = "/documents/{personalDocumentId}")
	public ResponseEntity<ApiResponse<String>> uploadDocuments(@ModelAttribute CustomerDocumentDTO customerDocumentDTO,
			@PathVariable Integer personalDocumentId) {
		LOGGER.info("CustomerController : PostMapping : uploadDocuments : Entry");
		String msg = customerService.uploadDocuments(customerDocumentDTO, personalDocumentId);
		
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		LOGGER.info("CustomerController : PostMapping : uploadDocuments : Exit");
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.CREATED);
	}

	@PostMapping(value = "/addAdditionalDetails/{customerId}")
	public ResponseEntity<ApiResponse<String>> addAdditionalCustomerDetails(
			@RequestBody @Valid AdditionalCustomerDetailsDTO additionalCustomerDetailsDTO,
			@PathVariable Integer customerId) {
		LOGGER.info("CustomerController : PostMapping : addAdditionalCustomerDetails : Entry");
		String msg = customerService.addAdditionalCustomerDetails(additionalCustomerDetailsDTO, customerId);
		
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		LOGGER.info("CustomerController : PostMapping : addAdditionalCustomerDetails : Exit");
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.CREATED);

	}

	@GetMapping(value = "/getCustomer/{customerId}")
	public ResponseEntity<ApiResponse<Object>> getCustomerDetails(@PathVariable Integer customerId) {

		LOGGER.info("CustomerController : GetMapping : getCustomerDetails : Entry");
		getCustomerDetailsDTO getCustomer = customerService.getCustomerDetails(customerId);
		ApiResponse<Object> apiResponse=new ApiResponse<Object>(getCustomer);
		LOGGER.info("CustomerController : GetMapping : getCustomerDetails : Exit");
		return new ResponseEntity<ApiResponse<Object>>(apiResponse, HttpStatus.OK);

	}

	@GetMapping(value = "/getAllCustomers")
	public ResponseEntity<ApiResponse<Object>> getAllCustomerDetails() {

		LOGGER.info("CustomerController : GetMapping : getAllCustomerDetails : Entry");
		List<CustomerDetails> getAllCustomers = customerService.getAllCustomerDetails();

		if (!getAllCustomers.isEmpty())
		{
			LOGGER.info("CustomerController : GetMapping : getAllCustomerDetails : Exit");
			ApiResponse<Object> apiResponse=new ApiResponse<Object>(getAllCustomers);
			return new ResponseEntity<ApiResponse<Object>>(apiResponse, HttpStatus.OK);
		} 
		else
		{
			LOGGER.info("CustomerController : GetMapping : getAllCustomerDetails : Exit");
			return new ResponseEntity<ApiResponse<Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/updateCustomerDetails/{customerId}")
	public ResponseEntity<ApiResponse<String>> updateCustomerDetails(@RequestBody UpdateCustomerDetailsDTO updateCustomerDetailsDTO,@PathVariable Integer customerId)
	{
		LOGGER.info("CustomerController : PutMapping : updateCustomerDetails : Entry");
		String msg=customerService.updateCustomerDetails(updateCustomerDetailsDTO,customerId);
		LOGGER.info("CustomerController : PutMapping : updateCustomerDetails : Exit");
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.OK);
  }
}
