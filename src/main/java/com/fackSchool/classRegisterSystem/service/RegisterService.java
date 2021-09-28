package com.fackSchool.classRegisterSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fackSchool.classRegisterSystem.dao.RegisterRepository;
import com.fackSchool.classRegisterSystem.entity.Course;
import com.fackSchool.classRegisterSystem.entity.Register;
import com.fackSchool.classRegisterSystem.entity.Student;


public interface RegisterService {

	public void save(Register theRegister);
	
	public Register findByEmail(String theEmail);
	
	public List<Register> serchBy(String theEmail);
}
