package com.example.demo.controller;

import java.util.Arrays;

import javax.validation.Valid;

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

import com.example.demo.entity.DonarsDetails;

@Controller
public class DonarController {
	
	@Autowired
	private DonarsDetails object;
	
	@Autowired
	private RestTemplate template;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("heading", "Donar Details");
		return "index";
	}
	
	@GetMapping(path="/addDonar")
	public String sendForm(Model model) {
    	model.addAttribute("command",object);
    	return "addDonar";
    }
	

    @PostMapping(path="/addDonar")
    public String submitDonar(@Valid @ModelAttribute("command") DonarsDetails donar,BindingResult result) {
    	String nextStep = "success";
    	
    	if(result.hasErrors()) {
    		nextStep = "addDonar";
    	}else {
    		HttpHeaders headers = new HttpHeaders();
    		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    		headers.setContentType(MediaType.APPLICATION_JSON);
    		HttpEntity<DonarsDetails> requestBody = new HttpEntity<>(donar,headers);
        	template.postForObject("http://localhost:5555/api/v1/donar", requestBody, DonarsDetails.class);
    	}
    	return nextStep;
    }
    
    @GetMapping(path = "/getAllDonors")
    public String findAll(Model model) {
    	DonarsDetails[] resp =template.getForObject("http://localhost:5555/api/v1/donor",
    			DonarsDetails[].class);
    	model.addAttribute("alldonars",resp);
    	return "allDonars";
    }
    
    @GetMapping(path = "/getBloodGroup")
    public String findByBloodGroup(Model model,String search) {
    	DonarsDetails[] resp1 =template.getForObject("http://localhost:5555/api/v1/donor/group/"+search,
    			DonarsDetails[].class);
    	if(resp1.length>0) {
    		model.addAttribute("alldonars",resp1);
    		return "allDonars";
    	}else{
    		return "noBloodGroupDonar";
    	}
    }
    
    @GetMapping(path = "/getLocation")
    public String findByLocation(Model model,String location) {
    	DonarsDetails[] resp2 =template.getForObject("http://localhost:5555/api/v1/donar/location/"+location,
    			DonarsDetails[].class);
    	if(resp2.length>0) {
    		model.addAttribute("alldonors",resp2);
    		return "allDonars";
    	}else{
    		return "noDonarPresent";
    	}
    }
    
    

}
