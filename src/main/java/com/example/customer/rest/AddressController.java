package com.example.customer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.dto.AddressDTO;
import com.example.customer.service.AddressService;

@RestController
@RequestMapping(value = "/api/customer")
public class AddressController {
	
	@Autowired
	private AddressService addressService; 
	

	@PostMapping(value = "/address")
	public ResponseEntity<String>addAddress(@RequestBody AddressDTO addressDTO)
	{
		String msg=addressService.addAddress(addressDTO);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED );
	}
	
}
