package com.example.customer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
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
public class CustomerAddress
{
	
	@Id
	@SequenceGenerator(name = "Customer_AddressId",sequenceName = "Customer_AddressId",allocationSize = 1,initialValue = 101)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="Customer_AddressId" )
	@Column(name = "Customer_AddressId")
	private Integer addressId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Local_Address_Id")
	private LocalAddress localAddressId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Permanent_Address_ID")
	private PermanentAddress permanentAddressId;
	
}
