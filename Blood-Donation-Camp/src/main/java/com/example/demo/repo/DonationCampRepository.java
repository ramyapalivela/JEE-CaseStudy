package com.example.demo.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DonationCampDetails;

@Repository
public interface DonationCampRepository extends JpaRepository<DonationCampDetails, Integer> {
	public List<DonationCampDetails> findAll();
	public List<DonationCampDetails> findByDonationCampLocation(String location);
	public int removeCampDetails(int number);
	@Query(nativeQuery = true, value = "update donationCamp set donationCampName=:name,donationCampLocation=:location,donationCampDate=:date,"
			+ "donationCampPhoneNumber=:phonenumber,donationCampPincode=:pin where campNumber=:number")
	@Modifying
	@Transactional
	public int updateCamp(@Param("number") int campNumber,@Param("name") String donationCampName,@Param("location") String donationCampLocation,
			@Param("date") LocalDate donationCampDate,@Param("phonenumber") long donationCampPhoneNumber,@Param("pin") int donationCampPincode);
}
