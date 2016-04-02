package com.neu.wham.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.wham.model.User;
import com.neu.wham.services.UserRegistrationService;

@Controller
public class UserRegistrationController {
	@Autowired
	private UserRegistrationService registrationService;
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public void registerUser(@ModelAttribute User user){
		
	}
}
