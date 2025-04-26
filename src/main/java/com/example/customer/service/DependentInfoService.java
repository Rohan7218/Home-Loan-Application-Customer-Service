package com.example.customer.service;

import com.example.customer.dto.DependentInfoDTO;

public interface DependentInfoService
{

	String addDependentInfo(DependentInfoDTO dependentInfoDTO, Integer customerId);

}
