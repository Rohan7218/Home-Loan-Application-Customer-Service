package com.example.customer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Customer_Permanent_Address")
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermanentAddress 
{
	@Id
	@SequenceGenerator(name = "Permanent_AddressId",sequenceName = "Permanent_AddressId",allocationSize = 1,initialValue = 101)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="Permanent_AddressId" )
	private Integer permanentAddressId;
	private String areaname;
	private String cityname;
	private String district;
	private String state;
	private Integer pincode;
	private Integer houseNumber;
	private String streetName;
}
