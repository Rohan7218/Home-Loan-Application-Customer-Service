package com.example.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Customer_All_Personal_Docs")
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllPersonalDocs {

	@Id
	@SequenceGenerator(name = "Customer_Personal_DocumentId",sequenceName = "Customer_Personal_DocumentId",allocationSize = 1,initialValue = 101)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="Customer_Personal_DocumentId" )
	@Column(name = "Customer_Personal_DocumentId")
	private Integer personalDocumentId;
	
	@Column(name = "AddressProof")
	@Lob
	private byte[] addressProof;
	
	@Column(name = "PanCard")
	@Lob
	private byte[]panCard;
	
	@Column(name = "AdharCard")
	@Lob
	private byte[]adharCard;
	
	@Column(name = "IncomeTax")
	@Lob
	private byte[] incomeTax;
	
	@Column(name = "PassportPhoto")
	@Lob
	private byte[] passportPhoto;
	
	@Column(name = "Signature")
	@Lob
	private byte[]signature;
	
	@Column(name = "SalarySlips")
	@Lob
	private byte[]salarySlips;
	
	
}
