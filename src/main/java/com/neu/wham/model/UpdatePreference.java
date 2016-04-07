package com.neu.wham.model;

public class UpdatePreference {
	private String userId;
	private String userPreference;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPreference() {
		return userPreference;
	}
	public void setUserPreference(String userPreference) {
		this.userPreference = userPreference;
	}
	@Override
	public String toString() {
		return "UpdatePreference [userId=" + userId + ", userPreference=" + userPreference + "]";
	}
	
	
}
