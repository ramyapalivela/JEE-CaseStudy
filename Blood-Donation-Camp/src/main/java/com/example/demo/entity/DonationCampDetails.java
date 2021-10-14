package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name="donationCamp")
public class DonationCampDetails {
	@Id
	@Column(name="campNumber")
	int campNumber;
	
	@Column(name="campName")
	@NotNull(message="Please enter the campName")
	String donationCampName;
	
	@Column(name="campLocation")
	@NotNull(message="Please enter the location")
	String donationCampLocation;
	
	@Column(name="campDate")
	@DateTimeFormat(iso=ISO.DATE)
	LocalDate donationCampDate;
	
	@Column(name="campPhoneNumber")
	@Size(max=10,message="Please enter the phoneNumber")
	long donationCampPhoneNumber;
	
	@Column(name="campPincode")
	@Size(max=6,message="Please enter the pincode")
	int donationCampPincode;
}
