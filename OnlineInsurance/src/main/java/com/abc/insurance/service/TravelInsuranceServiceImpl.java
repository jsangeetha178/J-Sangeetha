package com.abc.insurance.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.abc.insurance.entity.TravelInsurance;
import com.abc.insurance.entity.TravelPolicy;
import com.abc.insurance.repository.TravelInsuranceRepository;
import com.abc.insurance.sorting.SortingBasedOnPremiumHighToLow;

@Service
public class TravelInsuranceServiceImpl implements TravelInsuranceService {

	@Autowired
	TravelInsuranceRepository travelInsuranceRepository;
	
	@Override
	@Transactional
	public TravelInsurance insertTravelInsurance(TravelInsurance travelInsurance) throws Exception {

		TravelInsurance savedInsurance = travelInsuranceRepository.save(travelInsurance);
		if(savedInsurance != null)
		{
			return savedInsurance;
		}
		else return null;
	}


	@Override
	public TravelInsurance updateTravelInsurance(TravelInsurance travelInsurance) throws Exception {
		
		
		return travelInsuranceRepository.save(travelInsurance);
	}
	

	@Override
	public void deleteTravelInsurance(int tId) throws Exception {
		
		 travelInsuranceRepository.deleteById(tId);
	}
	
	@Override
	public List<TravelInsurance> getAllTravelInsurance() throws Exception {
		
		List<TravelInsurance> allInsurances =  travelInsuranceRepository.findAll();
		
		return allInsurances;
	}

	@Override
	public List<TravelInsurance> getTravelInsuranceByPremium(int premium) throws Exception {
		
		
		return travelInsuranceRepository.getTravelInsuranceByPremium(premium);
	}




	@Override
	public TravelInsurance getTravelInsuranceByInsuranceName(String insuranceName) throws Exception {
		
		TravelInsurance output = travelInsuranceRepository.getTravelInsuranceByInsuranceName(insuranceName);
	
		if(output == null)
		{
			throw new EntityNotFoundException(output+"  not listed in database");
		}
		else
		{
			return output;
		}
	
	}


	@Override
	public TravelInsurance getTravelInsuranceBySumInsured(int sumInsured) throws Exception {
		
		TravelInsurance output =  travelInsuranceRepository.getTravelInsuranceBySumInsured(sumInsured);

			if(output == null)
			{
				throw new EntityNotFoundException(output+"  not listed in database");
			}
			else
			{
				return output;
			}
	
	}


	@Override
	public TravelInsurance getTravelInsuranceByLocation(String location) throws Exception {
		
		return travelInsuranceRepository.getTravelInsuranceByLocation(location);
	}


	@Override
	public TravelInsurance getTravelInsuranceBytId(int tId) throws Exception {
		
		 return travelInsuranceRepository.getTravelInsuranceBytId(tId);
	}


	@Override
	public List<TravelInsurance> findTravelInsuranceWithSorting(String field) throws Exception {
		
		return travelInsuranceRepository.findAll(Sort.by(Sort.Direction.ASC,field));
	}


	@Override
	public List<TravelInsurance> filterByInsuranaceName(String insuranceName) throws Exception {

		List<TravelInsurance> allfilteredInsuranceName=getAllTravelInsurance().stream().filter((insurance)->insurance.getInsuranceName().equals(insuranceName)).collect(Collectors.toList());
		return allfilteredInsuranceName;
	}

	@Override
	public List<TravelInsurance> filterByLocation(String location) throws Exception {

		List<TravelInsurance> allfilteredLocation=getAllTravelInsurance().stream().filter((insurance)->insurance.getLocation().equals(location)).collect(Collectors.toList());
		return allfilteredLocation;
	}
	
	@Override
	public List<TravelInsurance> filterBytId(int tId) throws Exception {

		List<TravelInsurance> allfilteredId=getAllTravelInsurance().stream().filter((insurance)->insurance.gettId()== tId).collect(Collectors.toList());
		return allfilteredId;
	}

	@Override
	public List<TravelInsurance> sortingBasedOnPremium() throws Exception {
		List<TravelInsurance> list=travelInsuranceRepository.findAll();
		List<TravelInsurance> homeInsurances=new ArrayList<>();
		Collections.sort(list,new SortingBasedOnPremiumHighToLow());
		return null;
	}








}
