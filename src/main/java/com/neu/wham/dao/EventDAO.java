package com.neu.wham.dao;

import java.sql.SQLException;

import java.util.List;


import org.json.JSONException;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.neu.wham.model.Event;

public interface EventDAO {
	public boolean addNewEvent(Event event) throws SQLException;
	public List<Event> getEventsData(String lat, String lon, String rad) throws SQLException, JSONException, UnirestException; 
}

