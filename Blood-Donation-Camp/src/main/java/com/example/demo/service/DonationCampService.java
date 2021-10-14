package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DonationCampDetails;
import com.example.demo.repo.DonationCampRepository;

@Service
public class DonationCampService {

	@Autowired
	private DonationCampRepository repo;
	
	public DonationCampDetails addCampDetails(DonationCampDetails camp){
		return this.repo.save(camp);
	}
	public List<DonationCampDetails> findAll(){
		return this.repo.findAll();
	}
	public List<DonationCampDetails> findByLocation(String location){
		return this.repo.findByDonationCampLocation(location);
	}
	public int removeCampDetails(int number) {
		int rowRemoved=0;
		if(this.repo.existsById(number)) {
			this.repo.removeCampDetails(number);
			rowRemoved=1;
		}
		return rowRemoved;
	}
	public int updateCamp( int campNumber, String donationCampName,String donationCampLocation,
			 LocalDate donationCampDate, long donationCampPhoneNumber, int donationCampPincode) {
		return this.repo.updateCamp(campNumber, donationCampName, donationCampLocation, donationCampDate, donationCampPhoneNumber, donationCampPincode);
	}

	
}
