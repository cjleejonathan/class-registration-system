package com.fackSchool.classRegisterSystem.service;

import java.util.List;

import com.fackSchool.classRegisterSystem.entity.Course;

public interface CourseService {

	public List<Course> findAll();

	public Course findById(String theId);

	public List<Course> serchBy(String theCourseId, String theCourseName);
}
