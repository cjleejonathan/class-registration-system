package com.fackSchool.classRegisterSystem.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fackSchool.classRegisterSystem.entity.Register;

@Repository
@Qualifier("Register")
public interface RegisterRepository extends JpaRepository<Register, String> {

	
}
