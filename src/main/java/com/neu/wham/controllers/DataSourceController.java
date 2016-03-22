package com.neu.wham.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.wham.exceptions.LocationException;
import com.neu.wham.model.Event;
import com.neu.wham.services.GetEventService;
import com.neu.wham.validations.KeywordValidation;
import com.neu.wham.validations.LocationValidation;


@Controller
public class DataSourceController {
	@Autowired
	private GetEventService getEventService;
	
	 @RequestMapping(value = "/datasource", method = RequestMethod.GET)
	 public @ResponseBody String secondRequest(){
			System.out.println("Hitting Second Request");
			return "{Error:/'Invalid-input/'}";
		}
	
	@RequestMapping(value = "/datasource/{lat}/{lon}/{rad}", method = RequestMethod.GET)
	public @ResponseBody List<Event> firstRequest(@PathVariable String lat, @PathVariable String lon, 
			@PathVariable String rad, @RequestParam(required=false) String q) throws LocationException {

		LocationValidation.validateLatitude(lat);
		LocationValidation.validateLongitude(lon);
		LocationValidation.validateRadius(rad);
		q = KeywordValidation.validateKeyword(q);
		
		return getEventService.getEvents(lat, lon, rad, q);
	}
   
}
