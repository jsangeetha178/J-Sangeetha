package com.abc.insurance.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("/admin/TI")
@Validated
public class TravelWebController {


	@Autowired
	TravelInsuranceService travelInsuranceService;
	
	@Autowired
	TravelPolicyService travelPolicyService;
	
	@Autowired
	TravelInsuranceDTOConvertor dtoConvertor;

	public void TravelInsuranceWebController() {
		
		System.out.println("\n\n\n======>> Inside Constructor"+this);
		
	}

	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	
	
/*	public ResponseEntity<String> addTravelInsurance(@RequestBody TravelInsurance travelInsurance)

	{
		try {
			

			System.out.println(" --- > "+mylogs);
			mylogs.info("---->>>Inside try of addTravelInsurance");
			
			TravelInsurance savedInsurance =   travelInsuranceService.insertTravelInsurance(travelInsurance);
			
			String responseMsg = savedInsurance.getInsuranceName()+" save with Id "+savedInsurance.gettId();
			
			mylogs.info(savedInsurance.getInsuranceName()+" save with Id "+savedInsurance.gettId());
			return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
		
		} catch (Exception e) {
			
			String errorMsg =  "Contact to Travel Agency 1800-250-960 or mail us :- travelagency@insurance.com";
		
			return new ResponseEntity<String>(errorMsg,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}*/

	@PostMapping("/add")//8005/admin/TI/add?clientName=kelvin
	public ResponseEntity<MyDTO> addTravelInsurance(@RequestBody @Valid TravelInsurance travelInsurance,@RequestParam String clientName)
	{
		TravelPolicy alreadySavedPolicy = null;
		try
		{
			System.out.println(" --- > "+mylogs);
			mylogs.info("---->>>Inside try of addTravelInsurance ");
			
			TravelInsurance savedTravelInsurance = travelInsuranceService.insertTravelInsurance(travelInsurance);
			if(savedTravelInsurance.gettId() != 0)
			{
				alreadySavedPolicy = travelPolicyService.getTravelPolicyByClientName(clientName);
				
				if(alreadySavedPolicy != null)
				{
					TravelPolicy addTravelInsurance = travelPolicyService.linkPolicy(alreadySavedPolicy, savedTravelInsurance);
					
					TravelInsuranceDefaultResponseDTO dtoResponse = dtoConvertor.getTravelInsuranceDefaultResponseDTO(addTravelInsurance);
					
					return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
				}
				else
				{
					mylogs.error("Insurance not found in post mapping uri : add");
					throw new Exception("Insurance Not Found,  "+alreadySavedPolicy+" for "+clientName);
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
			
			ErrorDTO errorDTO = new ErrorDTO(e.getMessage());
			return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		return null;
	}
	@GetMapping("/allusers")
	public List<TravelInsurance> getAllInsurance()
	{
		try {
			List<TravelInsurance> allInsuranceUsers = travelInsuranceService.getAllTravelInsurance();
			
			return allInsuranceUsers;
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
		
	}

	@PutMapping("/update")
	public TravelInsurance updateTravelInsurance(@RequestBody TravelInsurance travelInsurance) throws Exception
	{
		
		return travelInsuranceService.updateTravelInsurance(travelInsurance);
		
		
	}
	@DeleteMapping("/delete")//8005/admin/TI/delete?tId=3
	public String deleteTravelInsurance(@RequestParam int tId) throws Exception
	{
		travelInsuranceService.deleteTravelInsurance(tId);
		
		mylogs.info("Deleted  = "+tId +" Data");
		return "Deleted Id = "+tId +" Data";
	}
	
	
	@GetMapping("/IPremium/{premium}")
	public List< TravelInsurance> getTravelInsuranceByPremium(@PathVariable int premium) throws Exception
	{

		return  travelInsuranceService.getTravelInsuranceByPremium(premium);

	}

	@GetMapping("/IName/{insuranceName}")
	public TravelInsurance getTravelInsuranceByInsuranceName(@PathVariable String insuranceName) throws Exception
	{

		return  travelInsuranceService.getTravelInsuranceByInsuranceName(insuranceName);

	}
	

	@GetMapping("/ILocation/{location}")
	public TravelInsurance getTravelInsuranceByLocation(@PathVariable String location) throws Exception
	{

		return  travelInsuranceService.getTravelInsuranceByLocation(location);

	}
	

	@GetMapping("/id/{id}")
	public TravelInsurance getTravelInsuranceBytId(@PathVariable int tId) throws Exception
	{

		return  travelInsuranceService.getTravelInsuranceBytId(tId);

	}
	
	@GetMapping("/suminsured/{sumInsured}")
	public TravelInsurance getTravelInsuranceBySumInsured(@PathVariable int sumInsured) throws Exception
	{
		return travelInsuranceService.getTravelInsuranceBySumInsured(sumInsured);
	}
	
}
