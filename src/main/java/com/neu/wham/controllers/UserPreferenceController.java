package com.neu.wham.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.neu.wham.model.UpdatePreference;
import com.neu.wham.model.UserPreference;
import com.neu.wham.model.UserSelectedPreference;
import com.neu.wham.services.PreferenceService;


@Controller
public class UserPreferenceController {
	
	@Autowired
	private PreferenceService prefService;
	
	@RequestMapping(value="/updatePref",method=RequestMethod.POST)
	public @ResponseBody UserSelectedPreference updateUserPreference(@RequestBody String userPref){
		Gson gson = new Gson();
		UpdatePreference pref = gson.fromJson(userPref, UpdatePreference.class);
		System.out.println(pref.toString());
		return prefService.updatePreference(pref.getUserId(), pref.getUserPreference());
//		System.out.println(userId);
//		System.out.println(userPref);
//		return prefService.updatePreference(userId, userPref);
	}
	
	@RequestMapping(value="/getPref",method=RequestMethod.GET)
	public UserSelectedPreference getUserPreference(@RequestParam("userPreference") String userId){
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
