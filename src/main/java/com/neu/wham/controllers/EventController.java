package com.neu.wham.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.wham.messages.EventPostResponse;
import com.neu.wham.model.Event;
import com.neu.wham.services.NewEventService;

@Controller
public class EventController {
	@Autowired
	private NewEventService newEventService;
	
	@RequestMapping(value = "/newevent", method = RequestMethod.POST)
	public @ResponseBody EventPostResponse firstRequest(@Valid @ModelAttribute Event event, BindingResult result){
		System.out.println("*****HIT*******");
		if(result.hasErrors()){
			System.out.println(" ****** It has errors ******");
			System.out.println(result.getAllErrors());
		}
		System.out.println(event);
		/*
		Event sampleEvent = new Event();
		sampleEvent.setEmailId("bvijet@gmail.com");
		sampleEvent.setEndDate(new Date());
		sampleEvent.setEndTime(new Date());
		sampleEvent.setEventDesc("event desc");
		sampleEvent.setEventLocation("1600 Amphitheatre Parkway Mountain View, CA 94043");
		sampleEvent.setCreationTime(new Date());
		sampleEvent.setLastUpdateTime(new Date());
		sampleEvent.setStartDate(new Date());
		sampleEvent.setStartTime(new Date());
		sampleEvent.setFilePath("aaa");
		sampleEvent.setEventName("saome name");
		sampleEvent.setOrganiserName("sss");
		sampleEvent.setOrganiserDesc("orgDesc");
		sampleEvent.setOfficialEvent(true);
		*/
		return newEventService.submitNewEvent(event);
		//return response;
	}
}
