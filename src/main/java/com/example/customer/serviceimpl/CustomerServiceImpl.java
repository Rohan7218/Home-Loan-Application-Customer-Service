package com.example.customer.serviceimpl;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.customer.dto.CustomerDocumentDTO;
import com.example.customer.entity.AllPersonalDocs;
import com.example.customer.entity.CibilDetails;
import com.example.customer.entity.CustomerDetails;
import com.example.customer.repository.AllPersonalDocsRepository;
import com.example.customer.repository.CustomerRepository;
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
		 CibilDetails cibilDetails=new CibilDetails();					  
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
	
	
	
	
	
	
}
