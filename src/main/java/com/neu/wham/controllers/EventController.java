package com.neu.wham.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.wham.messages.EventPostResponse;
import com.neu.wham.messages.EventPostResponse.Status;
import com.neu.wham.model.Event;
import com.neu.wham.services.NewEventService;

@Controller
public class EventController {
	@Autowired
	private NewEventService newEventService;
	
	@RequestMapping(value = "/newevent", method = RequestMethod.POST)
	public @ResponseBody EventPostResponse firstRequest(@Valid @ModelAttribute Event event, BindingResult result, HttpServletRequest req, HttpServletResponse resp){

		if(result.hasErrors()){
			EventPostResponse errRes = new EventPostResponse();
			errRes.setMsg(result.getAllErrors().toString());
			errRes.setStatus(Status.ERROR);
			return errRes;
		}
		System.out.println(event);
		return newEventService.submitNewEvent(event);
	}
}
