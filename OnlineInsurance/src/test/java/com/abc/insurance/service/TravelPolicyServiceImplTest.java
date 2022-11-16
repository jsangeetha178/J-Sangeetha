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

import com.abc.insurance.entity.TravelPolicy;
import com.abc.insurance.repository.TravelPolicyRepository;

@SpringBootTest
class TravelPolicyServiceImplTest {

	private static final TravelPolicy sampleOutput = null;

	@Mock
	TravelPolicyRepository  travelPolicyRepository;
	
	@InjectMocks
	TravelPolicyServiceImpl serviceImpl;
	
	
	@Test
    @DisplayName("to verify wheather the Policy added or not")
	void testAddTravelPolicy() throws Exception{
		
        TravelPolicy sampleInput =new TravelPolicy(1,601,"Kavitha","17-05-2019","27-11-2022","Yes","11-04-2022");    

        TravelPolicy expectedOutput  =new TravelPolicy(1,601,"Kavitha","17-05-2019","27-11-2022","Yes","11-04-2022");    

        BDDMockito.given(serviceImpl.addTravelPolicy(sampleInput)).willReturn(expectedOutput);
		
        
        TravelPolicy actualOutput = serviceImpl.addTravelPolicy(sampleInput);
        
		assertEquals(expectedOutput, actualOutput);

		
	}

	@Test
	
	@DisplayName("Test to verify the method View All Policies should return Tavel policy or not")
	void testViewAllPolicy() throws Exception {
		
        TravelPolicy policy1=new TravelPolicy(1,601,"Kavitha","17-05-2019","27-11-2022","Yes","11-04-2022");    

		
        policy1.setTravelInsurance(null);
		
		TravelPolicy policy2=new TravelPolicy(2,602,"Ram","09-04-2018","15-12-2022","No","08-07-2022");
		policy2.setTravelInsurance(null);
		
		List<TravelPolicy> sampleOutput = new ArrayList<>();
		sampleOutput.add(policy1);
		sampleOutput.add(policy2);
		
		BDDMockito.given(serviceImpl.viewAllPolicy()).willReturn(sampleOutput);
		
		// ----------------------------------------------------------------------
		
		
		List<TravelPolicy> actualOutput = serviceImpl.viewAllPolicy();
		
		assertNotNull(actualOutput);
		assertThat(actualOutput.size()).isGreaterThan(0);
		assertIterableEquals(sampleOutput, actualOutput);
	}
	

	@Test
	@DisplayName("Test to verify the method Travel Policy Between Policy Number")
	void testGetTravelPolicyBetweenPolicyNumber() throws Exception{
		
		TravelPolicy policy1=new TravelPolicy(2, 601, "Kavitha", "17-11-2019", "15-08-2022", "Yes", "18-04-2022");  
		policy1.setTravelInsurance(null);
				
				
		TravelPolicy policy2=new TravelPolicy(4, 602, "Rohan", "06-08-2020", "21-11-2022", "Yes", "02-07-2022");
		policy2.setTravelInsurance(null);
				
				List<TravelPolicy> sampleOutput = new ArrayList<>();
				sampleOutput.add(policy1);
				sampleOutput.add(policy2);
				
				int sampleInput1 = 432;
				int sampleInput2 = 490;
				
				
				BDDMockito.given(serviceImpl.getTravelPolicyBetweenPolicyNumber(sampleInput1, sampleInput2))
				          .willReturn(sampleOutput);
				
				
				// when 
				
				List<TravelPolicy> actualOutput = serviceImpl.getTravelPolicyBetweenPolicyNumber(sampleInput1, sampleInput2);
				
				
				// verify 
				assertEquals(sampleOutput, actualOutput);
				assertIterableEquals(sampleOutput, actualOutput);
				assertNotNull(actualOutput);
	}
/*
	@Test
	@DisplayName("Test to verify the method Travel Policy By ClientName should return TravelPolicy or not")
	void testGetTravelPolicyByClientName() throws Exception{
		 
				TravelPolicy sampleOutput = new TravelPolicy(2, 601, "Kavitha", "17-11-2019", "15-08-2022", "Yes", "18-04-2022");
				sampleOutput.setClientName("Kavitha");

				String sampleInput = "Kavitha";

				BDDMockito.given(serviceImpl.getTravelPolicyByClientName(sampleInput)).willReturn(sampleOutput);

				// when 
				TravelPolicy actualOutput = serviceImpl.getTravelPolicyByClientName(sampleInput);

				// verify
				assertEquals(sampleOutput,actualOutput);
				assertSame(sampleOutput.getClientName(), actualOutput.getClientName());
				assertThat(actualOutput.getClientName()).isEqualToIgnoringCase(sampleInput);
	}
*/
}
