package com.example.customer.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.dto.AddressDTO;
import com.example.customer.entity.CustomerAddress;
import com.example.customer.entity.LocalAddress;
import com.example.customer.entity.PermanentAddress;
import com.example.customer.repository.CustomerAddressRepository;
import com.example.customer.repository.LocalAddressRepository;
import com.example.customer.repository.PermanentAddressRepository;
import com.example.customer.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private LocalAddressRepository localAddressRepository;
	
	@Autowired
	private PermanentAddressRepository permanentAddressRepository;
	
	@Autowired
	private CustomerAddressRepository customerAddressRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public String addAddress(AddressDTO addressDTO) {
		
		LocalAddress localAddress = modelMapper.map(addressDTO, LocalAddress.class);
		
		PermanentAddress permanentAddress = modelMapper.map(addressDTO, PermanentAddress.class);
		
		CustomerAddress customerAddress=new CustomerAddress();
		customerAddress.setLocalAddressId(localAddress);
		customerAddress.setPermanentAddressId(permanentAddress);
		customerAddressRepository.save(customerAddress);
		
	
	
		return "Address Saved Succesfully";
	}
	
}
