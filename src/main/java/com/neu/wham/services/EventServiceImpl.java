package com.neu.wham.services;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.neu.wham.dao.EventDAO;
import com.neu.wham.exceptions.InvalidAddressException;
import com.neu.wham.keys.Keys;
import com.neu.wham.messages.EventPostResponse;
import com.neu.wham.messages.EventPostResponse.Status;
import com.neu.wham.model.Event;
import com.neu.wham.services.NewEventService;

@Service
public class EventServiceImpl implements NewEventService {
	@Autowired
	private EventDAO eventDAO;
	@Autowired
	private EventPostResponse evntResponse;
	
	@Override
	public EventPostResponse submitNewEvent(Event event) {
		//fetch the lat-lng
		try {
			getLatLongForEventLocation(event);
			Date tempDate = new Date();
			event.setCreationTime(tempDate);
			event.setLastUpdateTime(tempDate);
			eventDAO.addNewEvent(event);
			evntResponse.setMsg(Status.OK.name());
			evntResponse.setStatus(Status.OK);
		} catch (InvalidAddressException e) {
			evntResponse.setMsg(e.getMessage());
			evntResponse.setStatus(Status.ERROR);
			e.printStackTrace(); // TODO remove this
		} catch (SQLException e) {
			evntResponse.setMsg(e.getMessage());
			evntResponse.setStatus(Status.ERROR);
			e.printStackTrace(); // TODO remove this
		}
		return evntResponse;
	}

	private void getLatLongForEventLocation(Event event) throws InvalidAddressException{
		// Replace the API key below with a valid API key.
		GeoApiContext context = new GeoApiContext().setApiKey(Keys.GEO_CODING_API_KEY);
		GeocodingResult[] results = null;
		try {
			results = GeocodingApi.geocode(context,event.getEventLocation()).await();
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidAddressException("Invalid Address.");
		}
		event.setLatitude(results[0].geometry.location.lat);
		event.setLongitude(results[0].geometry.location.lng);
	}
	

}
