package com.neu.wham.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.neu.wham.dao.PreferenceDAO;
import com.neu.wham.model.EventbritePreferences;
import com.neu.wham.model.SelectedPreference;
import com.neu.wham.model.UserSelectedPreference;
import com.neu.wham.model.UserPreference;

@Service
public class PreferenceServiceImpl implements PreferenceService {
	
	@Autowired
	private PreferenceDAO preferenceDAO;
	
	@Override
	public UserPreference getAllPreferences() {
		try {
			return preferenceDAO.getAllPreferences();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserSelectedPreference updatePreference(String userId, String userPrefAsString) {
		try{
			UserSelectedPreference userPref = new Gson().fromJson(userPrefAsString, UserSelectedPreference.class);
			return preferenceDAO.updatePreference(Integer.valueOf(userId), userPref);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserSelectedPreference getUserPreferences(String userId) {
		try{
			return preferenceDAO.getUserPreferences(Integer.valueOf(userId));
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EventbritePreferences buildEventbritePreferences(String userId) {
		EventbritePreferences ePrefs = new EventbritePreferences();
		
		// let's get the intermediate form of preferences from the local database
		UserSelectedPreference userPrefs = this.getUserPreferences(userId);
		
		// for each preference mapping, do a db lookup.  I'm going to pretend this is efficient :)
		String ePrefString = "";
		for(SelectedPreference pref : userPrefs.getSelectedPreference()) {
			try {
				ePrefString = preferenceDAO.getPreferenceString(pref.getEventId(), pref.getEventCategory());
				switch(pref.getEventCategory()) {
					case 0:
						ePrefs.addFormat(ePrefString);
						break;
					case 1:
						ePrefs.addCategory(ePrefString);
						break;
					case 2:
						ePrefs.addSubcategory(ePrefString);
						break;
					default:
						System.out.println("Unknown preference type! " + pref.getEventCategory());
				}
			} catch(Exception e) {
				e.printStackTrace();
			}	
		}
		
		// return the EventbritePreferences object
		return ePrefs;
	}
}
