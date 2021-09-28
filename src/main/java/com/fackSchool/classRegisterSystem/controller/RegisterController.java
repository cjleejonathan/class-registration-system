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

import com.fackSchool.classRegisterSystem.entity.Course;
import com.fackSchool.classRegisterSystem.entity.Register;
import com.fackSchool.classRegisterSystem.service.RegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	private RegisterService registerService;
	
	public RegisterController(RegisterService theRegisterService) {
		registerService = theRegisterService;
	}
	
	@GetMapping("/list")
	public String search(Model theModel) {
	
		List<Register> theRegister = registerService.serchBy("test@gmail.com");
			
		// add to the spring model
		theModel.addAttribute("register", theRegister);
			
		// send to list-students
		return "students/my-course";
		
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Register theRegister = new Register();
		
		theModel.addAttribute("register", theRegister);
		
		return "courses/register-form";
	}
	
	@PostMapping("/save")
	public String saveRegister(
			@ModelAttribute("register") @Valid Register theRegister,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "courses/register-form";
		}
		else {		
			// save the employee
			registerService.save(theRegister);
			
			// use a redirect to prevent duplicate submissions
			return "redirect:/courses/list";
		}
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("email") String theEmail, Model theModel) {
		
		List<Register> theRegister = registerService.serchBy(theEmail);
			
		theModel.addAttribute("register", theRegister);
			
		return "courses/list-courses";
		
	}
	
	
	
}
