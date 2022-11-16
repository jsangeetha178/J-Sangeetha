package com.abc.insurance.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	public List<TravelPolicy> viewAllPolicy() throws Exception {

		List<TravelPolicy> allpolicies = travelPolicyRepository.findAll();
		
		return allpolicies;
	}

	@Override
	public List<TravelPolicy> getTravelPolicyBetweenPolicyNumber(int range1, int range2) throws Exception {
		
		return travelPolicyRepository.getTravelPolicyBetweenPolicyNumber(range1, range2);
	}

	@Override
	public TravelPolicy getTravelPolicyByClientName(String clientName) throws Exception {
		
		TravelPolicy output = travelPolicyRepository.getTravelPolicyByClientName(clientName);
	
		if(output == null)
		{
			throw new EntityNotFoundException(output+" not found in the database");
		}
		else
		{
			return output;
		}
	}

	@Override
	public List<TravelPolicy> getTravelPolicyBasedOnClientNameAndClaimDate(String clientName, String claimDate)throws Exception {
		
		return ((TravelPolicyServiceImpl) travelPolicyRepository).getTravelPolicyBasedOnClientNameAndClaimDate(clientName, claimDate);
		
	}

	@Override
	@Transactional
	public TravelPolicy linkInsurance(TravelPolicy travelPolicy, TravelInsurance travelInsurance) {
		
		travelPolicy.setTravelInsurance(travelInsurance); 
		
		return travelPolicy;
	}

	@Override
	public List<TravelPolicy> findTravelPolicyWithSorting(String field) throws Exception {
		
		return travelPolicyRepository.findAll(Sort.by(Sort.Direction.DESC,field));
	}

	@Override
	public List<TravelPolicy> filterByClientName(String clientName) throws Exception {
		List<TravelPolicy> allfilteredClientName=viewAllPolicy().stream().filter((policy)->policy.getClientName().equals(clientName)).collect(Collectors.toList());
		return allfilteredClientName;
		
	}

}
