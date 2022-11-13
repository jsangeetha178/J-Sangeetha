package com.abc.insurance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TravelInsurance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int tId;
	private String insuranceName;

	@Email(message = "Not a valid email")
	private String email;

	@NotNull(message = "Location cannot be null")
	private String location;

	private int premium;

	private int sumInsured;


	

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	

	

}
