package com.neu.wham.services;


import java.util.List;
import com.neu.wham.model.Event;

public interface GetEventService {
	public List<Event> getEvents(String lat, String lon, String rad);
}





