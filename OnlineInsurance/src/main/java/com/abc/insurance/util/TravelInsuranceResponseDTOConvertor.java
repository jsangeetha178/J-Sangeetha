package com.abc.insurance.util;

import org.springframework.stereotype.Component;

import com.abc.insurance.dto.InsuranceResponseDTO;
import com.abc.insurance.entity.TravelInsurance;

@Component
public class TravelInsuranceResponseDTOConvertor  {
	
	public InsuranceResponseDTO converToDTO(TravelInsurance ti)
	{
		return new InsuranceResponseDTO(ti.gettId(), ti.getInsuranceName());
	}

}
