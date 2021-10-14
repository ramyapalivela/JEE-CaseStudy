package com.example.demo.repo;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DonarsDetails;

@Repository
public interface DonarServiceRepository extends JpaRepository<DonarsDetails, Integer>  {
	public List<DonarsDetails> findAll();
	public List<DonarsDetails> findByBloodGroup(String group);
	public List<DonarsDetails> findByLocation(String location);
	public List<DonarsDetails> findByDonarId(int id);
	public int deleteDonarById(int id);
	@Query(nativeQuery = true, value = "update donarList set donarName =: name,donarAge=: age,donarDateofBirth:=dob,"
			+ "donarLocation=:location,donarPincode=:pincode,donarBloodGroup=:group,donarPhoneNumber:=phonenumber,"
			+ "donarDonationDate=:donationdate  where donarId=: id")
	@Modifying
	@Transactional
	public int updateDonar(@Param("id") int donarId,@Param("name") String nameToUpdate,@Param("age") int ageToUpdate,
			@Param("dob") LocalDate dobToUpdate,@Param("location") String locationToUpdate,@Param("pincode") int pinToUpdate,
			@Param("group") String bloodGroupToUpdate,@Param("phonenumber") String numberToUpdate,
			@Param("donationdate") LocalDate donationDateToUpdate);
}
