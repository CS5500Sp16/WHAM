package com.neu.wham.services;

import com.neu.wham.model.UserPreference;
import com.neu.wham.model.UserSelectedPreference;

public interface PreferenceService {
	public UserPreference getAllPreferences();
	public UserPreference updatePreference(String userId, String userPrefAsString);
	public UserSelectedPreference getUserPreferences(String userId);
}
