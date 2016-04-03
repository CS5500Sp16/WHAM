package com.neu.wham.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.wham.model.UserPreference;
import com.neu.wham.services.PreferenceService;


@Controller
public class UserPreferenceController {
	
	@Autowired
	private PreferenceService prefService;
	
	@RequestMapping(value="/updatePref",method=RequestMethod.POST)
	public boolean updateUserPreference(@RequestParam("userPreference") String userPref){
		
		return true;
	}
	
	@RequestMapping(value="/getPref",method=RequestMethod.GET)
	public void getUserPreference(@RequestParam("userPreference") String userId){
		
		//return null;
	}
	
	@RequestMapping(value="/getPrefList",method=RequestMethod.GET)
	public @ResponseBody UserPreference getPreferencesList(){
		return prefService.getAllPreferences();
	}
}
