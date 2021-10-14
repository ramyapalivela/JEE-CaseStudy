package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name="donarlist")
public class DonarsDetails {
	
	@Id
	@Column(name="donarid")
	@Size(max=8, message="Enter the Id with 8 characters")
	int donarId;
	
	@Column(name="donarname")
	@NotNull(message="Please enter the name")
	String donarName;
	
	@Column(name="donarage")
	@Range(min = 15, max=75,message="Enter the age in range from 15-75")
	int donarAge;
	
	@Column(name="donardateofbirth")
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull
	LocalDate donarDateofBirth;
	
	@Column(name="donarlocation")
	@NotNull(message="Please enter your location")
	String donarLocation;
	
	@Column(name="donarpincode")
	@Size(max=6,message="Please enter your pincode")
	int donarPincode;
	
	@Column(name="donarbloodgroup")
	@NotNull(message="Please enter your bloodgroup")
	String donarBloodGroup;
	
	@Column(name="donarphonenumber")
	@Size(max=10,message="Please enter your phoneNumber")
	long donarPhoneNumber;
	
	@Column(name="donardonationdate")
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull
	LocalDate donarDonationDate;
	
}
