package com.example.customer.serviceimpl;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.example.customer.dto.CustomerDocumentDTO;
import com.example.customer.entity.AllPersonalDocs;

import com.example.customer.dto.AdditionalCustomerDetailsDTO;

import com.example.customer.entity.CibilDetails;
import com.example.customer.entity.CustomerDetails;
import com.example.customer.repository.AllPersonalDocsRepository;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AllPersonalDocsRepository allPersonalDocsRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addCustomer(CustomerDetails customerDetails) {
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
	public String uploadDocuments(CustomerDocumentDTO customerDocumentDTO) {
		AllPersonalDocs allPersonalDocs = modelMapper.map(customerDocumentDTO, AllPersonalDocs.class);
		try {
				allPersonalDocs.setAddressProof(customerDocumentDTO.getAddressProof().getBytes());
				allPersonalDocs.setAdharCard(customerDocumentDTO.getAdharCard().getBytes());
				allPersonalDocs.setIncomeTax(customerDocumentDTO.getIncomeTax().getBytes());
				allPersonalDocs.setPanCard(customerDocumentDTO.getPanCard().getBytes());
				allPersonalDocs.setPassportPhoto(customerDocumentDTO.getPassportPhoto().getBytes());
				allPersonalDocs.setSalarySlips(customerDocumentDTO.getSalarySlips().getBytes());
				allPersonalDocs.setSignature(customerDocumentDTO.getSignature().getBytes());
			
				allPersonalDocsRepository.save(allPersonalDocs);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Document Upload Succesfully";
	}
	
	
	
	
	

	@Override
	public String addAdditionalCustomerDetails(AdditionalCustomerDetailsDTO additionalCustomerDetailsDTO,
			Integer customerId) {

		if (customerRepository.findById(customerId).isPresent()) 
		{
			CustomerDetails customerDetails2 = customerRepository.findById(customerId).get();
									  customerDetails2.setAadharNo(additionalCustomerDetailsDTO.getAadharNo());
									  customerDetails2.setAge(additionalCustomerDetailsDTO.getAge());
									  long altContact = Long.parseLong(additionalCustomerDetailsDTO.getAlternateContactNumber());
									    customerDetails2.setAlternateContactNumber(altContact);
									  customerDetails2.setDateOfBirth(additionalCustomerDetailsDTO.getDateOfBirth());
									  customerDetails2.setDrivingLicenseNo(additionalCustomerDetailsDTO.getDrivingLicenseNo());
									  customerDetails2.setExistingCustomer(additionalCustomerDetailsDTO.getExistingCustomer());
									  customerDetails2.setGender(additionalCustomerDetailsDTO.getGender());
									  customerDetails2.setMaritalStatus(additionalCustomerDetailsDTO.getMaritalStatus());
									  customerDetails2.setPassportNo(additionalCustomerDetailsDTO.getPassportNo());
									  customerDetails2.setVoterIdNo(additionalCustomerDetailsDTO.getVoterIdNo());
			
									  customerRepository.save(customerDetails2);
									  
			return "Additional Customer Details Added Successfully";
		}
		return "Customer Id Not Exist given ID " + customerId  ;
	}

}
