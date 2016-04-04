package com.neu.wham.services;


import java.util.List;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.neu.wham.dao.EventDAO;
import com.neu.wham.model.Event;


@Service
public class GetEventServiceImpl implements GetEventService {
	
	@Autowired
	private EventDAO eventDAO;
	
	@Override
	public List<Event> getEvents(String lat, String lon, String rad, String q, String statDT, String endDT,
			String[] formats, String[] categories, String[] subcategories)
	{
		System.out.println("in getEvents of impl");
		List<Event> DBEvents = new ArrayList<Event>();
		List<Event> APIEvents = new ArrayList<Event>();
		List<Event> resultList = new ArrayList<Event>();
 		try
		{
 		APIEvents = getEventsFromAPI(lat, lon, rad, q, statDT, endDT, formats, categories, subcategories);	
		DBEvents =  eventDAO.getEventsData(lat, lon, rad);
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
 		resultList.addAll(APIEvents);
		resultList.addAll(DBEvents);
 		
		return resultList;
	}
	
	@Override
	public List<Event> getEvents(String lat, String lon, String rad) {
		return getEvents(lat, lon, rad, null, null, null, null, null, null);
	}
	
	@Override
	public List<Event> getEvents(String lat, String lon, String rad, String q) {
		return getEvents(lat, lon, rad, q, null, null, null, null, null);
	}
	
	@Override
	public List<Event> getEvents(String lat, String lon, String rad, String statDT, String endDT) {
		return getEvents(lat, lon, rad, null, statDT, endDT, null, null, null);
	}
	
	@Override
	public List<Event> getEvents(String lat, String lon, String rad, String q, String statDT, String endDT) {
		return getEvents(lat, lon, rad, q, statDT, endDT, null, null, null);
	}
	
	public List<Event> getEventsFromAPI(String lat, String lon, String radius, String q, 
			String statDT, String endDT, String[] formats, String[] categories, String[] subcategories) 
			throws UnirestException, JSONException, ParseException, URISyntaxException
	{
		System.out.println("in getEventsFromAPI");
		URIBuilder builder = new URIBuilder("https://www.eventbriteapi.com/v3/events/search");
		builder.addParameter("expand", "venue");
		builder.addParameter("location.latitude", lat);
		builder.addParameter("location.longitude", lon);
		builder.addParameter("location.within", radius + "mi");
		builder.addParameter("token", "DXVHSQKC2T2GGBTUPOY2");
		if(null != q)
			builder.addParameter("q", q);
		if(null != statDT){
			System.out.println("XIWANG");
			System.out.println("statDT in string:" + statDT);
			builder.addParameter("start_date.range_start", statDT);
		}
		if(null != endDT){
			System.out.println("endDT in string:" + endDT);
			builder.addParameter("start_date.range_end", endDT);
		}
		if(null != formats)
			builder.addParameter("formats", String.join(",", formats));
		if(null != categories)
			builder.addParameter("categories", String.join(",", categories));
		if(null != subcategories)
			builder.addParameter("subcategories", String.join(",", subcategories));
		
		System.out.println(builder);
		System.out.println(builder.toString());
		
		HttpResponse<JsonNode> jsonResponse = Unirest.get(builder.toString()).asJson();
		System.out.println(jsonResponse.getStatus());
		System.out.println("*****");
		
		JsonNode obj = jsonResponse.getBody();
		JSONObject response = obj.getObject();
		JSONArray events = response.getJSONArray("events");
		
		List<Event> eventList = new ArrayList<Event>();
		
		for(int i = 0; i < events.length(); i++){
			
			Event e = new Event();
			
			JSONObject event = events.getJSONObject(i);
			String eventName = event.getJSONObject("name").getString("text");
			e.setEventName(eventName);
			String eventDesc = event.getJSONObject("description").getString("text");
			e.setEventDesc(eventDesc);
			String eventLocation = event.getJSONObject("venue").getJSONObject("address").getString("address_1")+ " " + 
					event.getJSONObject("venue").getJSONObject("address").getString("address_2")+ " " +
					event.getJSONObject("venue").getJSONObject("address").getString("city")+ " " +
					event.getJSONObject("venue").getJSONObject("address").getString("region")+ " " +
					event.getJSONObject("venue").getJSONObject("address").getString("postal_code")+ " " +
					event.getJSONObject("venue").getJSONObject("address").getString("country");
			e.setEventLocation(eventLocation);
			e.setPhoneNumber(null);
			e.setEmailId(null);
			
			String startDateTime = event.getJSONObject("start").getString("local");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			TimeZone tz = TimeZone.getTimeZone(event.getJSONObject("start").getString("timezone"));
			formatter.setTimeZone(tz);
			Date startDate = formatter.parse(startDateTime);
			e.setStartDateAndTime(startDate);
			
			String endDateString = event.getJSONObject("end").getString("local");
			Date endDate = formatter.parse(endDateString);
			e.setEndDateAndTime(endDate);
			
			Double venueLat = event.getJSONObject("venue").getJSONObject("address").getDouble("latitude");
			e.setLatitude(venueLat);
			Double venueLong = event.getJSONObject("venue").getJSONObject("address").getDouble("longitude");
			e.setLongitude(venueLong);
			
			
			String creationTimeString = event.getString("created");
			Date creationTime = formatter.parse(creationTimeString);
			e.setCreationTime(creationTime);
			
			String lastUpdateTimeString = event.getString("changed");
			Date lastUpdateTime = formatter.parse(lastUpdateTimeString);
			e.setLastUpdateTime(lastUpdateTime);
			
			e.setOrganiserName(null);
			e.setOrganiserDesc(null);
			e.setOfficialEvent(false);
			e.setFilePath(null);
			
			
			eventList.add(e);
		}
		
		return eventList;
	}
}
