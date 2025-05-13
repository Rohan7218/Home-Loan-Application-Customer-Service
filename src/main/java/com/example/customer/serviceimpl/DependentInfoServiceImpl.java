package com.example.customer.serviceimpl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOGGER=LoggerFactory.getLogger(DependentInfoServiceImpl.class);
	
	@Autowired
	private DependentInfoRepository dependentInfoRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public String addDependentInfo(DependentInfoDTO dependentInfoDTO, Integer customerId)
	{
		LOGGER.debug("DependentInfoServiceImpl : addDependentInfo : Entry");
			CustomerDetails customerDetails = customerRepository.findById(customerId).get();

			DependentInfo dependentInfo = modelMapper.map(dependentInfoDTO, DependentInfo.class);
									 dependentInfo.setCustomerId(customerDetails);
			dependentInfoRepository.save(dependentInfo);
			
			LOGGER.debug("DependentInfoServiceImpl : addDependentInfo : Exit");
			return "!!!!....Dependent Info Saved SuccessFully....!!!!";
			
			
		}


	
	@Override
	public String updateDepedentInfoDetails(UpdateDepedentInfoDTO updateDepedentInfoDTO, Integer dependentInfoId) {
		
		if(dependentInfoRepository.existsById(dependentInfoId))
		{
			LOGGER.debug("DependentInfoServiceImpl : updateDepedentInfoDetails : Entry");
			DependentInfo existDependentInfo = dependentInfoRepository.findById(dependentInfoId).get();
			
			if(updateDepedentInfoDTO.getDependentMember()!=null)
			{
				existDependentInfo.setDependentMember(updateDepedentInfoDTO.getDependentMember());
			}
			
			if(updateDepedentInfoDTO.getFamilyIncome()!=null)
			{
				existDependentInfo.setFamilyIncome(updateDepedentInfoDTO.getFamilyIncome());
			}
			
			if(updateDepedentInfoDTO.getMaritalStatus()!=null)
			{
				existDependentInfo.setMaritalStatus(updateDepedentInfoDTO.getMaritalStatus());
			}
			
			if(updateDepedentInfoDTO.getNoOfChild()!=null)
			{
				existDependentInfo.setNoOfChild(updateDepedentInfoDTO.getNoOfChild());
			}
			
			if(updateDepedentInfoDTO.getNoOfFamilyMember()!=null)
			{
				existDependentInfo.setNoOfFamilyMember(updateDepedentInfoDTO.getNoOfFamilyMember());
			}
			
			dependentInfoRepository.save(existDependentInfo);
			
			LOGGER.debug("DependentInfoServiceImpl : updateDepedentInfoDetails : Exit");
			return "Depedent Info of Customer updated Suceesfully";
			
		}
		LOGGER.debug("DependentInfoServiceImpl : updateDepedentInfoDetails : Exit");
		return null;
	}

		
		
	}
