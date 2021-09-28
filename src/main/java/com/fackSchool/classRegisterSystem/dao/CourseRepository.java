package com.fackSchool.classRegisterSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fackSchool.classRegisterSystem.entity.Course;
import com.fackSchool.classRegisterSystem.entity.Student;

@Repository
@Qualifier("Course")
public interface CourseRepository extends JpaRepository<Course, String> {

	public List<Course> findByIdContainsAndCourseNameContainsAllIgnoreCase(
			String theCourseId,String theCourseName);
}
