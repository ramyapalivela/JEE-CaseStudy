package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DonationCampDetails;
import com.example.demo.service.DonationCampService;

@RestController
@RequestMapping(path="/api/v1/camp")
public class DonationCampController {
	private DonationCampService service;
	
	@Autowired
	public DonationCampController(DonationCampService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public List<DonationCampDetails> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping(path="/location/{location}")
	public List<DonationCampDetails> findByLocation(@PathVariable("location")String location)
	{
		return this.service.findByLocation(location);
	}
	
	@PostMapping
	public ResponseEntity<DonationCampDetails> add(@RequestBody DonationCampDetails camp)
	{
		DonationCampDetails addedCamp=this.service.addCampDetails(camp);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedCamp);
	}
	
	@PutMapping
	public ResponseEntity<String> updateCamp(@PathVariable("number") int campNumber,@PathVariable("name") String donationCampName,@PathVariable("location") String donationCampLocation,
		@PathVariable("date") LocalDate donationCampDate,@PathVariable("phonenumber") long donationCampPhoneNumber,@PathVariable("pin") int donationCampPincode){
		int count=this.service.updateCamp(campNumber, donationCampName, donationCampLocation, donationCampDate, donationCampPhoneNumber, donationCampPincode);
		return ResponseEntity.ok().body(count+":=Records are Updated Successfully");
	}
	
	@DeleteMapping(path = "/{number}")
	public ResponseEntity<String> removeCampDetails(@PathVariable("number")int number){
		int count=this.service.removeCampDetails(number);
		HttpStatus status=HttpStatus.NOT_FOUND;
		String message="Record not found";
		if(count==1){ 
			status=HttpStatus.OK;
			message="one record deleted";
		}
		return ResponseEntity.status(status).body(message);
	}

}
