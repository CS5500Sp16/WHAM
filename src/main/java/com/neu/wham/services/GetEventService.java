package com.neu.wham.services;


import java.util.List;

import org.json.JSONArray;

import com.neu.wham.model.Event;

public interface GetEventService {
	public List<Event> getEvents(String lat, String lon, String rad, String q);
	//public JSONArray queryEventbrite(String lat, String lon, String radius, String q);
	//public String emma(String lat, String lon, String rad, String q);
}





