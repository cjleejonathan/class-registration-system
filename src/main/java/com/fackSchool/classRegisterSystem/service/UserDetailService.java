package com.fackSchool.classRegisterSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fackSchool.classRegisterSystem.dao.UserRepository;
import com.fackSchool.classRegisterSystem.entity.Student;

@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Student student = userRepository.findByEmail(username);
        if (student == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User.withUsername(student.getEmail()).password(student.getPassword()).authorities("USER").build();
        return user;
    }
}
