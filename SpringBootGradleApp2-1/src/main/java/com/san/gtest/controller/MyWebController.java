package com.san.gtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.san.gtest.entity.StudentApp;
import com.san.gtest.services.StudentAppServices;

@RestController
@RequestMapping("/students")
public class MyWebController {

	@Autowired
	StudentAppServices studentService;

	public MyWebController() {

		System.out.println("\n\n\n======> Inside Constructor" + this);

	}
/*
	@GetMapping("/name/{searchStudentname}")
	public StudentApp abc(@PathVariable String searchStudentname) throws Exception {

		return studentService.getStudentName(searchStudentname);
	}
	

	@GetMapping("/rollnumber/{searchStudentrollnumber}")
	public StudentApp abc1(@PathVariable int searchStudentrollnumber) throws Exception {

		return studentService.getRollnum(searchStudentrollnumber);
	}
	

	@GetMapping("/stream/{searchStudentstream}")
	public StudentApp abc2(@PathVariable String searchStudentstream) throws Exception {

		return studentService.getStream(searchStudentstream);
	}
	
	

	@GetMapping("/marks/{searchStudentmarks}")
	public List<StudentApp> abc3(@PathVariable int searchStudentmarks) throws Exception {

		return studentService.getMarks(searchStudentmarks, searchStudentmarks);
	}

	
	@GetMapping("/location/{searchStudentlocation}")
	public StudentApp abc4(@PathVariable String searchStudentlocation) throws Exception {

		return studentService.getLocation(searchStudentlocation);
	}*/
	
	
	@GetMapping("/details")
	public List<StudentApp> getAllStudents() {

		try {
			List<StudentApp> allExtractedStudent = studentService.getAllStudents();

			return allExtractedStudent;

		} catch (Exception e) {

			System.out.println(e);

		}
		return null;

	}
	
	
	@PostMapping("/student")
	public String addStudent(@RequestBody StudentApp student) {
		
		try {
			
			return studentService.insertStudent(student);
		}catch(Exception e) {
			
			return"Contact to management 1800-250-960 or mail us :- abc@gmail.com";
		}
	}

}