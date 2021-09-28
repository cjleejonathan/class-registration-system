package com.fackSchool.classRegisterSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fackSchool.classRegisterSystem.dao.RegisterRepository;
import com.fackSchool.classRegisterSystem.entity.Register;

@Service
public class RegisterServiceImpl implements RegisterService{

	private RegisterRepository registerRepository;
	
	@Autowired
	public RegisterServiceImpl(RegisterRepository theRegisterRepository) {
		registerRepository = theRegisterRepository;
	}
	
	@Override
	public void save(Register theRegister) {
		registerRepository.save(theRegister);	
	}
}
