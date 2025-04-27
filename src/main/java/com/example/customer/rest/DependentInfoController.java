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

import com.example.customer.dto.DependentInfoDTO;


import com.example.customer.dto.UpdateDepedentInfoDTO;

import com.example.customer.service.DependentInfoService;

@RestController
@RequestMapping(value = "/api/customers")
public class DependentInfoController 
{
	private static final Logger LOGGER=LoggerFactory.getLogger(DependentInfoController.class);

	
	@Autowired
	private DependentInfoService dependentInfoService;
	
	@PostMapping(value = "/dependents/{customerId}")
	public ResponseEntity<String> addDependentInfo(@RequestBody DependentInfoDTO dependentInfoDTO, @PathVariable Integer customerId)
	{
		LOGGER.info("DependentInfoController : PostMapping : addDependentInfo : Entry");
		String msg=dependentInfoService.addDependentInfo(dependentInfoDTO, customerId);
		LOGGER.info("DependentInfoController : PostMapping : addDependentInfo : Exit");

		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/dependents/{dependentInfoId}")
	public ResponseEntity<String> updateDepedentInfoDetails(@RequestBody UpdateDepedentInfoDTO updateDepedentInfoDTO,@PathVariable Integer dependentInfoId) 
	{
		LOGGER.info("DependentInfoController : PutMapping : updateDepedentInfoDetails : Entry");
		String msg=dependentInfoService.updateDepedentInfoDetails(updateDepedentInfoDTO,dependentInfoId);
		LOGGER.info("DependentInfoController : PutMapping : updateDepedentInfoDetails : Exit");
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
