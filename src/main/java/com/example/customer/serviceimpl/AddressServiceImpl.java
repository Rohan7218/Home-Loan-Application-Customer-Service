package com.example.customer.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.dto.AddressDTO;
import com.example.customer.dto.UpdateLocalAddressDTO;
import com.example.customer.entity.CustomerAddress;
import com.example.customer.entity.LocalAddress;
import com.example.customer.entity.PermanentAddress;
import com.example.customer.repository.CustomerAddressRepository;
import com.example.customer.repository.LocalAddressRepository;
import com.example.customer.repository.PermanentAddressRepository;
import com.example.customer.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService
{
	@Autowired
	private LocalAddressRepository localAddressRepository;
	
	@Autowired
	private PermanentAddressRepository permanentAddressRepository;
	
	@Autowired
	private CustomerAddressRepository customerAddressRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public String addAddress(AddressDTO addressDTO, Integer addressId)
	{
		if(customerAddressRepository.findById(addressId).isPresent())
		{
			LocalAddress localAddress = modelMapper.map(addressDTO, LocalAddress.class);
			
			PermanentAddress permanentAddress = modelMapper.map(addressDTO, PermanentAddress.class);
			
			CustomerAddress customerAddress=new CustomerAddress();
										customerAddress.setLocalAddressId(localAddress);
										customerAddress.setPermanentAddressId(permanentAddress);
										customerAddress.setAddressId(addressId);
										
			customerAddressRepository.save(customerAddress);
			return "Address Saved Succesfully";
		}
			return null;
	}
	
	@Override
	public String updateLocalAddress(UpdateLocalAddressDTO updateLocalAddressDTO, Integer localAddressId) 
	{
		if(localAddressRepository.findById(localAddressId).isPresent())
		{
			LocalAddress localAddress = localAddressRepository.findById(localAddressId).get();
			
			if(updateLocalAddressDTO.getLocalAreaname()!=null)
			{
				localAddress.setLocalAreaname(updateLocalAddressDTO.getLocalAreaname());
			}
			if(updateLocalAddressDTO.getLocalCityname()!=null)
			{
				localAddress.setLocalCityname(updateLocalAddressDTO.getLocalCityname());
			}
			if(updateLocalAddressDTO.getLocalDistrict()!=null)
			{
				localAddress.setLocalDistrict(updateLocalAddressDTO.getLocalDistrict());
			}
			if(updateLocalAddressDTO.getLocalHouseNumber()!=null)
			{
				localAddress.setLocalHouseNumber(updateLocalAddressDTO.getLocalHouseNumber());
			}
			if(updateLocalAddressDTO.getLocalPincode()!=null)
			{
				localAddress.setLocalPincode(updateLocalAddressDTO.getLocalPincode());
			}
			if(updateLocalAddressDTO.getLocalState()!=null)
			{
				localAddress.setLocalState(updateLocalAddressDTO.getLocalState());
			}
			if(updateLocalAddressDTO.getLocalStreetName()!=null)
			{
				localAddress.setLocalStreetName(updateLocalAddressDTO.getLocalStreetName());
			}
			
			localAddressRepository.save(localAddress);
			return "Local Address Saved SuccessFully";
			
		}
		
		return "Customer Not Found";
	}
}
