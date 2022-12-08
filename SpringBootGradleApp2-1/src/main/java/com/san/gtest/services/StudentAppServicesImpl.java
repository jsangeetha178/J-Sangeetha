package com.san.gtest.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.san.gtest.entity.StudentApp;
import com.san.gtest.repository.StudentAppRepository;

@Service
public class StudentAppServicesImpl implements StudentAppServices{

	@Autowired
	StudentAppRepository studentRepository;

	@Override
	public List<StudentApp> getAllStudents() throws Exception {
		// TODO Auto-generated method stub
		List<StudentApp> allStudents = studentRepository.findAll();
		return allStudents;
	}

	/*@Override
	public StudentApp getStudentName(String studentName) throws Exception {
		// TODO Auto-generated method stub
		return studentRepository.getStudentName(studentName);
	}

	@Override
	public StudentApp getRollnum(int rollNum) throws Exception {
		// TODO Auto-generated method stub
		return studentRepository.getRollnum(rollNum);
	}

	@Override
	public StudentApp getStream(String stream) throws Exception {
		// TODO Auto-generated method stub
		return studentRepository.getStream(stream);
	}

	@Override
	public List<StudentApp> getMarks(int r1, int r2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	//public StudentApp getLocation(String location) throws Exception {
		// TODO Auto-generated method stub
	//	return studentRepository.getLocation(location);
	//}

*/
	
	public String insertStudent(StudentApp student) throws Exception {
		
		StudentApp savedStudent = studentRepository.save(student);
		if(savedStudent != null)
		{
			return "Student Saved"+savedStudent.getStudentName()+"StudentName : -"+savedStudent.getStudentName();
		}
		else return null;
	}

	
}