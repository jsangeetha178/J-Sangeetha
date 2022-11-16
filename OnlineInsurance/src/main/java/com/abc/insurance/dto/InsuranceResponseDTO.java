package com.abc.insurance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceResponseDTO implements MyDTO{

	private int insuranceId;
	private String insuranceName;
}
