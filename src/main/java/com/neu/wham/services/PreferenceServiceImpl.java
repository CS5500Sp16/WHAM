package com.neu.wham.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.wham.dao.PreferenceDAO;
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

}
