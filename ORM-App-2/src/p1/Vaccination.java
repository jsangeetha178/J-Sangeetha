package p1;

import javax.persistence.Embeddable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Embeddable
public class Vaccination {

	private String doseName;

	private String vaccinationDate;
	private String nextDoseName;
	private String nextVaccinationDate;
	private String remarks;
	private int cost;
	
}
