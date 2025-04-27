package com.example.customer.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.dto.DependentInfoDTO;
import com.example.customer.dto.UpdateDepedentInfoDTO;
import com.example.customer.entity.CustomerDetails;
import com.example.customer.entity.DependentInfo;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.repository.DependentInfoRepository;
import com.example.customer.service.DependentInfoService;
@Service
public class DependentInfoServiceImpl implements DependentInfoService
{
	@Autowired
	private DependentInfoRepository dependentInfoRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public String addDependentInfo(DependentInfoDTO dependentInfoDTO, Integer customerId)
	{
			CustomerDetails customerDetails = customerRepository.findById(customerId).get();

			DependentInfo dependentInfo = modelMapper.map(dependentInfoDTO, DependentInfo.class);
									 dependentInfo.setCustomerId(customerDetails);
			dependentInfoRepository.save(dependentInfo);
			
			return "!!!!....Dependent Info Saved SuccessFully....!!!!";
			
			
		}

		
	
	@Override
	public String updateDepedentInfoDetails(UpdateDepedentInfoDTO updateDepedentInfoDTO, Integer dependentInfoId) {
		
		
		return null;
	}

		
		
	}
