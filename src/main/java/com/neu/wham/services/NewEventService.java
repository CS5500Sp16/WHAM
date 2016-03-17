package com.neu.wham.services;

import com.neu.wham.messages.EventPostResponse;
import com.neu.wham.model.Event;

public interface NewEventService {
	public EventPostResponse submitNewEvent(Event event);
}
