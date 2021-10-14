package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DonarsDetails;
import com.example.demo.repo.DonarServiceRepository;

@Service
public class DonarServices {
	@Autowired
	private DonarServiceRepository repo;
	
	public DonarsDetails addDonar(DonarsDetails entity) {
		return this.repo.save(entity);
	}
	public List<DonarsDetails> findAll(){
		return this.repo.findAll();
	}
	public List<DonarsDetails> findByBloodGroup(String group){
		return this.repo.findByDonarBloodGroup(group);
	}
	public List<DonarsDetails> findByLocation(String location){
		return this.repo.findByDonarLocation(location);
		
	}
	public List<DonarsDetails> findByDonarId(int id){
		return this.repo.findByDonarId(id);
	}
	public int deleteDonarById(int id) {
		int rowDeleted=0;
		if(this.repo.existsById(id)) {
			this.repo.deleteById(id);
			rowDeleted=1;
		}
		return rowDeleted;
	}
	public int updateDonar(int donarId,String nameToUpdate, int ageToUpdate,LocalDate dobToUpdate,
			String locationToUpdate,int pinToUpdate,String bloodGroupToUpdate, String numberToUpdate,
			LocalDate donationDateToUpdate) {
		return this.repo.updateDonar(donarId, nameToUpdate, ageToUpdate, dobToUpdate, locationToUpdate, pinToUpdate, bloodGroupToUpdate, numberToUpdate, donationDateToUpdate);
	}

}
