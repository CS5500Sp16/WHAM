package com.neu.wham;

import static org.junit.Assert.assertEquals;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;
import com.neu.wham.dao.PreferenceDAOImpl;
import com.neu.wham.dao.UserRegistrationDAOImpl;
import com.neu.wham.model.EventTopic;
import com.neu.wham.model.EventType;
import com.neu.wham.model.SelectedPreference;
import com.neu.wham.model.UserPreference;
import com.neu.wham.model.UserSelectedPreference;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("test-context.xml")
public class PreferenceDAOTest {
	// JDBC driver name and database URL
		private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		private final String DB_URL = "jdbc:mysql://ec2-52-87-159-69.compute-1.amazonaws.com:3306/whamDB";

		//  Database credentials
		private final String USER = "wham";
		private final String PASS = "wham@123";
		
		PreferenceDAOImpl preferenceDAOImpl = new PreferenceDAOImpl();
		UserRegistrationDAOImpl userRegistrationDAOImpl = new UserRegistrationDAOImpl();
		
		@Test
		public void getAllPreferencesTest() throws Exception {
			UserPreference up = preferenceDAOImpl.getAllPreferences();
			List<EventType> eventType = up.getEventType();
			List<EventTopic> eventTopic = up.getEventTopic();
			int numberOfSubTopic = 0;
			for (EventTopic e : eventTopic) {
				numberOfSubTopic += e.getSubTopicsList().size();
			}
			assertEquals(eventType.size(), 20);
			assertEquals(eventTopic.size(), 21);
			assertEquals(numberOfSubTopic, 185);
		}
		
		@Test
		public void updatePreferenceTest() throws Exception {
//			// Create a user
//			User user = new User();
//			user.setFirstName("test");
//			user.setMiddleName("ma");
//			user.setLastName("jason");
//			user.setEmailId("abc@husky.neu.edu");
//			user.setPhoneNo("1112221234");
//			user.setPassword("abc");
//			userRegistrationDAOImpl.createNewUser(user);
			// Create user preference
			UserSelectedPreference usp = new UserSelectedPreference();
			List<SelectedPreference> preferenceList = new ArrayList<SelectedPreference>();
			SelectedPreference sp1 = new SelectedPreference();
			sp1.setEventCategory(0); //0 -> EventType
			sp1.setEventId(2); //2 -> Attraction
			preferenceList.add(sp1);
			usp.setSelectedPreference(preferenceList);
			preferenceDAOImpl.updatePreference(26, usp);
			
			// get from database
			UserSelectedPreference userPref = new UserSelectedPreference();
			List<SelectedPreference> prefList = new ArrayList<SelectedPreference>();
			Connection conn = null;
			conn = DriverManager.getConnection(DB_URL,USER,PASS);;

			StringBuilder stmtBuilder = new StringBuilder();
			stmtBuilder.append("select * from USER_PREFERENCES where user_id=?;");
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(stmtBuilder.toString());
			stmt.setInt(1, 26);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				prefList.add(new SelectedPreference(rs.getInt("event_pref_type"), rs.getInt("event_pref_id")));
			}
			userPref.setSelectedPreference(prefList);
			
			assertEquals(userPref.getSelectedPreference().size(), usp.getSelectedPreference().size());
		}
		
		@Test
		public void getUserPreferencesTest() throws Exception {
//			// Create a user
//			User user = new User();
//			user.setFirstName("test");
//			user.setMiddleName("ma");
//			user.setLastName("jason");
//			user.setEmailId("abc@husky.neu.edu");
//			user.setPhoneNo("1112221234");
//			user.setPassword("abc");
//			userRegistrationDAOImpl.createNewUser(user);
			// Create user preference
			UserSelectedPreference usp = new UserSelectedPreference();
			List<SelectedPreference> preferenceList = new ArrayList<SelectedPreference>();
			SelectedPreference sp1 = new SelectedPreference();
			sp1.setEventCategory(0); //0 -> EventType
			sp1.setEventId(2); //2 -> Attraction
			preferenceList.add(sp1);
			usp.setSelectedPreference(preferenceList);
			preferenceDAOImpl.updatePreference(26, usp);
			
			// get from database
			UserSelectedPreference userPref = new UserSelectedPreference();
			List<SelectedPreference> prefList = new ArrayList<SelectedPreference>();
			Connection conn = null;
			conn = DriverManager.getConnection(DB_URL,USER,PASS);;

			StringBuilder stmtBuilder = new StringBuilder();
			stmtBuilder.append("select * from USER_PREFERENCES where user_id=?;");
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(stmtBuilder.toString());
			stmt.setInt(1, 26);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				prefList.add(new SelectedPreference(rs.getInt("event_pref_type"), rs.getInt("event_pref_id")));
			}
			userPref.setSelectedPreference(prefList);
			UserSelectedPreference usp1 = preferenceDAOImpl.getUserPreferences(26);
			List<SelectedPreference> spList = usp1.getSelectedPreference();
			assertEquals(spList.size(), usp.getSelectedPreference().size());
		}
		
		@Test(expected=SQLException.class)
		public void getUserPreferencesNegTest() throws Exception {
//			// Create a user
//			User user = new User();
//			user.setFirstName("test");
//			user.setMiddleName("ma");
//			user.setLastName("jason");
//			user.setEmailId("abc@husky.neu.edu");
//			user.setPhoneNo("1112221234");
//			user.setPassword("abc");
//			userRegistrationDAOImpl.createNewUser(user);
			// Create user preference
			UserSelectedPreference usp = new UserSelectedPreference();
			List<SelectedPreference> preferenceList = new ArrayList<SelectedPreference>();
			SelectedPreference sp1 = new SelectedPreference();
			sp1.setEventCategory(0); //0 -> EventType
			sp1.setEventId(2); //2 -> Attraction
			preferenceList.add(sp1);
			usp.setSelectedPreference(preferenceList);
			preferenceDAOImpl.updatePreference(20, usp);
			
			// get from database
			UserSelectedPreference userPref = new UserSelectedPreference();
			List<SelectedPreference> prefList = new ArrayList<SelectedPreference>();
			Connection conn = null;
			conn = DriverManager.getConnection(DB_URL,USER,PASS);;

			StringBuilder stmtBuilder = new StringBuilder();
			stmtBuilder.append("select * from USER_PREFERENCES where user_id=?;");
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(stmtBuilder.toString());
			stmt.setInt(1, 20);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				prefList.add(new SelectedPreference(rs.getInt("event_pref_type"), rs.getInt("event_pref_id")));
			}
			userPref.setSelectedPreference(prefList);
			UserSelectedPreference usp1 = preferenceDAOImpl.getUserPreferences(26);
//			List<SelectedPreference> spList = usp1.getSelectedPreference();
//			assertEquals(spList.size(), usp.getSelectedPreference().size());
		}
}
