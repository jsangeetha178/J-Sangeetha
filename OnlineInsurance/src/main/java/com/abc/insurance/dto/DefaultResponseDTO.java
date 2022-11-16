package com.abc.insurance.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DefaultResponseDTO implements MyDTO{

	private int tId;
	private String insuranceName;
	private String clientName;
	private String remarks;
	
}
