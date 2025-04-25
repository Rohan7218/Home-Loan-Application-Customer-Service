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
@Table(name = "Customer_Local_Address")
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalAddress 
{
	@Id
	@SequenceGenerator(name = "Local_AddressId",sequenceName = "Local_AddressId",allocationSize = 1,initialValue = 101)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="Local_AddressId" )
	private Integer localAddressId;
	private String areaname;
	private String cityname;
	private String district;
	private String state;
	private Integer pincode;
	private Integer houseNumber;
	private String streetName;

}
