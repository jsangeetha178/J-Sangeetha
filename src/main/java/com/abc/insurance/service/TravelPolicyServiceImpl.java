package com.abc.insurance.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.insurance.entity.TravelInsurance;
import com.abc.insurance.entity.TravelPolicy;
import com.abc.insurance.repository.TravelPolicyRepository;

@Service
public class TravelPolicyServiceImpl implements TravelPolicyService {

	@Autowired
	TravelPolicyRepository travelPolicyRepository;
	
	@Override
	public TravelPolicy addTravelPolicy(TravelPolicy travelPolicy) {
		
		TravelPolicy savedPolicy = travelPolicyRepository.save(travelPolicy);
		return savedPolicy;
	}

	@Override
	public List<TravelPolicy> viewPolicyHistory(TravelPolicy travelPolicy) throws Exception {

		
		return null;
	}

	@Override
	public List<TravelPolicy> getTravelPolicyBetweenPolicyNumber(int range1, int range2) throws Exception {
		// TODO Auto-generated method stub
		return travelPolicyRepository.getTravelPolicyBetweenPolicyNumber(range1, range2);
	}

	@Override
	public TravelPolicy getTravelPolicyByClientName(String clientName) throws Exception {
		// TODO Auto-generated method stub
		return travelPolicyRepository.getTravelPolicyByClientName(clientName);
	}

	public List<TravelPolicy> getTravelPolicyBasedOnClientNameAndClaimDate(String clientName, String claimDate)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
		

		
	}

	@Override
	@Transactional
	public TravelPolicy linkPolicy(TravelPolicy travelPolicy, TravelInsurance travelInsurance) {
		
		travelPolicy.setTravelInsurance(travelInsurance); 
		return null;
	}

}
