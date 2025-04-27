package com.example.customer.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.dto.AdditionalCustomerDetailsDTO;
import com.example.customer.dto.CustomerDocumentDTO;
import com.example.customer.dto.CustomerStatusEnum;
import com.example.customer.dto.UpdateCustomerDetailsDTO;
import com.example.customer.dto.getCustomerDetailsDTO;
import com.example.customer.entity.AllPersonalDocs;
import com.example.customer.entity.BankAccountDetails;
import com.example.customer.entity.CibilDetails;
import com.example.customer.entity.CustomerAddress;
import com.example.customer.entity.CustomerDetails;
import com.example.customer.exceptionhandling.NoCustomerFoundException;
import com.example.customer.exceptionhandling.NoCustomersFoundException;
import com.example.customer.repository.AllPersonalDocsRepository;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AllPersonalDocsRepository allPersonalDocsRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addCustomer(CustomerDetails customerDetails) {
		
		LOGGER.debug("CustomerServiceImpl : addCustomer : Entry");
		CibilDetails cibilDetails = new CibilDetails();
		cibilDetails.setCibilEligibility(customerDetails.getCibilId().getCibilEligibility());
		cibilDetails.setCibilScore(customerDetails.getCibilId().getCibilScore());
		cibilDetails.setCibilRemark(customerDetails.getCibilId().getCibilRemark());
		cibilDetails.setPanCardNo(customerDetails.getPanCardNo());

		customerDetails.setCibilId(cibilDetails);

		CustomerDetails customerDetailsSaved = customerRepository.save(customerDetails);
								  customerDetailsSaved.setCustomerStatus(CustomerStatusEnum.INPROCESS);
								  cibilDetails.setCustomerId(customerDetailsSaved.getCustomerId());
								  
		customerRepository.save(customerDetailsSaved);

		LOGGER.debug("CustomerServiceImpl : addCustomer : Exit");
		return "!!!!....Customer Saved SuccessFully....!!!!";
	}

	@Override
	public String uploadDocuments(CustomerDocumentDTO customerDocumentDTO, Integer personalDocumentId) {
		if (allPersonalDocsRepository.findById(personalDocumentId).isPresent()) 
		{
			LOGGER.debug("CustomerServiceImpl : uploadDocuments : Entry");
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

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LOGGER.debug("CustomerServiceImpl : uploadDocuments : Exit");
			return "Document Upload Succesfully";
		}
		LOGGER.debug("CustomerServiceImpl : uploadDocuments : Exit");
		return null;

	}

	@Override
	public String addAdditionalCustomerDetails(AdditionalCustomerDetailsDTO additionalCustomerDetailsDTO,
			Integer customerId) {

		if (customerRepository.findById(customerId).isPresent())
		{
			LOGGER.debug("CustomerServiceImpl : addAdditionalCustomerDetails : Entry");
			CustomerAddress customerAddress = new CustomerAddress();
			AllPersonalDocs allPersonalDocs = new AllPersonalDocs();
			BankAccountDetails bankAccountDetails = new BankAccountDetails();

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
			customerDetails.setAccountId(bankAccountDetails);

			customerRepository.save(customerDetails);
			LOGGER.debug("CustomerServiceImpl : addAdditionalCustomerDetails : Exit");
			return "Additional Customer Details Added Successfully";
		}
		LOGGER.debug("CustomerServiceImpl : addAdditionalCustomerDetails : Exit");
		return "Customer Id Not Exist given ID " + customerId;
	}

	@Override
	public getCustomerDetailsDTO getCustomerDetails(Integer customerId) {

		if (customerRepository.findById(customerId).isPresent()) 
		{
			LOGGER.debug("CustomerServiceImpl : getCustomerDetails : Entry");
			CustomerDetails customerDetails = customerRepository.findById(customerId).get();
			getCustomerDetailsDTO getCustomer = modelMapper.map(customerDetails, getCustomerDetailsDTO.class);
			LOGGER.debug("CustomerServiceImpl : getCustomerDetails : Exit");
			return getCustomer;
		}else {
			LOGGER.debug("CustomerServiceImpl : getCustomerDetails : Exit");
			 throw new NoCustomerFoundException("!!!!....For Given Customer Id Record Not Found....!!!!");
		}
	}
	
	@Override
	public List<CustomerDetails> getAllCustomerDetails() {
		
		LOGGER.debug("CustomerServiceImpl : getAllCustomerDetails : Entry");
			List<CustomerDetails> getAllCustomerDetails = customerRepository.findAll();
			if(!getAllCustomerDetails.isEmpty()) {
				LOGGER.debug("CustomerServiceImpl : getAllCustomerDetails : Exit");
				return getAllCustomerDetails;
			}else {
				LOGGER.debug("CustomerServiceImpl : getAllCustomerDetails : Exit");
				throw new NoCustomersFoundException("!!!!....No Customers Are Available....!!!!");
			}
	
	}
	
	
	@Override
	public String updateCustomerDetails(UpdateCustomerDetailsDTO updateCustomerDetailsDTO, Integer customerId) {
		
		if(customerRepository.existsById(customerId))
		{
			LOGGER.debug("CustomerServiceImpl : updateCustomerDetails : Entry");
			CustomerDetails existCustomerDetails = customerRepository.findById(customerId).get();
			
			if(updateCustomerDetailsDTO.getFirstName()!=null)
			{
				existCustomerDetails.setFirstName(updateCustomerDetailsDTO.getFirstName());
			}
			if(updateCustomerDetailsDTO.getMiddleName()!=null)
			{
				existCustomerDetails.setMiddleName(updateCustomerDetailsDTO.getMiddleName());;
			}
			
			if(updateCustomerDetailsDTO.getLastName()!=null)
			{
				existCustomerDetails.setLastName(updateCustomerDetailsDTO.getLastName());
			}
			
			if(updateCustomerDetailsDTO.getContactNo()!=null)
			{
				existCustomerDetails.setContactNo(updateCustomerDetailsDTO.getContactNo());
			}
			if(updateCustomerDetailsDTO.getAlternateContactNumber()!=null)
			{
				existCustomerDetails.setAlternateContactNumber(updateCustomerDetailsDTO.getAlternateContactNumber());
			}
			if(updateCustomerDetailsDTO.getEmailId()!=null)
			{
				existCustomerDetails.setEmailId(updateCustomerDetailsDTO.getEmailId());
			}
			if(updateCustomerDetailsDTO.getMaritalStatus()!=null)
			{
				existCustomerDetails.setMaritalStatus(updateCustomerDetailsDTO.getMaritalStatus());
			}
			if(updateCustomerDetailsDTO.getDateOfBirth()!=null)
			{
				existCustomerDetails.setDateOfBirth(updateCustomerDetailsDTO.getDateOfBirth());
			}
			if(updateCustomerDetailsDTO.getAge()!=null)
			{
				existCustomerDetails.setAge(updateCustomerDetailsDTO.getAge());
			}
			
			if(updateCustomerDetailsDTO.getCityName()!=null)
			{
				existCustomerDetails.setCityName(updateCustomerDetailsDTO.getCityName());
			}
			
			
			customerRepository.save(existCustomerDetails);
			LOGGER.debug("CustomerServiceImpl : updateCustomerDetails : Exit");
			return "Customer Details Updated Succesfully for that CustomerId"+customerId;
		}
		LOGGER.debug("CustomerServiceImpl : updateCustomerDetails : Exit");
		return "Record Not Found for this customerID"+customerId;
	}
	
	
	
	
	
	
	
	

}
