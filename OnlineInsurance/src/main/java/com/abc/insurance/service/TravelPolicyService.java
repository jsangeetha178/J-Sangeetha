package com.abc.insurance.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.abc.insurance.entity.TravelInsurance;
import com.abc.insurance.entity.TravelPolicy;

@Service
public interface TravelPolicyService {

	public TravelPolicy addTravelPolicy(TravelPolicy travelPolicy);

	public List<TravelPolicy> viewAllPolicy() throws Exception;

	public List<TravelPolicy> getTravelPolicyBetweenPolicyNumber(@Param("range1") int range1,@Param("range2") int range2) throws Exception;

	public TravelPolicy getTravelPolicyByClientName(String clientName) throws Exception;

	public List<TravelPolicy> getTravelPolicyBasedOnClientNameAndClaimDate(String clientName, String claimDate)throws Exception;


	public TravelPolicy linkInsurance(TravelPolicy travelPolicy, TravelInsurance travelInsurance);

	public List<TravelPolicy> findTravelPolicyWithSorting(String field)throws Exception;

	public List<TravelPolicy> filterByClientName(String clientName)throws Exception;
}
