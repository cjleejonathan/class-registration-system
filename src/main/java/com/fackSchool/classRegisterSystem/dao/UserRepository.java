package com.fackSchool.classRegisterSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fackSchool.classRegisterSystem.entity.Student;

@Repository
public interface UserRepository extends JpaRepository <Student, String> {
	
		Student findByEmail(String email);
}
