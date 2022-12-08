package com.san.gtest.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class StudentApp {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	
	
	private  String studentName;
	private int rollNumber;
	private int marks;
	private String stream;
	//private String location;
	
	


	public StudentApp(String studentName, int rollNumber, int marks, String stream) {
		super();
		this.studentName = studentName;
		this.rollNumber = rollNumber;
		this.marks = marks;
		this.stream = stream;
		//this.location = location;
	}


}
