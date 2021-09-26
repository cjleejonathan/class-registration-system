package com.fackSchool.classRegisterSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fackSchool.classRegisterSystem.dao.StudentRepository;
import com.fackSchool.classRegisterSystem.entity.student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository theStudentRepository) {
		studentRepository = theStudentRepository;
	}
	
	@Override
	public List<student> findAll() {
		return studentRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public student findById(int theId) {
		Optional<student> result = studentRepository.findById(theId);
		
		student theStudent = null;
		
		if(result.isPresent()) {
			theStudent = result.get();
		}
		else {
			
			throw new RuntimeException("Did not find student id -" + theId);
		}
		
		return theStudent;
	}

	@Override
	public void save(student theStudent) {
		studentRepository.save(theStudent);	
	}

	@Override
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);
		
	}

	@Override
	public List<student> serchBy(String theFirstName, String theLastName) {
		
		return studentRepository.
				findByFirstNameContainsAndLastNameContainsAllIgnoreCase(
						theFirstName, theLastName);	
	}

}




