package com.fackSchool.classRegisterSystem.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Register findByEmail(String theEmail) {
		Optional<Register> result = registerRepository.findById(theEmail);
		
		Register theRegister = null;
		
		if(result.isPresent()) {
			theRegister = result.get();
		}else {
			throw new RuntimeException("Did not find course" + theEmail);
		}
		
		return theRegister;
	}
	
	@Override
	public List<Register> serchBy(String theEmail) {
		
		return registerRepository.findByEmailContains(
				theEmail);
				
	}
	
}
