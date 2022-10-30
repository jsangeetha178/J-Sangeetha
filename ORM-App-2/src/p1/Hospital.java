package p1;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

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
@NoArgsConstructor
@ToString

@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Hospital_Name")
	private String name;
	
	private String registrationNumber;
	
	
	@ElementCollection
	@CollectionTable(name = "DoctorDetails")
	private List<Doctors> doctor;
	
	
	@OneToOne(mappedBy = "hospital", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Kid kid;


	public Hospital( String name, String registrationNumber) {
		super();
		
		this.name = name;
		this.registrationNumber = registrationNumber;
	}
}
