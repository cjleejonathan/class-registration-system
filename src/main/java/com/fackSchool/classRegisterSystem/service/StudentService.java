package com.fackSchool.classRegisterSystem.service;

import java.util.List;

import com.fackSchool.classRegisterSystem.entity.student;

public interface StudentService {

	public List<student> findAll();
	
	public student findById(int theId);
	
	public void save(student theStudent);
	
	public void deleteById(int theId);
	
	public List<student> serchBy(String theFirstName, String theLastName);
}
