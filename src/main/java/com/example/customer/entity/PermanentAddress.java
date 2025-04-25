package com.example.customer.entity;

import javax.persistence.Column;
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
	
	@Column(name = "Permanent_Areaname")
	private String permanentAreaname;
	
	@Column(name = "Permanent_Cityname")
	private String permanentCityname;
	
	@Column(name = "Permanent_District")
	private String permanentDistrict;
	
	@Column(name = "Permanent_State")
	private String permanentState;
	
	@Column(name = "Permanent_Pincode")
	private Integer permanentPincode;
	
	@Column(name = "Permanent_Housenumber")
	private Integer permanentHouseNumber;
	
	@Column(name = "Permanent_Streetname")
	private String permanentStreetName;
}
