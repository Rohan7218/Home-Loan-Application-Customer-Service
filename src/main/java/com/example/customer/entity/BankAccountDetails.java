package com.example.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.example.customer.dto.AccountTypeEnum;
import com.example.customer.dto.accountStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer_Account_Details")
public class BankAccountDetails 
{
	@Id
	@SequenceGenerator(name = "Customer_Account_Id", sequenceName = "Customer_Account_Id", allocationSize = 1, initialValue =101)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer_Account_Id")
	@Column(name = "Customer_Account_Id")
	private Integer accountId;
	
	@Column(name = "Customer_Account_Type")
	@Enumerated(EnumType.STRING)
	private AccountTypeEnum accountType;
	
	@Column(name = "Customer_Account_Holder_Name")
	private String accountHolderName;
	
	@Column(name = "Customer_Account_Status")
	@Enumerated(EnumType.STRING)
	private accountStatusEnum accountStatus;
	
	@Column(name = "Customer_Account_Number")
	private Long accountNumber;

}
