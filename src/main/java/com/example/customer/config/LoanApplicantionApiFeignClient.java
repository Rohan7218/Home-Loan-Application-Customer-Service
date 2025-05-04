package com.example.customer.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.customer.dto.LoanApplicantionCustomerIdDTO;
import com.example.customer.response.ApiResponse;

@FeignClient(name = "loan-application-service")
public interface LoanApplicantionApiFeignClient 
{	
	@PostMapping(value = "/api/applicant/applicants")
	public ResponseEntity<ApiResponse<String>> addApplicantDetailsService(@RequestBody LoanApplicantionCustomerIdDTO loanApplicantionCustomerIdDTO);
}
