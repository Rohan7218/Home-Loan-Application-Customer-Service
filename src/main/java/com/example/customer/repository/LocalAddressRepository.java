package com.example.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customer.entity.LocalAddress;

public interface LocalAddressRepository extends JpaRepository<LocalAddress, Integer> {

}
