package com.neu.wham.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.neu.wham.dao.PreferenceDAO;
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
	public UserPreference updatePreference(String userId, String userPrefAsString) {
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

}
