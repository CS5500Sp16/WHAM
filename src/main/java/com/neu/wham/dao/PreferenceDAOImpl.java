package com.neu.wham.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.PreparedStatement;
import com.neu.wham.keys.DBConstants;
import com.neu.wham.model.EventType;
import com.neu.wham.model.UserPreference;

@Repository
public class PreferenceDAOImpl implements PreferenceDAO {

	private Connection conn = null;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public UserPreference getAllPreferences() throws Exception {
		
		conn = DriverManager.getConnection(DBConstants.DB_URL,DBConstants.USER,DBConstants.PASS);
		
		UserPreference userPref = new UserPreference();
		userPref.setEventType(getAllEventTypes());
		
		
		return userPref;
	}
	
	// GetallEventTYpes;
	private List<EventType> getAllEventTypes() throws SQLException{
		List<EventType> eventTypeList = new ArrayList<EventType>();
		String sqlStmt = "Select * from EVENT_TYPE_MASTER;";
		PreparedStatement ppdStmt = (PreparedStatement) conn.prepareStatement(sqlStmt);
		
		ResultSet rs = ppdStmt.executeQuery();
		while(rs.next()){
			EventType et = new EventType();
			et.setEventId(rs.getInt("event_type_id"));
			et.setEventName(rs.getString("event_type"));
			eventTypeList.add(et);
		}
		return eventTypeList;
	}
	

}
