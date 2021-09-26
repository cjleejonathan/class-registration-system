package com.fackSchool.classRegisterSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fackSchool.classRegisterSystem.entity.student;

@Repository
@Qualifier("student")
public interface StudentRepository extends JpaRepository<student, Integer> {
	
		// add a method to sort by last name
		public List<student> findAllByOrderByLastNameAsc();;
		
		// add a method to search by first name and last name
		public List<student> findByFirstNameContainsAndLastNameContainsAllIgnoreCase(
				String theFirstName,String theLastName);	
}
