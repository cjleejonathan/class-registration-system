package com.fackSchool.classRegisterSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="register")
public class Register {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="number")
	private int number;
	
	@Column(name="student_email")
	private String email;
	
	@Column(name="course_id")
	private String id;
	
	public Register() {
		
	}
	
	public Register(String email, String id) {
		this.email = email;
		this.id = id;
	}
	
	public Register(int number, String email, String id) {
		this.number = number;
		this.email = email;
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Register [number=" + number + ", email=" + email + ", id=" + id + "]";
	}

	
	
	
}
