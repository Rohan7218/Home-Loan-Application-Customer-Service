package com.example.customer.dto;

import com.example.customer.entity.CustomerMailParameterDto;

import lombok.Data;

@Data
public class CustomerMailDto 
{
	private String to;
	private  String subject;
	private String fileName;
	private CustomerMailParameterDto customerMailParameterDto;
	
}
