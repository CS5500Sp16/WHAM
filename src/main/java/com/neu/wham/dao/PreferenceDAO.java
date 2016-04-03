package com.neu.wham.dao;

import com.neu.wham.model.SelectedPreference;
import com.neu.wham.model.UserSelectedPreference;
import com.neu.wham.model.UserPreference;

public interface PreferenceDAO {
	public UserPreference getAllPreferences() throws Exception;
	public UserPreference updatePreference(int userId, UserSelectedPreference userPref) throws Exception;
	public UserSelectedPreference getUserPreferences(int userId) throws Exception;
}
