package com.example.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Customer_Address_Details")
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddress {

	@Id
	@Column(name = "Address_Id")
	private Integer addressId;
	
	@Column(name = "Local_Address")
	private String localAddress;

	@Column(name = "Permenant_Address")
	private String permenantAddress;
}
