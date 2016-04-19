package com.neu.wham;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.neu.wham.model.Event;
import com.neu.wham.services.GetEventServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("test-context.xml")
public class GetNEUEventsTest {

	GetEventServiceImpl service;
	
    @Before
    public void setup() {
    	service = new GetEventServiceImpl();
      }
    
    // test getNEUEvents service with valid lat, lon and rad, without user preference
    @Test 
    public void getNEUEvents_validLatLonRadTest_withoutUserPreference() throws Exception{
    	String lat = "42.338407";
		String lon = "-71.092625";
		String rad = "50";
		// user preference
		String[] formats = new String[0];
		String[] categories = new String[0];
		String[] subcategories = new String[0];
		
		List<Event> results = service.getNEUEvents(formats, categories, subcategories, lat, lon, rad);
		
		assertEquals(results.size(), 19);
		assertEquals(results.get(0).getEventName(), "7-12 year olds needed for virtual reality game research! at Regame Virtual Reality Laboratory");
		//assertEquals(results.get(17).getEventName(), "Music Composition and Technology Senior Capstone Recital  at Fenway");
    }
     
    // test getNEUEvents service with valid lat, lon ,rad and user preference
    @Test 
    public void getNEUEvents_validLatLonRadTest_withUserPreference() throws Exception{
    	String lat = "42.338407";
		String lon = "-71.092625";
		String rad = "50";
		
		// user preference for user "10"
		String[] formats = new String[0];
		String[] categories = { "Academic Events", "Auto, Boat And Air", "Business And Professional", "Food And Drink", "Performing And Visual Arts"};
 		String[] subcategories = {"", "Comedy", "Comics", "Film"};
 		
		List<Event> results = service.getNEUEvents(formats, categories, subcategories, lat, lon, rad);
		
		assertEquals(results.size(), 11);
		assertEquals(results.get(0).getEventName(), "A History of Boston in 50 Artifacts at Snell Library 90");
		assertEquals(results.get(10).getEventName(), "Cinema by the Sea: Encounters at the End of the World at Northeastern University Marine Science Center");
    }
    
}
