package com.neu.wham;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.neu.wham.model.Event;

public class GetEventServiceUtil {
	
	public static JSONArray getCannedEventbriteResponse() throws JSONException {
		JSONArray cannedEvents = new JSONArray();
		
		
		// first object
		JSONObject event1 = new JSONObject();
		
		// create address object
		JSONObject address1 = new JSONObject();
		address1.put("country", "KG");
		address1.put("city", "Bishkek");
		address1.put("address_1", "Gorky Street");
		address1.put("address_2", "null");
		address1.put("latitude", "42.856827");
		address1.put("longitude", "74.61858410000002");
		address1.put("region", "Chuy Province");
		address1.put("postal_code", "null");
		
		// create venue object
		JSONObject venue1 = new JSONObject();
		venue1.put("address", address1);
		
		// create name object
		JSONObject name1 = new JSONObject();
		name1.put("text", "Boston Calling - May 27, 28, 29, 2016");
		name1.put("html", "Boston Calling - May 27, 28, 29, 2016");
		
		// create description object
		JSONObject description1 = new JSONObject();
		String desText1 = "event1 description mock";
		description1.put("text", desText1);
		description1.put("html", desText1);
		
		// create start object
		JSONObject start1 = new JSONObject();
		start1.put("timezone", "Asia/Bishkek");
		start1.put("local", "2016-04-05T18:30:00");
		start1.put("utc", "2016-04-05T12:30:00Z");
		
		// create end object
		JSONObject end1 = new JSONObject();
		end1.put("timezone", "Asia/Bishkek");
		end1.put("local", "2016-04-05T20:30:00");
		end1.put("utc", "2016-04-05T14:30:00Z");
		
		event1.put("name", name1);
		event1.put("description", description1);
		event1.put("start", start1);
		event1.put("end", end1);
		event1.put("created", "2016-04-02T14:48:24Z");
		event1.put("changed", "2016-04-02T14:48:26Z");
		event1.put("venue", venue1);
		
		
		
		// second object
		JSONObject event2 = new JSONObject();
				
		// create address object
		JSONObject address2 = new JSONObject();
		address2.put("country", "UZ");
		address2.put("city", "Tashkent");
		address2.put("address_1", "A. Navoi street 21");
		address2.put("address_2", "Shaykhontokhur district");
		address2.put("latitude", "41.2994958");
		address2.put("longitude", "69.24007340000003");
		address2.put("region", "null");
		address2.put("postal_code", "null");
				
		// create venue object
		JSONObject venue2 = new JSONObject();
		venue2.put("address", address2);
				
		// create name object
		JSONObject name2 = new JSONObject();
		name2.put("text", "IELTS lessons taught by one of the top IELTS teachers in Uzbekistan");
		name2.put("html", "IELTS lessons taught by one of the top IELTS teachers in Uzbekistan");
				
		// create description object
		JSONObject description2 = new JSONObject();
		String desText2 = "event2 description mock";
		description2.put("text", desText2);
		description2.put("html", desText2);
				
		// create start object
		JSONObject start2 = new JSONObject();
		start2.put("timezone", "Asia/Tashkent");
		start2.put("local", "2016-04-04T15:30:00");
		start2.put("utc", "2016-04-04T10:30:00Z");
				
		// create end object
		JSONObject end2 = new JSONObject();
		end2.put("timezone", "Asia/Tashkent");
		end2.put("local", "2016-06-03T17:30:00");
		end2.put("utc", "2016-06-03T12:30:00Z");
				
		event2.put("name", name2);
		event2.put("description", description2);
		event2.put("start", start2);
		event2.put("end", end2);
		event2.put("created", "2016-03-23T13:15:47Z");
		event2.put("changed", "2016-04-04T11:33:11Z");
		event2.put("venue", venue2);
		
		
		
		// second object
		JSONObject event3 = new JSONObject();
						
		// create address object
		JSONObject address3 = new JSONObject();
		address3.put("country", "UZ");
		address3.put("city", "Tashkent");
		address3.put("address_1", "null");
		address3.put("address_2", "null");
		address3.put("latitude", "41.3125");
		address3.put("longitude", "69.39027399999998");
		address3.put("region", "null");
		address3.put("postal_code", "100001");
						
		// create venue object
		JSONObject venue3 = new JSONObject();
		venue3.put("address", address3);
						
	    // create name object
		JSONObject name3 = new JSONObject();
		name3.put("text", "Get Traction: The Virtual Growth Event [Tashkent]");
		name3.put("html", "Get Traction: The Virtual Growth Event [Tashkent]");
						
		// create description object
		JSONObject description3 = new JSONObject();
		String desText3 = "event3 description mock";
		description3.put("text", desText3);
		description3.put("html", desText3);
						
		// create start object
		JSONObject start3 = new JSONObject();
		start3.put("timezone", "Asia/Samarkand");
		start3.put("local", "2016-03-01T10:00:00");
		start3.put("utc", "2016-03-01T05:00:00Z");
						
		// create end object
		JSONObject end3 = new JSONObject();
		end3.put("timezone", "Asia/Samarkand");
		end3.put("local", "2016-08-04T14:00:00");
		end3.put("utc", "2016-08-04T09:00:00Z");
						
		event3.put("name", name3);
		event3.put("description", description3);
		event3.put("start", start3);
		event3.put("end", end3);
		event3.put("created", "2016-03-23T13:15:47Z");
		event3.put("changed", "2016-04-04T11:33:11Z");
		event3.put("venue", venue3);
		
		
		
		
		cannedEvents.put(event1);
		cannedEvents.put(event2);
		cannedEvents.put(event3);
				
		
		System.out.println("return cannedEvents: " + cannedEvents);
		return cannedEvents;
	}
	
}
