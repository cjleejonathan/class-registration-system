package com.fackSchool.classRegisterSystem.service;

import java.util.List;

import com.fackSchool.classRegisterSystem.entity.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void save(Student theStudent);
	
	public void deleteById(int theId);
	
	public List<Student> serchBy(String theFirstName, String theLastName);
}
