package com.example.customer.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CustomerDocumentDTO {

	
	private MultipartFile addressProof;
	
	private MultipartFile panCard;
	
	private MultipartFile adharCard;
	
	private MultipartFile incomeTax;
	
	private MultipartFile passportPhoto;
	
	private MultipartFile signature;
	
	private MultipartFile salarySlips;

}
