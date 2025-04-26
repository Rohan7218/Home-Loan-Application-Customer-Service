package com.example.customer.serviceimpl;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.dto.AdditionalCustomerDetailsDTO;
import com.example.customer.dto.CustomerDocumentDTO;
import com.example.customer.entity.AllPersonalDocs;
import com.example.customer.entity.CibilDetails;
import com.example.customer.entity.CustomerAddress;
import com.example.customer.entity.CustomerDetails;
import com.example.customer.entity.DependentInfo;
import com.example.customer.repository.AllPersonalDocsRepository;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.repository.DependentInfoRepository;
import com.example.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService 
{
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AllPersonalDocsRepository allPersonalDocsRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addCustomer(CustomerDetails customerDetails)
	{
		CibilDetails cibilDetails = new CibilDetails();
		cibilDetails.setCibilEligibility(customerDetails.getCibilId().getCibilEligibility());
		cibilDetails.setCibilScore(customerDetails.getCibilId().getCibilScore());
		cibilDetails.setCibilRemark(customerDetails.getCibilId().getCibilRemark());
		cibilDetails.setPanCardNo(customerDetails.getPanCardNo());

		customerDetails.setCibilId(cibilDetails);

		CustomerDetails customerDetailsSaved = customerRepository.save(customerDetails);
		cibilDetails.setCustomerId(customerDetailsSaved.getCustomerId());
		customerRepository.save(customerDetailsSaved);

		return "!!!!....Customer Saved SuccessFully....!!!!";
	}

	
	
	@Override
	public String uploadDocuments(CustomerDocumentDTO customerDocumentDTO, Integer personalDocumentId) 
	{
		if(allPersonalDocsRepository.findById(personalDocumentId).isPresent())
		{
		AllPersonalDocs allPersonalDocs = modelMapper.map(customerDocumentDTO, AllPersonalDocs.class);
								allPersonalDocs.setPersonalDocumentId(personalDocumentId);
		try {
				allPersonalDocs.setAddressProof(customerDocumentDTO.getAddressProof().getBytes());
				allPersonalDocs.setAdharCard(customerDocumentDTO.getAdharCard().getBytes());
				allPersonalDocs.setIncomeTax(customerDocumentDTO.getIncomeTax().getBytes());
				allPersonalDocs.setPanCard(customerDocumentDTO.getPanCard().getBytes());
				allPersonalDocs.setPassportPhoto(customerDocumentDTO.getPassportPhoto().getBytes());
				allPersonalDocs.setSalarySlips(customerDocumentDTO.getSalarySlips().getBytes());
				allPersonalDocs.setSignature(customerDocumentDTO.getSignature().getBytes());
			
				allPersonalDocsRepository.save(allPersonalDocs);
				
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return "Document Upload Succesfully";
		}
			return null;
		
		
	}

	@Override
	public String addAdditionalCustomerDetails(AdditionalCustomerDetailsDTO additionalCustomerDetailsDTO,
			Integer customerId) {

		if (customerRepository.findById(customerId).isPresent()) 
		{
			CustomerAddress customerAddress=new CustomerAddress();
			AllPersonalDocs allPersonalDocs=new AllPersonalDocs();
			
			CustomerDetails customerDetails = customerRepository.findById(customerId).get();
									  customerDetails.setAadharNo(additionalCustomerDetailsDTO.getAadharNo());
									  customerDetails.setAge(additionalCustomerDetailsDTO.getAge());
									  long altContact = Long.parseLong(additionalCustomerDetailsDTO.getAlternateContactNumber());
									    customerDetails.setAlternateContactNumber(altContact);
									  customerDetails.setDateOfBirth(additionalCustomerDetailsDTO.getDateOfBirth());
									  customerDetails.setDrivingLicenseNo(additionalCustomerDetailsDTO.getDrivingLicenseNo());
									  customerDetails.setExistingCustomer(additionalCustomerDetailsDTO.getExistingCustomer());
									  customerDetails.setGender(additionalCustomerDetailsDTO.getGender());
									  customerDetails.setMaritalStatus(additionalCustomerDetailsDTO.getMaritalStatus());
									  customerDetails.setPassportNo(additionalCustomerDetailsDTO.getPassportNo());
									  customerDetails.setVoterIdNo(additionalCustomerDetailsDTO.getVoterIdNo());
									  customerDetails.setCustomerAddressId(customerAddress);
									  customerDetails.setPersonalDocumentId(allPersonalDocs);
			
									  customerRepository.save(customerDetails);
									  
			return "Additional Customer Details Added Successfully";
		}
		return "Customer Id Not Exist given ID " + customerId  ;
	}

}
