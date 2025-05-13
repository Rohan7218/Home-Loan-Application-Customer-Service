package com.example.customer.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.customer.dto.CustomerGenderEnum;
import com.example.customer.dto.CustomerMaritalStatus;
import com.example.customer.dto.CustomerStatusEnum;
import com.example.customer.dto.ExistingCustomerEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer_Details")
public class CustomerDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Customer_Id")
	private Integer customerId;

	@Column(name = "First_Name")
	private String firstName;
	
	@Column(name = "Middle_Name")
	private String middleName;
	
	@Column(name = "Last_Name")
	private String lastName;
	
	@Column(name = "Email_Id")
	private String emailId;

	@Column(name = "Contact_Number")
	private Long contactNo;

	@Column(name = "Pancard_Number")
	private String panCardNo;

	@Column(name = "City_Name")
	private String cityName;

	@CreationTimestamp
	@Column(name = "Customer_Created_Date", updatable = false)
	private LocalDate createdDate;

	@UpdateTimestamp
	@Column(name = "Customer_Updated_Date", insertable = false)
	private LocalDate updatedDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Customer_Cibil_Id")
	private CibilDetails cibilId;
		
//=========================================================================
	//Additional added Fields.
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Existing_Customer")
	private ExistingCustomerEnum existingCustomer;  		//Enum
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Customer_Status")
	private CustomerStatusEnum customerStatus;
	
	@Column(name = "Date_Of_Birth")
	private LocalDate dateOfBirth;
	
	@Column(name = "Age")
	private Integer age;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Gender")
	private CustomerGenderEnum gender;                    //Enum                              
	
	@Column(name = "Alternativer_Contact_no")
	private Long alternateContactNumber;
	
	@Column(name="AadharCard_Number")
	private String aadharNo;
	
	@Column(name="VoterId_Number")
	private String voterIdNo;
	
	@Column(name = "Passport_Number")
	private String passportNo;
	
	@Column(name = "Driving_License_Number")
	private String drivingLicenseNo;
	
	@Column(name = "Password")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Marital_Status")
	private CustomerMaritalStatus maritalStatus;            //Enum
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Customer_AccountDetails_Id")
	private BankAccountDetails accountId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Customer_Personal_DocumentId")
	private AllPersonalDocs personalDocumentId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Customer_AddressId")
	private CustomerAddress customerAddressId;
	
	
	

}
