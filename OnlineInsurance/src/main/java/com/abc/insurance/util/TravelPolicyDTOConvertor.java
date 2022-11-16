package com.abc.insurance.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.abc.insurance.dto.DefaultResponseDTO;

import com.abc.insurance.entity.TravelInsurance;
import com.abc.insurance.entity.TravelPolicy;

@Component
@Scope("singleton")
public class TravelPolicyDTOConvertor {

	public static DefaultResponseDTO getTravelInsuranceDefaultResponseDTO(TravelPolicy travelPolicy)
	{
		DefaultResponseDTO dto = new DefaultResponseDTO(
				travelPolicy.getPolicyId(),
				travelPolicy.getClientName(),
				travelPolicy.getTravelInsurance().getInsuranceName(),
				
				"Client Policy Added, Travel Insurance Id :"+travelPolicy.getTravelInsurance().gettId());
				
		return dto;
		
	}
	
	

}
