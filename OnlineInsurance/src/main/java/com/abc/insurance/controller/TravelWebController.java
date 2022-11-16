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
import com.abc.insurance.dto.InsuranceResponseDTO;
import com.abc.insurance.dto.MyDTO;
import com.abc.insurance.dto.DefaultResponseDTO;
import com.abc.insurance.entity.TravelInsurance;
import com.abc.insurance.entity.TravelPolicy;
import com.abc.insurance.service.TravelInsuranceService;
import com.abc.insurance.service.TravelPolicyService;
import com.abc.insurance.util.TravelInsuranceResponseDTOConvertor;
import com.abc.insurance.util.TravelPolicyDTOConvertor;

@RestController
@RequestMapping("/admin/TI")
@Validated
public class TravelWebController {


	@Autowired
	TravelInsuranceService travelInsuranceService;
	
	@Autowired
	TravelPolicyService travelPolicyService;
	
	@Autowired
	TravelPolicyDTOConvertor dtoConvertor;
	
	@Autowired
	TravelInsuranceResponseDTOConvertor tiDTOConverter;
	

	
	public void TravelInsuranceWebController() {
		
		System.out.println("\n\n\n======>> Inside Constructor"+this);
		
	}

	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	
	@PostMapping("/add")//8005/admin/TI/add
	public ResponseEntity<MyDTO> addTravelInsurance(@RequestBody @Valid TravelInsurance travelInsurance) throws Exception
	{
		
			System.out.println(" --- > "+mylogs);
			
			mylogs.info("---->>>Inside Controller TI  :- "+travelInsurance);
			
			TravelInsurance savedTravelInsurance = travelInsuranceService.insertTravelInsurance(travelInsurance);
			
			InsuranceResponseDTO responseDTO = tiDTOConverter.converToDTO(savedTravelInsurance);
			
			return new ResponseEntity<MyDTO>(responseDTO, HttpStatus.OK);
			
	}
	@GetMapping("/allInsurance")//   localhost:8005/admin/TI/allInsurance
	public List<TravelInsurance> getAllInsurance()
	{
		try {
			List<TravelInsurance> allInsuranceUsers = travelInsuranceService.getAllTravelInsurance();
			
			return allInsuranceUsers;
		
		}catch(Exception e) {
			
			System.out.println(e);
		}
		return null;
		
	}

	@PutMapping("/update")//    localhost:8005/admin/TI/update
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
	
	
	@GetMapping("/IPremium/{premium}")//    localhost:8005/admin/TI/IPremium/5000
	public List< TravelInsurance> getTravelInsuranceByPremium(@PathVariable int premium) throws Exception
	{

		return  travelInsuranceService.getTravelInsuranceByPremium(premium);

	}

	@GetMapping("/IName/{insuranceName}")//   localhost:8005/admin/TI/IName/
	public TravelInsurance getTravelInsuranceByInsuranceName(@PathVariable String insuranceName) throws Exception
	{

		return  travelInsuranceService.getTravelInsuranceByInsuranceName(insuranceName);

	}
	

	@GetMapping("/ILocation/{location}")//    localhost:8005/admin/TI/ILocation/korea
	public TravelInsurance getTravelInsuranceByLocation(@PathVariable String location) throws Exception
	{

		return  travelInsuranceService.getTravelInsuranceByLocation(location);

	}
	

	@GetMapping("/id/{tId}")//  localhost:8005/admin/TI/id/4
	public TravelInsurance getTravelInsuranceBytId(@PathVariable int tId) throws Exception
	{

		return  travelInsuranceService.getTravelInsuranceBytId(tId);

	}
	
	@GetMapping("/suminsured/{sumInsured}")//   localhost:8005/admin/TI/suminsured/500000
	public TravelInsurance getTravelInsuranceBySumInsured(@PathVariable int sumInsured) throws Exception
	{
		return travelInsuranceService.getTravelInsuranceBySumInsured(sumInsured);
	}
	
	@GetMapping("/{field}")//...8005/admin/TI/Location
	public List<TravelInsurance> getTravelInsuranceWithSort(@PathVariable String field) throws Exception
	{
		List<TravelInsurance> allTravelInsurance = travelInsuranceService.findTravelInsuranceWithSorting(field);
		
		return allTravelInsurance;
	}
	

	@GetMapping("/filterName/{insuranceName}")//...8005/admin/TI/filterName/
	public List<TravelInsurance> filterInsurance(@PathVariable String insurancName) throws Exception
	{
		List<TravelInsurance> filtered = travelInsuranceService.filterByInsuranaceName(insurancName);
		
		return filtered;
	}
}
