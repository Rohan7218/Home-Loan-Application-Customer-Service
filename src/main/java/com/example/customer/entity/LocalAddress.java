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
	@Column(name = "Local_Address_ID")
	private Integer localAddressId;
	
	@Column(name = "Local_Areaname")
	private String localAreaname;
	
	@Column(name = "Local_Cityname")
	private String localCityname;
	
	@Column(name = "Local_District")
	private String localDistrict;
	
	@Column(name = "Local_State")
	private String localState;
	
	@Column(name = "Local_Pincode")
	private Integer localPincode;
	
	@Column(name = "Local_Housenumber")
	private Integer localHouseNumber;
	
	@Column(name = "Local_Streetname")
	private String localStreetName;

}
