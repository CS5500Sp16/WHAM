package com.neu.wham.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.wham.model.Location;
import com.neu.wham.services.LookupService;

@Controller
public class LookupController {
	
	
	
	@Autowired
	private LookupService lookupService;
	
	@RequestMapping(value = "/lookup/{location}", method = RequestMethod.GET)
	public @ResponseBody Location lookup(@PathVariable String location) throws JSONException{
		String address = lookupService.lookup(location);
		
		Location loc = new Location(location, address);
		return loc;
	}
}
