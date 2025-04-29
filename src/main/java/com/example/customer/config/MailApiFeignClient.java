package com.example.customer.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.customer.dto.CustomerMailDto;

@FeignClient(name = "mail-service")
public interface MailApiFeignClient
{
	@PostMapping(value = "api/customer/mails")
	public ResponseEntity<String> customerMail(@RequestBody CustomerMailDto customerMailDto);
}
