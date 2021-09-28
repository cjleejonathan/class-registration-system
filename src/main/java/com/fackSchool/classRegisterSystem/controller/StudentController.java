package com.fackSchool.classRegisterSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fackSchool.classRegisterSystem.entity.Student;
import com.fackSchool.classRegisterSystem.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;
	
	public StudentController(StudentService theStudentService) {
		studentService = theStudentService;
	}
	
	// add mapping for "/list"
	
	@GetMapping("/list")
	public String listStudents(Model theModel) {
		
		// get students from db
		List<Student> theStudent = studentService.findAll();
		
		// add to spring model
		theModel.addAttribute("students", theStudent);
		
		return "students/list-students";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Student theStudent = new Student();
		
		theModel.addAttribute("student", theStudent);
		
		return "students/student-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, 
									Model theModel) {
		
		// get the student from the service
		Student theStudent = studentService.findById(theId);
		
		// set student as a model attribute to pre-populate the form
		theModel.addAttribute("student", theStudent);
		
		// send over to our form
		return "students/student-form";
		
	}
	
	@PostMapping("/save")
	public String saveStudent(
			@ModelAttribute("student") @Valid Student theStudent,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {		
			return "students/student-form";
		}
		else {
			// save the student
			studentService.save(theStudent);
			
			// use a redirect to prevent duplicate submissions
			return "redirect:/students/list";
		}
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		
		// delete the student
		studentService.deleteById(theId);
		
		// redirect to /students/list
		return "redirect:/students/list";
		
	}
	
	
	@GetMapping("/search")
	public String search(@RequestParam("firstName") String theFirstName,
						 @RequestParam("lastName") String theLastName, 
						 Model theModel) {
		
		// check names, if both are empty then just give list of all students
		
		if (theFirstName.trim().isEmpty() && theLastName.trim().isEmpty()) {
			return "redirect:/students/list";
		}
		else {	
			// else, search by first name and last name
			List<Student> theStudent = 
							studentService.serchBy(theFirstName, theLastName);
			
			// add to the spring model
			theModel.addAttribute("students", theStudent);
			
			// send to list-students
			return "students/list-students";
		}
	}
}
