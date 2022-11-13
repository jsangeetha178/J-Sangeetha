package com.abc.insurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.insurance.entity.TravelInsurance;
import com.abc.insurance.entity.TravelPolicy;

@Service
public interface TravelInsuranceService {

	public TravelInsurance insertTravelInsurance(TravelInsurance travelInsurance) throws Exception;

	public List<TravelInsurance> getAllTravelInsurance() throws Exception;

	public List<TravelInsurance> getTravelInsuranceByPremium(int premium) throws Exception;

	public TravelInsurance getTravelInsuranceByLocation(String location) throws Exception;

	public TravelInsurance getTravelInsuranceBySumInsured(int sumInsured) throws Exception;

	public TravelInsurance getTravelInsuranceByInsuranceName(String insuranceName) throws Exception;

	public TravelInsurance getTravelInsuranceBytId(int tId) throws Exception;

	public TravelInsurance updateTravelInsurance(TravelInsurance travelInsurance) throws Exception;

	public void deleteTravelInsurance(int tId) throws Exception;

	

}
