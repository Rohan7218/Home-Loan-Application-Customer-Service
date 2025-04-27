package com.example.customer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.dto.DependentInfoDTO;
import com.example.customer.service.DependentInfoService;

@RestController
@RequestMapping(value = "/api/customers")
public class DependentInfoController 
{
	@Autowired
	private DependentInfoService dependentInfoService;
	
	@PostMapping(value = "/dependents/{customerId}")
	public ResponseEntity<String> addDependentInfo(@RequestBody DependentInfoDTO dependentInfoDTO, @PathVariable Integer customerId)
	{
		String msg=dependentInfoService.addDependentInfo(dependentInfoDTO, customerId);
		
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
}
