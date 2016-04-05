package com.neu.wham;


import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.neu.wham.controllers.DataSourceController;
import com.neu.wham.model.Event;
import com.neu.wham.services.GetEventServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("test-context.xml")
public class GetEventServiceTest {

	private MockMvc mockMvc;

//	@Mock (name = "getEventService")
//	@Mock
    private GetEventServiceImpl getEventServiceMock = mock(GetEventServiceImpl.class);
	
//	@InjectMocks
	private DataSourceController dataSourceController;
	  

    @Autowired
    private WebApplicationContext context;
   

    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
    	dataSourceController = new DataSourceController(getEventServiceMock);
        mockMvc = MockMvcBuilders.standaloneSetup(dataSourceController)
        		.build();
      }
    
    // testcase 1     
    @Test 
    public void getEvents_validLatLonRadTest() throws Exception{
    	
		String lat = "42.3389";
		String lon = "71.0903";
		String rad = "500";
		String userId = "";
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("lat", lat);
		params.put("lon", lon);
		params.put("rad", rad);
		params.put("userId", userId);
		
		when(getEventServiceMock.queryEventbrite(params).thenReturn(GetEventServiceUtil.getCannedEventbriteResponse());
		when(getEventServiceMock.getEventsFromAPI(params)).thenCallRealMethod();
		when(getEventServiceMock.getEvents(params)).thenCallRealMethod();
		
		String url = "/datasource/" + lat + "/" + lon + "/" + rad + "?q=" + q;
		mockMvc.perform(get(url))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].eventName", is("Boston Calling - May 27, 28, 29, 2016")))
				.andExpect(jsonPath("$[1].eventName", is("IELTS lessons taught by one of the top IELTS teachers in Uzbekistan")))
				.andExpect(jsonPath("$[2].eventName", is("Get Traction: The Virtual Growth Event [Tashkent]")));
    }
    
    
    // testcase 2
    @Test
    public void getEvents_zeroRadTest() throws Exception{
    	
		String lat = "42.3389";
		String lon = "71.0903";
		String rad = "0";
		String q = "";
		
		String afterValidateRad = "10";
		
		when(getEventServiceMock.queryEventbrite(lat, lon, afterValidateRad, q)).thenReturn(GetEventServiceUtil.getCannedEventbriteResponse());
		when(getEventServiceMock.getEventsFromAPI(lat, lon, afterValidateRad, q)).thenCallRealMethod();
		when(getEventServiceMock.getEvents(lat, lon, afterValidateRad, q)).thenCallRealMethod();
		
		String url = "/datasource/" + lat + "/" + lon + "/" + rad + "?q=" + q;
		mockMvc.perform(get(url))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].eventName", is("Boston Calling - May 27, 28, 29, 2016")))
				.andExpect(jsonPath("$[1].eventName", is("IELTS lessons taught by one of the top IELTS teachers in Uzbekistan")))
				.andExpect(jsonPath("$[2].eventName", is("Get Traction: The Virtual Growth Event [Tashkent]")));
    }
    
    
    // testcase 3
    @Test
    public void getEvents_negRadTest() throws Exception{
    	
		String lat = "42.3389";
		String lon = "71.0903";
		String rad = "-10";
		String q = "";
		
		String afterValidateRad = "10";
		
		when(getEventServiceMock.queryEventbrite(lat, lon, afterValidateRad, q)).thenReturn(GetEventServiceUtil.getCannedEventbriteResponse());
		when(getEventServiceMock.getEventsFromAPI(lat, lon, afterValidateRad, q)).thenCallRealMethod();
		when(getEventServiceMock.getEvents(lat, lon, afterValidateRad, q)).thenCallRealMethod();
		
		String url = "/datasource/" + lat + "/" + lon + "/" + rad + "?q=" + q;
		mockMvc.perform(get(url))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].eventName", is("Boston Calling - May 27, 28, 29, 2016")))
				.andExpect(jsonPath("$[1].eventName", is("IELTS lessons taught by one of the top IELTS teachers in Uzbekistan")))
				.andExpect(jsonPath("$[2].eventName", is("Get Traction: The Virtual Growth Event [Tashkent]")));
    }
    
    // testcase 20
    @Test
    public void getEvents_InvalidStringRTest() throws Exception{
    	String lat = "45";
		String lon = "45";
		String rad = "w10";
		String q = "";
		
		String afterValidateRad = "10";
		when(getEventServiceMock.getEvents(lat, lon, afterValidateRad, q)).thenReturn(new ArrayList<Event>());
		
		String url = "/datasource/" + lat + "/" + lon + "/" + rad + "?q=" + q;
		mockMvc.perform(get(url))
				.andExpect(status().isOk())
				.equals(new ArrayList<Event>()); 	
    }
    
    // testcase 13
    @Test
    public void getEvents_multiLatTest() throws Exception{
        String lat1 = "0";
        String lon = "0";
        String rad = "10";
        String lat2 = "45";
        
        String url = "/datasource/" + lat1 + "/" + lon + "/" + rad + "/" + lat2;
        mockMvc.perform(get(url))
                .andExpect(status().isNotFound())
                .equals("{Error: Coordinates are not valid. Please specify one latitude, one longitude, and one radius}");   
    }
    
    // testcase 14
    @Test
    public void getEvents_multiLonTest() throws Exception{
        String lat = "0";
        String lon1 = "0";
        String rad = "10";
        String lon2 = "45";
        
        String url = "/datasource/" + lat + "/" + lon1 + "/" + rad + "/" + lon2;
        mockMvc.perform(get(url))
                .andExpect(status().isNotFound())
                .equals("{Error: Coordinates are not valid. Please specify one latitude, one longitude, and one radius}");   
    }
    
    // testcase 15
    @Test
    public void getEvents_multiRadTest() throws Exception{
        String lat = "0";
        String lon = "0";
        String rad1 = "10";
        String rad2 = "45";
        
        String url = "/datasource/" + lat + "/" + lon + "/" + rad1 + "/" + rad2;
        mockMvc.perform(get(url))
                .andExpect(status().isNotFound())
                .equals("{Error: Coordinates are not valid. Please specify one latitude, one longitude, and one radius}");   
    }
    
    //?lat=0&long=0&r=foo
	// testcase 10
    @Test
    public void getEvents_dummyRadTest() throws Exception{
    	
		String lat = "42.3389";
		String lon = "71.0903";
		String rad = "foo";
		String q = "";
		
		String afterValidateRad = "10";
		
		when(getEventServiceMock.queryEventbrite(lat, lon, afterValidateRad, q)).thenReturn(GetEventServiceUtil.getCannedEventbriteResponse());
		when(getEventServiceMock.getEventsFromAPI(lat, lon, afterValidateRad, q)).thenCallRealMethod();
		when(getEventServiceMock.getEvents(lat, lon, afterValidateRad, q)).thenCallRealMethod();
		
		String url = "/datasource/" + lat + "/" + lon + "/" + rad + "?q=" + q;
		mockMvc.perform(get(url))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].eventName", is("Boston Calling - May 27, 28, 29, 2016")))
				.andExpect(jsonPath("$[1].eventName", is("IELTS lessons taught by one of the top IELTS teachers in Uzbekistan")))
				.andExpect(jsonPath("$[2].eventName", is("Get Traction: The Virtual Growth Event [Tashkent]")));
    }
    
    //?lat=0&long=0&r=NULL
    // testcase 11
    @Test
    public void getEvents_nullRadTest() throws Exception{
    	
		String lat = "42.3389";
		String lon = "71.0903";
		String rad = null;
		String q = "";
		
		String afterValidateRad = "10";
		
		when(getEventServiceMock.queryEventbrite(lat, lon, afterValidateRad, q)).thenReturn(GetEventServiceUtil.getCannedEventbriteResponse());
		when(getEventServiceMock.getEventsFromAPI(lat, lon, afterValidateRad, q)).thenCallRealMethod();
		when(getEventServiceMock.getEvents(lat, lon, afterValidateRad, q)).thenCallRealMethod();
		
		String url = "/datasource/" + lat + "/" + lon + "/" + rad + "?q=" + q;
		mockMvc.perform(get(url))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].eventName", is("Boston Calling - May 27, 28, 29, 2016")))
				.andExpect(jsonPath("$[1].eventName", is("IELTS lessons taught by one of the top IELTS teachers in Uzbekistan")))
				.andExpect(jsonPath("$[2].eventName", is("Get Traction: The Virtual Growth Event [Tashkent]")));
    }
    
    // Sprint 2 - test case 1
    @Test
    public void getEvents_keywordMusic() throws Exception{
    	
		String lat = "42.3389";
		String lon = "71.0903";
		String rad = "500";
		String q = "";
	
		when(getEventServiceMock.queryEventbrite(lat, lon, rad, q)).thenReturn(GetEventServiceUtil.getCannedEventbriteResponse());
		when(getEventServiceMock.getEventsFromAPI(lat, lon, rad, q)).thenCallRealMethod();
		when(getEventServiceMock.getEvents(lat, lon, rad, q)).thenCallRealMethod();


		
		String url = "/datasource/" + lat + "/" + lon + "/" + rad + "?q=" + q;
		
		mockMvc.perform(get(url))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].eventName", is("Boston Calling - May 27, 28, 29, 2016")))
				.andExpect(jsonPath("$[1].eventName", is("IELTS lessons taught by one of the top IELTS teachers in Uzbekistan")))
				.andExpect(jsonPath("$[2].eventName", is("Get Traction: The Virtual Growth Event [Tashkent]")));
    }
    
    
}
