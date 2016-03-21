package com.neu.wham.services;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.neu.wham.dao.EventDAO;
import com.neu.wham.exceptions.InvalidAddressException;
import com.neu.wham.keys.Constants;
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
	
	private final Date tempDate = new Date();
	
	@Override
	public EventPostResponse submitNewEvent(Event event, MultipartFile imageFile) {
		//fetch the lat-lng
		try {
			getLatLongForEventLocation(event);
			//save the file if uploaded if uploaded in the request.
			event.setFilePath(saveUploadedFile(imageFile, event.getOrganiserName()));
			event.setCreationTime(tempDate);
			event.setLastUpdateTime(tempDate);
			eventDAO.addNewEvent(event);
			evntResponse.setMsg(Status.OK.name());
			evntResponse.setStatus(Status.OK);
		}catch (IOException e) {
			evntResponse.setMsg(e.getMessage());
			evntResponse.setStatus(Status.ERROR);
			e.printStackTrace(); // TODO remove this
		}
		catch (InvalidAddressException e) {
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

	private String saveUploadedFile(MultipartFile imageFile, String organiserName) throws IOException {
		if(imageFile != null){
			StringBuilder builder = new StringBuilder();
			builder.append(Constants.IMAGE_UPLOAD_PATH);
			builder.append(organiserName);
			builder.append("_");
			builder.append(tempDate.getTime());
			builder.append("_");
			builder.append(imageFile.getOriginalFilename());
			File tempFile = new File(builder.toString());
			FileUtils.writeByteArrayToFile(tempFile, imageFile.getBytes());
			return builder.toString();
		}
		return null;
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
