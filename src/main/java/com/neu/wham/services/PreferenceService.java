package com.neu.wham.services;

import com.neu.wham.model.EventbritePreferences;
import com.neu.wham.model.UserPreference;
import com.neu.wham.model.UserSelectedPreference;

public interface PreferenceService {
	public UserPreference getAllPreferences();
	public UserSelectedPreference updatePreference(String userId, String userPrefAsString);
	public UserSelectedPreference getUserPreferences(String userId);
	public EventbritePreferences buildEventbritePreferences(String userId);
}
