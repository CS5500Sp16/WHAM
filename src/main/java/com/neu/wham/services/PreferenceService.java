package com.neu.wham.services;

import com.neu.wham.model.PreferencesStore;
import com.neu.wham.model.UserPreference;
import com.neu.wham.model.UserSelectedPreference;

public interface PreferenceService {
	public UserPreference getAllPreferences();
	public UserSelectedPreference updatePreference(String userId, String userPrefAsString);
	public UserSelectedPreference getUserPreferences(String userId);
	public PreferencesStore buildPreferencesStore(String userId);
}
