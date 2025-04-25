package com.example.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customer.entity.PermanentAddress;

public interface PermanentAddressRepository extends JpaRepository<PermanentAddress, Integer> {

}
