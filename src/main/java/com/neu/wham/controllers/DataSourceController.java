package com.neu.wham.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import com.neu.wham.exceptions.LocationException;
import com.neu.wham.model.Event;
import com.neu.wham.services.GetEventService;
import com.neu.wham.validations.KeywordValidation;
import com.neu.wham.validations.LocationValidation;


@Controller
public class DataSourceController {
	@Autowired
	private GetEventService getEventService;
	
	// for test
	public DataSourceController() {
		// TODO Auto-generated constructor stub
	}
	
	// for test
	@Autowired
	public DataSourceController(GetEventService getEventService) {
		// TODO Auto-generated constructor stub
		this.getEventService = getEventService;
	}
	 
	 @RequestMapping(value = "*", method = RequestMethod.GET)
	 @ResponseStatus(value = HttpStatus.NOT_FOUND)
     public @ResponseBody String secondRequest(){
            System.out.println("Hitting Second Request: not three parameters");
            return "{Error: Coordinates are not valid. Please specify one latitude, one longitude, and one radius}";
        }
	
	@RequestMapping(value = "/datasource/{lat}/{lon}/{rad}", method = RequestMethod.GET)
	public @ResponseBody List<Event> firstRequest(@PathVariable String lat, @PathVariable String lon, 
			@PathVariable String rad, @RequestParam(required=false) String q) throws LocationException {

		LocationValidation.validateLatitude(lat);
		LocationValidation.validateLongitude(lon);
		if(!LocationValidation.validateRadius(rad)){
			rad = "10";
		}
		q = KeywordValidation.validateKeyword(q);
		
		System.out.println("q:" + q);
		
		System.out.println("from controller to service");
		
		
		List<Event> eventResults = getEventService.getEvents(lat, lon, rad, q);
//		System.out.println(eventResults);
		
		return eventResults;
	}
   
}
