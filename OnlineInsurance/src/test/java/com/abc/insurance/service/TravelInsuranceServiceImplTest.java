package com.abc.insurance.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.insurance.entity.TravelInsurance;
import com.abc.insurance.repository.TravelInsuranceRepository;

@SpringBootTest
class TravelInsuranceServiceImplTest {


	@Mock
	TravelInsuranceRepository travelInsuranceRepository;

	@InjectMocks
	TravelInsuranceServiceImpl travelInsuranceService;
	
	@Test
	@DisplayName("To Verify whether the Insurance is added or not")
	void testInsertTravelInsurance() throws Exception{
		
		TravelInsurance sampleInput = new TravelInsurance(1, "Trip Cancellation", "kavitha@gmail.com", "Delhi", "N0", "No", "Yes",5000, 25000);
		TravelInsurance expectedOutput = new TravelInsurance(1, "Trip Cancellation", "kavitha@gmail.com", "Delhi", "N0", "No", "Yes",5000, 25000);
	     
		BDDMockito.given(travelInsuranceService.insertTravelInsurance(sampleInput)).willReturn(expectedOutput);
		
		TravelInsurance actualOutput = travelInsuranceService.insertTravelInsurance(sampleInput);
		
		
		assertEquals(expectedOutput, actualOutput);
	
	}

	@Test
	@Disabled
	void testUpdateTravelInsurance() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDeleteTravelInsurance() {
		fail("Not yet implemented");
	}

	@Test
	@DisplayName("To verify All Insurances are returned")
	void testGetAllTravelInsurance() throws Exception {
		
		TravelInsurance sampleInput1 = new TravelInsurance(1, "Trip Cancellation", "kavitha@gmail.com", "Delhi", "N0", "No", "Yes",5000, 25000);
		TravelInsurance sampleInput2 = new TravelInsurance(2, "Lost Luggeage", "Rohan@gmail.com", "Vizag", "No", "Yes", "No",6000, 20000);
	
		List<TravelInsurance> sampleOutput = new ArrayList<>();
		sampleOutput.add(sampleInput1);
		sampleOutput.add(sampleInput2);
	
		BDDMockito.given(travelInsuranceService.getAllTravelInsurance()).willReturn(sampleOutput);
		
		List<TravelInsurance>actualOutput = travelInsuranceService.getAllTravelInsurance();
		
		
		assertNotNull(actualOutput);
		assertThat(actualOutput.size()).isGreaterThan(0);
		assertIterableEquals(sampleOutput, actualOutput);
	}

	@Test
	@Disabled
	void testGetTravelInsuranceByPremium() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetTravelInsuranceByInsuranceName() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetTravelInsuranceBySumInsured() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetTravelInsuranceByLocation() {
		fail("Not yet implemented");
	}

	@Test
	@DisplayName("Test to verify the method Insurance by Id should return Travel Insurance or not")
	void testGetTravelInsuranceBytId() throws Exception {
		
		   
		        
		        TravelInsurance sampleOutput = new TravelInsurance(1, "Trip Cancellation", "kavitha@gmail.com", "Delhi", "N0", "No", "Yes",5000, 25000);
		        sampleOutput.settId(1);
		        
		        int sampleInput = 1;
		        
		        BDDMockito.given(travelInsuranceService.getTravelInsuranceBytId(sampleInput)).willReturn(sampleOutput);
		        
		       
		        TravelInsurance actualOutput = travelInsuranceService.getTravelInsuranceBytId(sampleInput);
		        
		        
		        assertEquals(sampleOutput,actualOutput);
		        assertSame(sampleOutput.gettId(), actualOutput.gettId());
		        assertThat(actualOutput.gettId()).isGreaterThan(0);
		        
		
	}

}