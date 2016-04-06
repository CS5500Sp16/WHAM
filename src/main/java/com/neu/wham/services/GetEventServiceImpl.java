package com.neu.wham.services;

import com.neu.wham.keys.*;
import java.util.List;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.neu.wham.dao.EventDAO;
import com.neu.wham.model.Event;
import com.neu.wham.model.EventbritePreferences;


@Service
public class GetEventServiceImpl implements GetEventService {
	
	@Autowired
	private EventDAO eventDAO;
	
	@Autowired
	private PreferenceService prefService;
	
	@Override
	public List<Event> getEvents(HashMap<String, String> params)
	{
		// set up event lists
		List<Event> DBEvents = new ArrayList<Event>();
		List<Event> APIEvents = new ArrayList<Event>();
		List<Event> NEUEvents = new ArrayList<Event>();
		List<Event> resultList = new ArrayList<Event>();
		
		// read the params
		String lat = params.get("lat");
		String lon = params.get("lon");
		String rad = params.get("rad");
		String userId = params.get("userId");
		
		// build the Eventbrite preferences
		EventbritePreferences ePrefs = new EventbritePreferences();
		if(null != userId) 
			ePrefs = prefService.buildEventbritePreferences(userId);
			
 		try
		{

	 		APIEvents = getEventsFromAPI(lat, lon, rad, ePrefs.getFormats(), ePrefs.getCategories(), ePrefs.getSubcategories());	
			DBEvents =  eventDAO.getEventsData(lat, lon, rad);
	//		NEUEvents = getNEUEvents();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
 		resultList.addAll(APIEvents);
		resultList.addAll(DBEvents);
		resultList.addAll(NEUEvents);
 		
		return resultList;
	}
	
	public List<Event> getEventsFromAPI(String lat, String lon, String radius, 
			String[] formats, String[] categories, String[] subcategories) 
			throws UnirestException, JSONException, ParseException, URISyntaxException
	{
		JSONArray events = queryEventbrite(lat, lon, radius, formats, categories, subcategories);
		System.out.println("Events length: " + events.length());
		
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

	
	public List<Event> getNEUEvents() throws URISyntaxException, UnirestException, IOException, JSONException, ParserConfigurationException, SAXException, TransformerException
	{
		List<Event> NEUCalenderEvents = new ArrayList<Event>();
		
		URL url = new URL("http://calendar.northeastern.edu/widget/view?schools=northeastern&days=31&num=50&format=xml");
		URLConnection conn = url.openConnection();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(conn.getInputStream());
	    
		NodeList itemList = doc.getElementsByTagName("item");
		
		for (int i=0; i < itemList.getLength(); i++)
		{
			Node nNode = itemList.item(i);
			Element eElement = (Element) nNode;	
			if(eElement.getElementsByTagName("geo:lat").getLength() != 0 &&
					eElement.getElementsByTagName("geo:lng").getLength() != 0){

				try
				{
					Event e = new Event();
					if(eElement.getElementsByTagName("title").getLength() != 0)
						e.setEventName(eElement.getElementsByTagName("title").item(0).getTextContent());
					if(eElement.getElementsByTagName("description").getLength() != 0)
						e.setEventDesc(eElement.getElementsByTagName("description").item(0).getTextContent());
					if(eElement.getElementsByTagName("geo:lat").getLength() != 0)
						e.setLatitude((double)Double.parseDouble(eElement.getElementsByTagName("geo:lat").item(0).getTextContent()));
					if(eElement.getElementsByTagName("geo:lng").getLength() != 0)
						e.setLongitude((double)Double.parseDouble(eElement.getElementsByTagName("geo:lng").item(0).getTextContent()));
					if(eElement.getElementsByTagName("link").getLength() != 0)
						e.setExtLink(eElement.getElementsByTagName("link").item(0).getTextContent());
					if(eElement.getElementsByTagName("pubDate").getLength() != 0){
						DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
						format.setTimeZone(TimeZone.getTimeZone("GMT-4:00"));
						Date date = format.parse(eElement.getElementsByTagName("pubDate").item(0).getTextContent());
						e.setStartDateAndTime(date);
					}
					e.setOfficialEvent(true);

					NEUCalenderEvents.add(e);
				}
				catch(Exception e)
				{
					System.out.println("Error:" + e.getStackTrace());
				}
			}
		}
		
		System.out.println("NEU Events:" + NEUCalenderEvents.size());
		
		return NEUCalenderEvents;
		
	}
	
	public List<Event> getNEUEventsFromPref(String userId) throws URISyntaxException, UnirestException, JSONException, SQLException
	{
		List<Event> NEUCalendarEvents = new ArrayList<Event>();
		
		URIBuilder builder = new URIBuilder("http://localhost:8080/wham/getPref");
		builder.addParameter("userPreference", "13");
		
		HttpResponse<JsonNode> jsonResponse = Unirest.get(builder.toString()).asJson();
		
		JsonNode jsonNode = jsonResponse.getBody();
		JSONObject jsonObject = jsonNode.getObject();
		JSONArray selectedPrefs = jsonObject.getJSONArray("selectedPreference");
		
		for(int i = 0; i < selectedPrefs.length(); i++)
		{
			JSONObject pref = selectedPrefs.getJSONObject(i);
			int category = pref.getInt("eventCategory");
			int eventId = pref.getInt("eventId");
			
			String categoryName = "";
			
			switch(category)
			{
			case 0: {categoryName = connectDB("EVENT_TYPE_MASTER", "event_type", eventId, "event_type_id");
			System.out.println("Category Name" + categoryName);}
			break;
			case 1: {categoryName = connectDB("EVENT_TOPIC_MASTER", "event_topic", eventId, "event_topic_id");
			System.out.println("Category Name" + categoryName);}
			break;
			case 2: {categoryName = connectDB("EVENT_SUB_TOPIC_MASTER", "event_sub_topic", eventId, "event_sub_topic_id");
			System.out.println("Category Name" + categoryName);}
			break;
			default: return null;
			}
		}
		return NEUCalendarEvents;
	}
	
	public String connectDB(String tableName, String col1, int eventId, String col2) throws SQLException
	{
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		String DB_URL = "jdbc:mysql://ec2-52-87-159-69.compute-1.amazonaws.com:3306/whamDB";
		String USER = "wham";
		String PASS = "wham@123";


		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		conn = DriverManager.getConnection(DB_URL,USER,PASS);

		String query = "SELECT " + col1 + " FROM " + tableName + " WHERE " + col2 + "='" + eventId + "'";

		PreparedStatement pstmt =conn.prepareStatement(query);
		ResultSet rs = null;
        String categoryName = "";
		try {
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) { 
                  categoryName = rs.getString("event_type");
                  
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());}
		
		return categoryName;

	}
	
	public JSONArray queryEventbrite(String lat, String lon, String radius, 
			String[] formats, String[] categories, String[] subcategories) {
		
		URIBuilder builder;
		JSONArray events = null;
		try {
			builder = new URIBuilder("https://www.eventbriteapi.com/v3/events/search");
			builder.addParameter("expand", "venue");
			builder.addParameter("location.latitude", lat);
			builder.addParameter("location.longitude", lon);
			builder.addParameter("location.within", radius + "mi");
			builder.addParameter("token", Keys.EVENTBRITE_KEY);
			if(null != formats && formats.length > 0)
				builder.addParameter("formats", String.join(",", formats));
			if(null != categories && categories.length > 0)
				builder.addParameter("categories", String.join(",", categories));
			if(null != subcategories && subcategories.length > 0)
				builder.addParameter("subcategories", String.join(",", subcategories));
			
			System.out.println(builder.toString());
			
			HttpResponse<JsonNode> jsonResponse = Unirest.get(builder.toString()).asJson();
			JsonNode obj = jsonResponse.getBody();
			JSONObject response = obj.getObject();
			System.out.println("response length:" + response.length());
			System.out.println(response.toString());
			if(response.has("events"))
				events = response.getJSONArray("events");
			else
				events = new JSONArray();
				
			System.out.println(jsonResponse.getStatus());
			System.out.println("*****");
			System.out.println("Events: ");
			System.out.println(events);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return events;
	}
	
	
		
}
