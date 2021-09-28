package com.fackSchool.classRegisterSystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fackSchool.classRegisterSystem.entity.Course;
import com.fackSchool.classRegisterSystem.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private CourseService courseService;
	
	public CourseController(CourseService theCourseService) {
		courseService = theCourseService;
	}
	
	// add mapping for "/list"
	
	@GetMapping("/list")
	public String listCourses(Model theModel) {
		
		//get course from db
		List<Course> theCourse = courseService.findAll();
		
		// add to spring model
		theModel.addAttribute("courses", theCourse);
		
		return "courses/list-courses";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("id") String theId, @RequestParam("courseName") String theCourseName, Model theModel) {
		
		if(theId.trim().isEmpty() && theCourseName.trim().isEmpty()) {
			return "redirect:/courses/list";
		}
		else {
			List<Course> theCourse = courseService.serchBy(theId, theCourseName);
			
			theModel.addAttribute("courses", theCourse);
			
			return "courses/list-courses";
		}
	}
}
