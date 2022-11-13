package com.abc.insurance.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.abc.insurance.dto.TravelInsuranceDefaultResponseDTO;

import com.abc.insurance.entity.TravelInsurance;
import com.abc.insurance.entity.TravelPolicy;

@Component
@Scope("singleton")
public class TravelInsuranceDTOConvertor {

	public static TravelInsuranceDefaultResponseDTO getTravelInsuranceDefaultResponseDTO(TravelPolicy travelPolicy)
	{
		TravelInsuranceDefaultResponseDTO dto = new TravelInsuranceDefaultResponseDTO(
				travelPolicy.getPolicyId(),
				travelPolicy.getClientName(),
				travelPolicy.getTravelInsurance().getInsuranceName(),
				
				"Client Policy Added, Travel Insurance Id :"+travelPolicy.getTravelInsurance().gettId());
				
		return dto;
		
	}
	
	

}
