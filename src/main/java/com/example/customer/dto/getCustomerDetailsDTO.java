package com.example.customer.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.example.customer.entity.AllPersonalDocs;
import com.example.customer.entity.BankAccountDetails;
import com.example.customer.entity.CibilDetails;
import com.example.customer.entity.CustomerAddress;

import lombok.Data;

@Data
public class getCustomerDetailsDTO {

	private Integer customerId;

	private String firstName;

	private String middleName;

	private String lastName;

	private String emailId;

	private Long contactNo;

	private String panCardNo;

	private String cityName;

	private CibilDetails cibilId;

	private ExistingCustomerEnum existingCustomer; // Enum

	private LocalDate dateOfBirth;

	private Integer age;

	private CustomerGenderEnum gender; // Enum

	private Long alternateContactNumber;

	private String aadharNo;

	private String voterIdNo;

	private String passportNo;

	private String drivingLicenseNo;

	private CustomerMaritalStatus maritalStatus;

	private BankAccountDetails accountId;

	private AllPersonalDocs personalDocumentId;

	private CustomerAddress customerAddressId;

}
