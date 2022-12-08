package com.san.gtest.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.san.gtest.entity.StudentApp;

@Service
public interface StudentAppServices {

	public List<StudentApp> getAllStudents()throws Exception;
	/*public StudentApp getStudentName(String studentName)throws Exception;
	public StudentApp getRollnum(int rollNum)throws Exception;
	public StudentApp getStream(String stream)throws Exception;
	public List<StudentApp> getMarks(int r1, int r2)throws Exception;
	//public StudentApp getLocation(String location)throws Exception;
	*/
	
	public String insertStudent(StudentApp student)throws Exception;
}
