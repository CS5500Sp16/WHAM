package com.neu.wham.services;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neu.wham.messages.EventPostResponse;
import com.neu.wham.messages.EventPostResponse.Status;
import com.neu.wham.model.Event;

/**
 * Test class to test Service Layer
 * @author Vijet Badigannavar
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-servlet-context.xml" })
 public class EventServiceImplTest {
	@Autowired 
	private NewEventService eventserviceImpl; 
	/**
	 * Test for Location is null. (Negative Test case)
	 * @author Vijet Badigannavar
	 */
	@Test
	public void eventLocationIsNull(){
		Event event = new Event();
		event.setEventName(null);
		EventPostResponse testResponse = eventserviceImpl.submitNewEvent(event, null);
		assertEquals(Status.ERROR, testResponse.getStatus());
	}
	
	/**
	 * Test for Event Name is null. (Negative Test case)
	 * @author Vijet Badigannavar
	 */
	@Test
	public void eventNameisNull(){
		Event event = new Event();
		event.setEventName(null);
		event.setEventLocation("Northeastern University");
		event.setCreationTime(new Date());
		event.setLastUpdateTime(new Date());
		event.setEndDateAndTime(new Date());
		event.setStartDateAndTime(new Date());
		EventPostResponse testResponse = eventserviceImpl.submitNewEvent(event, null);
		assertEquals(Status.ERROR, testResponse.getStatus());
	}
	
	/**
	 * Test for Event Desc is null. (Negative Test case)
	 * @author Vijet Badigannavar
	 */
	@Test
	public void eventDescisNull(){
		Event event = new Event();
		event.setEventName(null);
		event.setEventDesc(null);
		event.setEventLocation("Northeastern University");
		event.setCreationTime(new Date());
		event.setLastUpdateTime(new Date());
		event.setEndDateAndTime(new Date());
		event.setStartDateAndTime(new Date());
		EventPostResponse testResponse = eventserviceImpl.submitNewEvent(event, null);
		assertEquals(Status.ERROR, testResponse.getStatus());
	}
	
	/**
	 * Test for eventEmail is null. (Negative Test case)
	 * @author Vijet Badigannavar
	 */
	@Test
	public void eventEmailisNull(){
		Event event = new Event();
		event.setEventName(null);
		event.setEventDesc(null);
		event.setEmailId(null);
		event.setEventLocation("Northeastern University");
		event.setCreationTime(new Date());
		event.setLastUpdateTime(new Date());
		event.setEndDateAndTime(new Date());
		event.setStartDateAndTime(new Date());
		EventPostResponse testResponse = eventserviceImpl.submitNewEvent(event, null);
		assertEquals(Status.ERROR, testResponse.getStatus());
	}
	
	/**
	 * Test for eventOrgName is null. (Negative Test case)
	 * @author Vijet Badigannavar
	 */
	@Test
	public void eventOrgNameisNull(){
		Event event = new Event();
		event.setEventName(null);
		event.setEventDesc(null);
		event.setEmailId(null);
		event.setOrganiserName(null);
		event.setEventLocation("Northeastern University");
		event.setCreationTime(new Date());
		event.setLastUpdateTime(new Date());
		event.setEndDateAndTime(new Date());
		event.setStartDateAndTime(new Date());
		EventPostResponse testResponse = eventserviceImpl.submitNewEvent(event, null);
		assertEquals(Status.ERROR, testResponse.getStatus());
	}
	
	/**
	 * Test for eventOrganizationDescription is null. (Negative Test case)
	 * @author Vijet Badigannavar
	 */
	@Test
	public void eventOrgDescisNull(){
		Event event = new Event();
		event.setEventName(null);
		event.setEventDesc(null);
		event.setEmailId(null);
		event.setOrganiserDesc(null);
		event.setEventLocation("Northeastern University");
		event.setCreationTime(new Date());
		event.setLastUpdateTime(new Date());
		event.setEndDateAndTime(new Date());
		event.setStartDateAndTime(new Date());
		EventPostResponse testResponse = eventserviceImpl.submitNewEvent(event, null);
		assertEquals(Status.ERROR, testResponse.getStatus());
	}
	
	/**
	 * Test for valid Event is null. (Positive Test case)
	 * @author Vijet Badigannavar
	 */
	@Test
	public void putAnEvent(){
		Event event = new Event();
		event.setEventName("Holi");
		event.setEventDesc("Festival of Colors");
		event.setEmailId("sanskruti@husky.neu.edu");
		event.setOrganiserName("NEU-SANSKRUTI");
		event.setOfficialEvent(true);
		event.setOrganiserDesc("NEU Sanskruti team");
		event.setEventLocation("Northeastern University");
		event.setCreationTime(new Date());
		event.setLastUpdateTime(new Date());
		event.setEndDateAndTime(new Date());
		event.setStartDateAndTime(new Date());
		EventPostResponse testResponse = eventserviceImpl.submitNewEvent(event, null);
		assertEquals(Status.OK, testResponse.getStatus());
	}
}
