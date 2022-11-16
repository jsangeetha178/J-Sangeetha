package com.abc.insurance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "InsurancePolicy")
public class TravelPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int policyId;
	private int policyNumber;
	
	@NotNull(message = "client Name cannot be Null")
	@Size(min = 2,message = "Name is not valid, should have more than 2 characters")
	private String clientName;

	private String dateOfPurchase;
	private String dateOfExpire;
	private String isClaimed;
	private String claimDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TravelInsurance")
	private TravelInsurance travelInsurance;

	
	public TravelPolicy( int policyId, int policyNumber, String clientName, String dateOfPurchase,String dateOfExpire, String isClaimed, String claimDate) {
		super();
	
		this.policyId = policyId;
		this.policyNumber = policyNumber;
		this.clientName = clientName;
		this.dateOfPurchase = dateOfPurchase;
		this.dateOfExpire = dateOfExpire;
		this.isClaimed = isClaimed;
		this.claimDate = claimDate;
	}
	

}
