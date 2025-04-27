package com.example.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.customer.entity.CustomerAddress;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer>{

}
