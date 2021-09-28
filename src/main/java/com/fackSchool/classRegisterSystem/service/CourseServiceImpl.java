package com.fackSchool.classRegisterSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fackSchool.classRegisterSystem.dao.CourseRepository;
import com.fackSchool.classRegisterSystem.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;
	
	@Autowired
	public CourseServiceImpl(CourseRepository theCourseRepository) {
		courseRepository = theCourseRepository;
	}
	
	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course findById(String theId) {
		Optional<Course> result = courseRepository.findById(theId);
		
		Course theCourse = null;
		
		if(result.isPresent()) {
			theCourse = result.get();
		}else {
			throw new RuntimeException("Did not find course" + theId);
		}
		
		return theCourse;
	}

	@Override
	public List<Course> serchBy(String theCourseId, String theCourseName) {
		
		return courseRepository.findByIdContainsAndCourseNameContainsAllIgnoreCase(
				theCourseId, theCourseName);
				
	}

}
