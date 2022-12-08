package com.san.gtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.san.gtest.entity.StudentApp;

@Repository
public interface StudentAppRepository extends JpaRepository<StudentApp, Integer>, IStudentAppCustomRepository
{

	

}
