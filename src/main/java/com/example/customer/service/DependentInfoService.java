package com.example.customer.service;

import com.example.customer.dto.DependentInfoDTO;
import com.example.customer.dto.UpdateDepedentInfoDTO;

public interface DependentInfoService
{

	String addDependentInfo(DependentInfoDTO dependentInfoDTO, Integer customerId);

	String updateDepedentInfoDetails(UpdateDepedentInfoDTO updateDepedentInfoDTO, Integer dependentInfoId);

}
