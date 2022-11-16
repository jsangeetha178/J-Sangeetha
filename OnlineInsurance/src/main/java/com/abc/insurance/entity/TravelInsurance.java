package com.abc.insurance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TravelInsurance")
public class TravelInsurance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int tId;
	
	@NotBlank (message = "Insurance Name  cannot be Blank")
	private String insuranceName;

	@Email(message = "Not a valid email")
	private String email;

	@NotNull(message = "Location cannot be null")
	private String location;

	@NotNull(message = "Medical Purpose mention(Yes/No")
	private  String isMedicalNeed;
	
	@NotNull(message = "Lost Belongings mention(Yes/No")
	private String isLostBelongings;
	
	@NotNull(message = "Cancellation mention(Yes/No")
    @Pattern(regexp = "^true$|^false$", message = "allowed input: true or false")
	private String cancellation;
	
	
	@PositiveOrZero(message = "Invalid Premium Amount")
	private int premium;

	@PositiveOrZero(message = "Invalid SumInsured")
	private int sumInsured;


	

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	

	

}
