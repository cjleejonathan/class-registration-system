package com.fackSchool.classRegisterSystem.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fackSchool.classRegisterSystem.entity.Register;
import com.fackSchool.classRegisterSystem.service.RegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	private RegisterService registerService;
	
	public RegisterController(RegisterService theRegisterService) {
		registerService = theRegisterService;
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
	
	
	
}
