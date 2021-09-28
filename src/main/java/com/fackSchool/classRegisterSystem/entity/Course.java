package com.fackSchool.classRegisterSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@Column(name="course_id")
	private String id;
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="proffesor")
	private String proffesor;
	
	public Course(){
		
	}

	
	public Course(String id, String courseName, String proffesor) {
		this.id = id;
		this.courseName = courseName;
		this.proffesor = proffesor;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getProffesor() {
		return proffesor;
	}

	public void setProffesorId(String proffesorId) {
		this.proffesor = proffesorId;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", proffesorId=" + proffesor + "]";
	}

	
	
}
