package com.abc.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.insurance.entity.TravelInsurance;

@Repository
public interface TravelInsuranceRepository extends JpaRepository<TravelInsurance, Integer> , TravelInsuranceCustomRepository{

}
