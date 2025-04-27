package com.example.customer.rest;

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
import com.example.customer.service.AddressService;

@RestController
@RequestMapping(value = "/api/customers")
public class AddressController {
	
	@Autowired
	private AddressService addressService; 
	

	@PostMapping(value = "/address/{addressId}")
	public ResponseEntity<String>addAddress(@RequestBody AddressDTO addressDTO, @PathVariable Integer addressId)
	{
		String msg=addressService.addAddress(addressDTO, addressId);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED );
	}
	
	@PutMapping(value = "/address/{localAddressId}")
	public ResponseEntity<String> updateLocalAddress(@RequestBody UpdateLocalAddressDTO updateLocalAddressDTO, @PathVariable Integer localAddressId)
	{
		String msg=addressService.updateLocalAddress(updateLocalAddressDTO, localAddressId);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
}
