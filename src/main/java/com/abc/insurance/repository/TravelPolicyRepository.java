package com.abc.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.insurance.entity.TravelPolicy;

@Repository
public interface TravelPolicyRepository extends JpaRepository<TravelPolicy, Integer>, TravelPolicyCustomRepository{

}
