package com.neu.wham;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.neu.wham.controllers.DataSourceController;
import com.neu.wham.exceptions.LocationException;
import com.neu.wham.exceptions.LocationException.LocationExceptionType;

public class DataSourceControllerTest {
	

    DataSourceController dsController = new DataSourceController();

	@Rule
    public ExpectedException thrown = ExpectedException.none();
     
	//?lat=91&long=0&r=10  testcase4
    @Test
    public void getEvents_invalidBigLatTest() throws Exception {
    	String lat = "91";
    	String lon = "0";
    	String rad = "10";
    		
    	String exceptionStatement = new LocationException(LocationExceptionType.LOCATION_OUT_OF_BOUNDS).getMessage();
    	
        // arrange
        thrown.expect(LocationException.class);
        thrown.expectMessage(equalTo(exceptionStatement));
        // act
        dsController.firstRequest(lat, lon, rad);
    }
    
    //?lat=-91&long=0&r=10  testcase5
    @Test
    public void getEvents_invalidSmallLatTest() throws Exception {
    	String lat = "-91";
    	String lon = "0";
    	String rad = "10";
    		
    	String exceptionStatement = new LocationException(LocationExceptionType.LOCATION_OUT_OF_BOUNDS).getMessage();
    	
        // arrange
        thrown.expect(LocationException.class);
        thrown.expectMessage(equalTo(exceptionStatement));
        // act
        dsController.firstRequest(lat, lon, rad);
    }
    
    //?lat=0&long=181&r=10 testcase6
    @Test
    public void getEvents_invalidBigLonTest() throws Exception {
    	String lat = "0";
    	String lon = "181";
    	String rad = "10";
    		
    	String exceptionStatement = new LocationException(LocationExceptionType.LOCATION_OUT_OF_BOUNDS).getMessage();
    	
        // arrange
        thrown.expect(LocationException.class);
        thrown.expectMessage(equalTo(exceptionStatement));
        // act
        dsController.firstRequest(lat, lon, rad);
    }
    
    //?lat=0&long=-181&r=10 testcase7
    @Test
    public void getEvents_invalidSmallLonTest() throws Exception {
    	String lat = "0";
    	String lon = "-181";
    	String rad = "10";
    		
    	String exceptionStatement = new LocationException(LocationExceptionType.LOCATION_OUT_OF_BOUNDS).getMessage();
    	
        // arrange
        thrown.expect(LocationException.class);
        thrown.expectMessage(equalTo(exceptionStatement));
        // act
        dsController.firstRequest(lat, lon, rad);
    }
    
    //?lat=foo&long=0&r=10 testcase8
    @Test
    public void getEvents_invalidFooLatTest() throws Exception {
    	String lat = "foo";
    	String lon = "0";
    	String rad = "10";
    		
    	String exceptionStatement = new LocationException(LocationExceptionType.LOCATION_FORMAT_EXCEPTION).getMessage();
    	
        // arrange
        thrown.expect(LocationException.class);
        thrown.expectMessage(equalTo(exceptionStatement));
        // act
        dsController.firstRequest(lat, lon, rad);
    }
    
    //?lat=0&long=foo&r=10 testcase9
    @Test
    public void getEvents_invalidFooLonTest() throws Exception {
    	String lat = "foo";
    	String lon = "0";
    	String rad = "10";
    		
    	String exceptionStatement = new LocationException(LocationExceptionType.LOCATION_FORMAT_EXCEPTION).getMessage();
    	
        // arrange
        thrown.expect(LocationException.class);
        thrown.expectMessage(equalTo(exceptionStatement));
        // act
        dsController.firstRequest(lat, lon, rad);
    }
    
    //?lat=NULL&long=NULL&r=NULL testcase12
    @Test
    public void getEvents_invalidLackLatLonRadTest() throws Exception {
    	String lat = null;
    	String lon = null;
    	String rad = null;
    		
    	String exceptionStatement = new LocationException(LocationExceptionType.LOCATION_INCOMPLETE).getMessage();
    	
        // arrange
        thrown.expect(LocationException.class);
        thrown.expectMessage(equalTo(exceptionStatement));
        // act
        dsController.firstRequest(lat, lon, rad);
    }
        
	    //?lat=0 testcase 16
	    ///datasource/0/null/null
	    @Test
	    public void getEvents_invalidLackLonRadTest() throws Exception {
	    	String lat = "0";
	    	String lon = null;
	    	String rad = null;
	    		
	    	String exceptionStatement = new LocationException(LocationExceptionType.LOCATION_INCOMPLETE).getMessage();
	    	
	        // arrange
	        thrown.expect(LocationException.class);
	        thrown.expectMessage(equalTo(exceptionStatement));
	        // act
	        dsController.firstRequest(lat, lon, rad);
	    }
    
	    //?long=0 testcase 17
	    ///datasource/null/0/null
	   @Test
	   public void getEvents_invalidLackLatRadTest() throws Exception {
	   	String lat = null;
	   	String lon = "0";
	   	String rad = null;
	   		
	   	String exceptionStatement = new LocationException(LocationExceptionType.LOCATION_INCOMPLETE).getMessage();
	   	
	       // arrange
	       thrown.expect(LocationException.class);
	       thrown.expectMessage(equalTo(exceptionStatement));
	       // act
	       dsController.firstRequest(lat, lon, rad);
	   }
	   
	   //?r=10 testcase 18
	   ///datasource/null/null/10
	   @Test
	   public void getEvents_invalidLackLatLonTest() throws Exception {
	   	String lat = null;
	   	String lon = null;
	   	String rad = "10";
	   		
	   	String exceptionStatement = new LocationException(LocationExceptionType.LOCATION_INCOMPLETE).getMessage();
	   	
	       // arrange
	       thrown.expect(LocationException.class);
	       thrown.expectMessage(equalTo(exceptionStatement));
	       // act
	       dsController.firstRequest(lat, lon, rad);
	   }
	
	   
	   //?lat=45#&long=50&r=10 testcase 19
	   ///datasource/45#/50/10
	   @Test
	   public void getEvents_invalidLatTest() throws Exception {
	   	String lat = "45#";
	   	String lon = "50";
	   	String rad = "10";
	   		
	   	String exceptionStatement = new LocationException(LocationExceptionType.LOCATION_FORMAT_EXCEPTION).getMessage();
	   	
	       // arrange
	       thrown.expect(LocationException.class);
	       thrown.expectMessage(equalTo(exceptionStatement));
	       // act
	       dsController.firstRequest(lat, lon, rad);
	   }
	   
}
