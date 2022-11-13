package com.abc.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.abc.insurance.entity.TravelPolicy;

@Repository
public interface TravelPolicyCustomRepository {

	@Query("from TravelPolicy where policyNumber >= :range1 and policyNumber <= :range2")
	public List<TravelPolicy> getTravelPolicyBetweenPolicyNumber(@Param("range1") int range1,@Param("range2") int range2) throws Exception;

	public TravelPolicy getTravelPolicyByClientName(String clientName) throws Exception;

}
