package com.example.customer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.dto.AddressDTO;
import com.example.customer.dto.UpdateLocalAddressDTO;
import com.example.customer.response.ApiResponse;
import com.example.customer.service.AddressService;

@RestController
@RequestMapping(value = "/api/customers")
public class AddressController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(AddressController.class);

	
	@Autowired
	private AddressService addressService; 
	

	@PostMapping(value = "/address/{addressId}")
	public ResponseEntity<ApiResponse<String>>addAddress(@RequestBody AddressDTO addressDTO, @PathVariable Integer addressId)
	{
		LOGGER.info("AddressController : PostMapping : addAddress : Entry");
		String msg=addressService.addAddress(addressDTO, addressId);
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		LOGGER.info("AddressController : PostMapping : addAddress : Exit");
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.CREATED );
	}
	
	@PutMapping(value = "/address/{localAddressId}")
	public ResponseEntity<ApiResponse<String>> updateLocalAddress(@RequestBody UpdateLocalAddressDTO updateLocalAddressDTO, @PathVariable Integer localAddressId)
	{
		LOGGER.info("AddressController : PutMapping : updateLocalAddress : Entry");
		String msg=addressService.updateLocalAddress(updateLocalAddressDTO, localAddressId);
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		LOGGER.info("AddressController : PutMapping : updateLocalAddress : Exit");
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.OK);
	}
	
}
