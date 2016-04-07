package com.neu.wham.services;

import com.neu.wham.model.UserPreference;
import com.neu.wham.model.UserSelectedPreference;

public interface PreferenceService {
	public UserPreference getAllPreferences();
	public UserSelectedPreference updatePreference(String userId, UserSelectedPreference userPref);
	public UserSelectedPreference getUserPreferences(String userId);
}
