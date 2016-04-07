package com.neu.wham.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.wham.messages.EventPostResponse;
import com.neu.wham.messages.EventPostResponse.Status;
import com.neu.wham.model.Event;
import com.neu.wham.model.User;
import com.neu.wham.services.UserRegistrationService;

@Controller
public class UserRegistrationController {
	@Autowired
	private UserRegistrationService registrationService;
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public @ResponseBody User registerUser(@Valid @ModelAttribute User user, BindingResult result){
		if(result.hasErrors()){
			return null;
		}
		return registrationService.registerUser(user);
	}
	
	@RequestMapping(value="/validateUser",method=RequestMethod.POST)
	public @ResponseBody User validateUser(@RequestParam("emailId") String emailId, @RequestParam("password") String password){
		if(emailId== null ||  password == null ||emailId.isEmpty() || password.isEmpty()){
			return null;
		}
		return registrationService.validateUser(emailId, password);
	}
	
}
