package com.neu.wham.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.springframework.stereotype.Repository;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.neu.wham.dao.EventDAO;
import com.neu.wham.model.Event;

@Repository
public class EventDAOImpl implements EventDAO {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://ec2-52-87-159-69.compute-1.amazonaws.com:3306/whamDB";

	//  Database credentials
	static final String USER = "wham";
	static final String PASS = "wham@123";

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean addNewEvent(Event event) throws SQLException {
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd");

		String currentStartDate = sdf.format(event.getStartDate());
		String currentEndDate = sdf.format(event.getEndDate());
		
		
		java.text.SimpleDateFormat sdf1 = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String currentStartTime = sdf1.format(event.getStartTime());
			String currentEndTime = sdf1.format(event.getEndTime());
			String creationTime = sdf1.format(event.getCreationTime());
			String updatedTime = sdf1.format(event.getLastUpdateTime());
			
		Connection conn = null;
		Statement stmt = null;
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		String stam = "insert into EVENT(name,"
				+ "description,"
				+ "start_date,"
				+ "end_date,"
				+ "start_time,"
				+ "end_time,"
				+ "is_official,"
				+ "phone,email,"
				+ "address,"
				+ "latitude,"
				+ "longitude,"
				+ "create_datetime,"
				+ "last_update_datetime,"
				+ "org_name,"
				+ "org_desc,"
				+ "file_path)"
				+ "values("+
					"'"+event.getEventName()+"',"
					+"'"+event.getEventDesc()+"',"
					+"'"+currentStartDate+"',"
					+"'"+currentEndDate+"',"
					+"'"+currentStartTime+"',"
					+"'"+currentEndTime+"',"
					+event.isOfficialEvent() +","
					+"'"+event.getPhoneNumber()+"',"
					+"'"+event.getEmailId()+"',"
					+"'"+event.getEventLocation()+"',"
					+event.getLatitude()+","
					+event.getLongitude()+","
					+"'"+creationTime+"',"
					+"'"+updatedTime+"',"+
					"'"+event.getOrganiserName()+"',"+
					"'"+event.getOrganiserDesc()+"',"+
					"'"+event.getFilePath()+"');";
		
		System.out.println(stam);
		
		stmt = conn.createStatement();
		try{
		int val = stmt.executeUpdate(stam);
		if(val!=0){
			return true;
		}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
		throw new SQLException();
	}
	
	@Override
	public List<Event> getEventsData(String lat, String lon, String radius) throws SQLException, JSONException, UnirestException
	{ 
		return getEventsFromDB(lat, lon, radius);
	}
	
	
	
	public List<Event> getEventsFromDB(String lat, String lon, String radius) throws SQLException
	{
		double lat_rad_sin = Math.sin(((double)Double.parseDouble(lat) * 3.14) / 180);
		double lat_rad_cos = Math.cos(((double)Double.parseDouble(lat) * 3.14) / 180);
		double lon_rad = ((double)Double.parseDouble(lon) * 3.14) / 180;
		
		String query = "SELECT * FROM EVENT WHERE "
				+ "acos(? * sin(latitude * 3.14 / 180) + ? * cos(latitude * 3.14 / 180) * cos(longitude * 3.14 / 180 - ?)) * 6371 <= ?";
		
		Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setDouble(1, lat_rad_sin);
		pstmt.setDouble(2, lat_rad_cos);
		pstmt.setDouble(3, lon_rad);
		pstmt.setDouble(4, (double)Double.parseDouble(radius) / 0.62137);
		
		ResultSet rs = null;
		List<Event> DBEvents = new ArrayList<Event>();
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) { 
				Event e = new Event();
				e.setEventName(rs.getString("name"));
				e.setEventDesc(rs.getString("description"));
				e.setEventLocation(rs.getString("location"));
				e.setPhoneNumber(rs.getString("phone_number"));
				e.setEmailId(rs.getString("email"));
				e.setStartDate(rs.getDate("start_date"));
				e.setEndDate(rs.getDate("end_date"));
				e.setStartTime(rs.getDate("start_time"));
				e.setEndTime(rs.getDate("end_time"));
				e.setLatitude(rs.getDouble("latitude"));
				e.setLongitude(rs.getDouble("longitude"));
				e.setFilePath(rs.getString("file_path"));			
				e.setOrganiserName(rs.getString("organization_name"));
				e.setOrganiserDesc(rs.getString("organization_desc"));
				e.setOfficialEvent(rs.getBoolean("is_official"));
				e.setCreationTime(rs.getDate("Creationtime"));
				e.setLastUpdateTime(rs.getDate("LastUpdateTime"));
				DBEvents.add(e);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		    throw e;
		}
		finally {
			conn.close();
		}
		System.out.println(DBEvents.size());
		return DBEvents;
	}
}
