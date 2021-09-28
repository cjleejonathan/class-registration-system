package com.fackSchool.classRegisterSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fackSchool.classRegisterSystem.dao.StudentRepository;
import com.fackSchool.classRegisterSystem.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
	public StudentServiceImpl(StudentRepository theStudentRepository) {
		studentRepository = theStudentRepository;
	}
	
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int theId) {
		Optional<Student> result = studentRepository.findById(theId);
		
		Student theStudent = null;
		
		if(result.isPresent()) {
			theStudent = result.get();
		}
		else {
			
			throw new RuntimeException("Did not find student id -" + theId);
		}
		
		return theStudent;
	}

	@Override
	public void save(Student theStudent) {
		theStudent.setPassword(passwordEncoder.encode(theStudent.getPassword()));
		studentRepository.save(theStudent);	
	}

	@Override
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);
		
	}

	@Override
	public List<Student> serchBy(String theFirstName, String theLastName) {
		
		return studentRepository.
				findByFirstNameContainsAndLastNameContainsAllIgnoreCase(
						theFirstName, theLastName);	
	}
	
	
	

}




