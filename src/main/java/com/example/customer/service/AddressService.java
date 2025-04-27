package com.example.customer.service;

import com.example.customer.dto.AddressDTO;
import com.example.customer.dto.UpdateLocalAddressDTO;

public interface AddressService {

	String addAddress(AddressDTO addressDTO, Integer addressId);

	String updateLocalAddress(UpdateLocalAddressDTO updateLocalAddressDTO, Integer localAddressId);

}
