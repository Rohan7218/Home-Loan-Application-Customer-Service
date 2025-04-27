package com.example.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name = "Dependent_Info")
public class DependentInfo 
{
	@Id
	@SequenceGenerator(name = "Dependent_InfoId", sequenceName = "Dependent_InfoId", allocationSize = 1, initialValue =101)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Dependent_InfoId")
	@Column(name = "Customer_Dependent_InfoId")
	private Integer dependentInfoId;
	
	@Column(name = "No_Of_Family_Member")
	private Integer noOfFamilyMember;
	
	@Column(name = "No_Of_Child")
	private Integer noOfChild;
	
	@Column(name = "Marital_Status")
	private String maritalStatus;
	
	@Column(name = "Dependent_Member")
	private String dependentMember;
	
	@Column(name = "Family_Income")
	private Double familyIncome;
	
	@ManyToOne
	@JoinColumn(name = "Customer_Id")
	private CustomerDetails customerId;
	
	
	
	
}
