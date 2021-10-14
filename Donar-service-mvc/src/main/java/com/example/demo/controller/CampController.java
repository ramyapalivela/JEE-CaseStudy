package com.example.demo.controller;

import javax.validation.Valid;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.DonationCampDetails;

@Controller
public class CampController {
	
	@Autowired
	private DonationCampDetails campobject;
	
	@Autowired
	private RestTemplate template;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("heading", "Blood Donation Camp Details");
		return "index";
	}
	
	@GetMapping(path="/addCamp")
	public String sendForm(Model model) {
    	model.addAttribute("command",campobject);
    	return "addCamp";
    }
	
	@PostMapping(path="/addCamp")
	public String submitCampDetails(@Valid @ModelAttribute("command") DonationCampDetails camp,BindingResult result) {
		String nextStep = "success";

		if(result.hasErrors()) {
			nextStep = "addCamp";
		}else 
		{
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<DonationCampDetails> requestBody = new HttpEntity<>(camp,headers);
			template.postForObject("http://localhost:6666/api/v1/camp", requestBody, DonationCampDetails.class);
		}
	return nextStep;
	}
	
	@GetMapping(path = "/allCamp")
	public String findAllCamp(Model model) {
		DonationCampDetails[] response =template.getForObject("http://localhost:6666/api/v1/camp",
				DonationCampDetails[].class);
		model.addAttribute("camp",response);
		return "displayCamp";
	}
	
	@GetMapping(path = "/getByCampLocation")
	public String findByCampLocation(Model model,String camplocation) {
		DonationCampDetails[] resp1 =template.getForObject("http://localhost:6666/api/v1/camp/location/"+camplocation,
				DonationCampDetails[].class);
		if(resp1.length>0) {
			model.addAttribute("camp",resp1);
			return "displayCamp";
		}else{
			return "noDonarPresent";
		}
	}
	
	

}
