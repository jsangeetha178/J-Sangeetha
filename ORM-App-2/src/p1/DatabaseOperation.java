package p1;

import java.time.LocalDate;


import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class DatabaseOperation {
	
	public static void main(String[] args) {
		
		Session hibernate = HibernateConnection.getHibernateLink();
		
		
		//Kid k1 = new Kid("Leo","Male",8,LocalDate.of(2020, 8, 11).toString());
	
		Parent p = new Parent("Arjun","Radha",8885697425L);
	
		Parent g = new Parent("Bhasker","Savithri",9369745821L);
		
		
		
		Vaccination v1 = new Vaccination("A8",LocalDate.of(2020, 3, 17).toString(),"A8",LocalDate.of(2020, 8, 20).toString(),"Good",1500);
		Vaccination v2 = new Vaccination("p6",LocalDate.of(2021, 2, 5).toString(),"p6",LocalDate.of(2021, 9, 9).toString(),"Good",900);
		//Vaccination v3 = new Vaccination("kk9",LocalDate.of(2021, 1, 20).toString(),"kk9",LocalDate.of(2021, 3, 17).toString(),"Good",1250);
		
		List<Vaccination> AllVaccinationCertificates = Arrays.asList(v1,v2);

		Kid k1 = new Kid("Kavitha","Female",15,LocalDate.of(2019, 10, 17).toString());
		
		
		Hospital h1 = new Hospital("Apollo","OIM14785");
		
		Doctors d = new Doctors("Remo","Male","Paetiatrician", 9875469311L);
		List<Doctors>DoctorDetails = Arrays.asList(d);
		
		
		
		k1.setId(2);
		k1.setParent(p);
		k1.setGrandParent(g);
		k1.setVaccinationCard(AllVaccinationCertificates);
		h1.setDoctor(DoctorDetails);
		k1.setHospital(h1);
		
		insertKid(hibernate, k1);
	
	
	}
		public static void insertKid(Session hibernate, Kid k) {

			Transaction t1 = hibernate.beginTransaction();

			hibernate.save(k); 
			

			t1.commit();
			hibernate.close();
			

			System.out.println(" 5. Database commit & hibernate closed ...");
		}
		
		
	}
	
	


