package com.fackSchool.classRegisterSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fackSchool.classRegisterSystem.entity.Student;

@Repository
@Qualifier("student")
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
		// add a method to sort by last name
		public List<Student> findAllByOrderByLastNameAsc();;
		
		// add a method to search by first name and last name
		public List<Student> findByFirstNameContainsAndLastNameContainsAllIgnoreCase(
				String theFirstName,String theLastName);	
}
