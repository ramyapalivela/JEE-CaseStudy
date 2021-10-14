package com.example.demo.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.entity.DonarsDetails;
import com.example.demo.service.DonarServices;

@RestController
@RequestMapping(path="/api/v1/donar")
public class DonarServiceController {
	
	private DonarServices service;
	
	@Autowired
	public void setService(DonarServices service) {
		this.service = service;
	}
	
	@GetMapping
	public List<DonarsDetails> findAll(){
		return this.service.findAll();
	}

	@GetMapping(path="/group/{group}")
	public List<DonarsDetails> findByBloodGroup(@PathVariable("group") String donarBloodGroup){
		return this.service.findByBloodGroup(donarBloodGroup);
	}
	
	@GetMapping(path="/location/{location}")
	public List<DonarsDetails> findByLocation(@PathVariable("location") String donarLocation){
		return this.service.findByLocation(donarLocation);
	}
	
	@GetMapping(path="/id/{id}")
	public List<DonarsDetails> findByDonarId(int donarId){
		return this.service.findByDonarId(donarId);
	}
	
	@PostMapping
	public ResponseEntity<DonarsDetails> add(@RequestBody DonarsDetails entity) {
		DonarsDetails addedEntity = this.service.addDonar(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	}
	
	@PutMapping(path="/{id}/{name}/{age}/{dob}/{location}/{pincode}/{group}/{phoneNumber}/{donationdate}/")
	public ResponseEntity<String> updateDonar(@PathVariable("id") int donarId,@PathVariable("name") String nameToUpdate,@PathVariable("age") int ageToUpdate,
			@PathVariable("dob") LocalDate dobToUpdate,@PathVariable("location") String locationToUpdate,@PathVariable("pincode") int pinToUpdate,
			@PathVariable("group") String bloodGroupToUpdate,@PathVariable("phonenumber") String numberToUpdate,
			@PathVariable("donationdate") String donationDateToUpdate) {
		LocalDate updatedDonationdate=LocalDate.parse(donationDateToUpdate);
		int count =this.service.updateDonar(donarId, nameToUpdate, ageToUpdate, dobToUpdate, locationToUpdate, pinToUpdate, bloodGroupToUpdate, numberToUpdate,updatedDonationdate);
		return ResponseEntity.ok().body(count+":=Records are Updated Successfully");
	}
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<String> deleteDonarById(@PathVariable("id") int donarId) {
		int count = this.service.deleteDonarById(donarId);
		HttpStatus status =HttpStatus.NOT_FOUND;
		String msg="Record Not Found";
		if(count==1){
			status=HttpStatus.OK;
			msg="One Record is Deleted successfully";
		}
		return ResponseEntity.status(status).body(msg);
	}

}
