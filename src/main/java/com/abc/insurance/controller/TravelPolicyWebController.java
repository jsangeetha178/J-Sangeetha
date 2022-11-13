package com.abc.insurance.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.insurance.dto.ErrorDTO;
import com.abc.insurance.dto.MyDTO;
import com.abc.insurance.dto.TravelInsuranceDefaultResponseDTO;
import com.abc.insurance.entity.TravelInsurance;
import com.abc.insurance.entity.TravelPolicy;
import com.abc.insurance.service.TravelInsuranceService;
import com.abc.insurance.service.TravelPolicyService;
import com.abc.insurance.util.TravelInsuranceDTOConvertor;

@RestController
@RequestMapping("client/policy")
public class TravelPolicyWebController {

	@Autowired
	TravelPolicyService travelPolicyService;
	
	@Autowired
	TravelInsuranceService travelInsuranceService;
	
	@Autowired
	TravelInsuranceDTOConvertor dtoConvertor;
	
private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	
	@PostMapping("/add")  //8005/client/policy/add
	public ResponseEntity<String> doTravelPolicyThings(@RequestBody  TravelPolicy travelPolicy)
	{
		
		try
		{
			System.out.println(" --- > "+mylogs);
			mylogs.info("---->>>Inside try of doTravelPolicyThings");
			
			TravelPolicy savedTravelPolicy = travelPolicyService.addTravelPolicy(travelPolicy);
			
			String responseMsg = savedTravelPolicy.getClientName()+"save with Id "+savedTravelPolicy.getPolicyId();
					
				
				
			mylogs.info(savedTravelPolicy.getClientName()+"save with Id "+savedTravelPolicy.getPolicyId());
				
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		}
	
		catch(Exception e) {
			
			String errorMsg =  "Contact to Travel Agency 1800-250-960 or mail us :- travelagency@insurance.com";
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
	}
	@GetMapping("/policyNumber")//policyNumber?r1=600&r2=601
	public List<TravelPolicy> policiesBetweenPolicyNumber(@RequestParam int r1 , @RequestParam int r2)throws Exception
	{

		return travelPolicyService.getTravelPolicyBetweenPolicyNumber(r1, r2);
	}
	
	@GetMapping("/clientName/{clientName}")
	public TravelPolicy getByClientName(@PathVariable String clientName)throws Exception
	{

		return travelPolicyService.getTravelPolicyByClientName(clientName);
	}
	
	// PoliciesOnClaimedDate/sam?claimedDate=18-5-2022
	@GetMapping("/PoliciesOnClaimedDate/{clientName}")
	public List<TravelPolicy> getPoliciesOnClaimedDate(@PathVariable String clientName,@RequestParam String claimedDate)throws Exception
	{
		if(claimedDate != null)
		{
			return travelPolicyService.getTravelPolicyBasedOnClientNameAndClaimDate(clientName, claimedDate);
		}
		else return null;
	}


	
	
}
