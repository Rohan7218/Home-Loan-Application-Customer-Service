package com.example.customer.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AdditionalCustomerDetailsDTO {

	private ExistingCustomerEnum existingCustomer; // Enum
	
	private CustomerMaritalStatus maritalStatus; //Enum

//	@NotBlank(message = "Birthdate is required")
	private LocalDate dateOfBirth;

	@NotNull
	@NotNull(message = "Age is required")
	@Min(value = 21, message = "Age must be greater than or equal to 21")
	private Integer age;

	private CustomerGenderEnum gender; // Enum

	@NotBlank(message = "Mobile number is required")
	@Pattern(regexp = "^[789]\\d{9}$", message = "Mobile number must start with 7, 8, or 9 and be 10 digits long")
	private String alternateContactNumber;

	@NotBlank(message = "Aadhaar card number is required")
	@Size(min = 12, max = 12, message = "Aadhaar card number must be 12 digits")
	@Pattern(regexp = "^[0-9]{12}$", message = "Aadhaar card number must be numeric and 12 digits long")
	private String aadharNo;

	@NotBlank(message = "Voter ID is required")
	@Size(min = 10, max = 10, message = "Voter ID must be exactly 10 characters")
	@Pattern(regexp = "^[A-Z]{3}[0-9]{7}$", message = "Voter ID must be in the format ABC1234567")
	private String voterIdNo;

	@NotBlank(message = "Passport number is required")
	@Size(min = 8, max = 8, message = "Passport number must be exactly 8 characters")
	@Pattern(regexp = "^[A-PR-WY][0-9]{7}$", message = "Passport number must start with a letter followed by 7 digits")
	private String passportNo;

	@NotBlank(message = "Driving license number is required")
	@Pattern(regexp = "^[A-Z]{2}[0-9]{2}\\s?[0-9]{4}[0-9]{7}$", message = "Driving license must be in the format 'MH14 20110012345' or 'DL0420110142345'")
	private String drivingLicenseNo;



}
