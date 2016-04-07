package com.neu.wham.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.wham.model.UserPreference;
import com.neu.wham.model.UserSelectedPreference;
import com.neu.wham.services.PreferenceService;


@Controller
public class UserPreferenceController {
	
	@Autowired
	private PreferenceService prefService;
	
	@RequestMapping(value="/updatePref",method=RequestMethod.POST)
	public @ResponseBody UserSelectedPreference updateUserPreference(@RequestParam("userId") String userId,@RequestParam("userPreference") String userPref){
		if(userId==null || userPref == null || userId.isEmpty() || userPref.isEmpty()){
			return null;
		}
		return prefService.updatePreference(userId, userPref);
	}
	
	@RequestMapping(value="/getPref",method=RequestMethod.GET)
	public @ResponseBody UserSelectedPreference getUserPreference(@RequestParam("userPreference") String userId){
		if(userId==null || userId.isEmpty()){
			return null;
		}
		return prefService.getUserPreferences(userId);
	}
	
	@RequestMapping(value="/getPrefList",method=RequestMethod.GET)
	public @ResponseBody UserPreference getPreferencesList(){
		return prefService.getAllPreferences();
	}
}
