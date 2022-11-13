package com.abc.insurance.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.abc.insurance.entity.TravelInsurance;



@Repository
public interface TravelInsuranceCustomRepository {

	public List<TravelInsurance> getTravelInsuranceByPremium(int premium)throws Exception;

	public TravelInsurance getTravelInsuranceBySumInsured(int sumInsured)throws Exception;
	public TravelInsurance getTravelInsuranceByInsuranceName(String insuranceName)throws Exception;

	public TravelInsurance getTravelInsuranceByLocation(String location) throws Exception;
	

	public TravelInsurance getTravelInsuranceBytId(int tId) throws Exception;
	
}
