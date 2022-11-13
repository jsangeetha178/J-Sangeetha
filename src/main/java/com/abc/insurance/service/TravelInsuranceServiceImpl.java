package com.abc.insurance.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.insurance.entity.TravelInsurance;
import com.abc.insurance.entity.TravelPolicy;
import com.abc.insurance.repository.TravelInsuranceRepository;

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
		
		List<TravelInsurance> allInsurances = (List<TravelInsurance>) travelInsuranceRepository.findAll();
		
		return allInsurances;
	}

	@Override
	public List<TravelInsurance> getTravelInsuranceByPremium(int premium) throws Exception {
		
		
		return travelInsuranceRepository.getTravelInsuranceByPremium(premium);
	}




	@Override
	public TravelInsurance getTravelInsuranceByInsuranceName(String insuranceName) throws Exception {
		
		return travelInsuranceRepository.getTravelInsuranceByInsuranceName(insuranceName);
	}


	@Override
	public TravelInsurance getTravelInsuranceBySumInsured(int sumInsured) throws Exception {
		
		return travelInsuranceRepository.getTravelInsuranceBySumInsured(sumInsured);
	}


	@Override
	public TravelInsurance getTravelInsuranceByLocation(String location) throws Exception {
		
		return travelInsuranceRepository.getTravelInsuranceByLocation(location);
	}


	@Override
	public TravelInsurance getTravelInsuranceBytId(int tId) throws Exception {
		
		 return travelInsuranceRepository.getTravelInsuranceBytId(tId);
	}


//	@Override
//	@Transactional
//	public TravelInsurance linkPolicy(TravelPolicy travelPolicy, TravelInsurance travelInsurance) {
//		travelInsurance.setTravelPolicy(travelPolicy); 
//		return travelInsurance;
//	}



}
