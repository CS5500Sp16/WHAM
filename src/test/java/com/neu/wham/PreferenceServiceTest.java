package com.neu.wham;

import static org.junit.Assert.*;

import java.util.Arrays;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.neu.wham.model.PreferencesStore;
import com.neu.wham.services.PreferenceServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("test-context.xml")
public class PreferenceServiceTest {
	
	// JDBC driver name and database URL
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private final String DB_URL = "jdbc:mysql://ec2-52-87-159-69.compute-1.amazonaws.com:3306/whamDB";

	//  Database credentials
	private final String USER = "wham";
	private final String PASS = "wham@123";

	
	@Autowired 
	private PreferenceServiceImpl prefServiceImpl; 
	
	@Test
	public void buildPreferencesStoreTest() {
		String userId = "13";
		PreferencesStore result = prefServiceImpl.buildPreferencesStore(userId);
		
		System.out.println("formats: " + Arrays.toString(result.getFormats()));
		System.out.println("categories: " + Arrays.toString(result.getCategories()));
		System.out.println("sub categories: " + Arrays.toString(result.getSubcategories()));
		System.out.println("e formats: " + Arrays.toString(result.getFormatsAsEventbrite()));
		System.out.println("e categories: " + Arrays.toString(result.getCategoriesAsEventbrite()));
		System.out.println("e sub categories: " + Arrays.toString(result.getSubcategoriesAsEventbrite()));
		
		String[] formats = new String[0];
		String[] categories = { "Academic Events", "Auto, Boat And Air", "Business And Professional", "Food And Drink", "Performing And Visual Arts"};
 		String[] subcategories = {"", "Comedy", "Comics", "Film"};
 		String[] eFormats = new String[0];
 		String[] eCategories = {"118", "101", "110", "105"};
 		String[] eSubcategories = {"5010", "4005", "4002"};
		
		assertEquals(formats.length, 0);
		assertEquals(eFormats.length, 0);
		assertTrue(Arrays.equals(result.getCategories(), categories));
		assertTrue(Arrays.equals(result.getSubcategories(), subcategories));
		assertTrue(Arrays.equals(result.getCategoriesAsEventbrite(), eCategories));
		assertTrue(Arrays.equals(result.getSubcategoriesAsEventbrite(), eSubcategories));
	
	}
}
