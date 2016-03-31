package com.neu.wham.services;


import java.util.List;

import org.joda.time.LocalDateTime;

import com.neu.wham.model.Event;

public interface GetEventService {
	public List<Event> getEvents(String lat, String lon, String rad, String q,
								 String statDT, String endDT);
}





