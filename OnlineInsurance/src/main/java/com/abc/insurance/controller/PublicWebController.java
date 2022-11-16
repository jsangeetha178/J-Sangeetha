package com.abc.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.insurance.service.TravelInsuranceService;

@RestController
@RequestMapping("/public/TI")
public class PublicWebController {
	
	@Autowired
	TravelInsuranceService travelInsuranceService;

	
}
