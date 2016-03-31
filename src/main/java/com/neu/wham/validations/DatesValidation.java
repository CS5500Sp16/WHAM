package com.neu.wham.validations;


import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.neu.wham.exceptions.InvalidDateTimeException;

public class DatesValidation {
	public static String validateDateTime(String dateTime) throws IllegalArgumentException, InvalidDateTimeException{
		String ldtString = null;
		
		// pass along dateTime if null.  This is ok - it means the optional request
		// was omitted.
		if(null == dateTime) {
			return null;
		}
		
		// let's replace the unwanted characters and trim the whitespace
		String trimedString =  dateTime.replaceAll("[=*%@!$&^#+~`|]", "").trim();
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");
		
		try{
		LocalDateTime ldt = LocalDateTime.parse(trimedString, formatter);
		ldtString = ldt.toString(formatter);
		} catch (IllegalArgumentException e) {
			String errorMessage = "DateTime format error: please use format like \"yyyy-MM-ddTHH:mm:ss\" ";
			System.out.println("Exception : " + errorMessage);    
			// TODO Auto-generated catch block
			throw new InvalidDateTimeException(errorMessage);
		}

				
		return ldtString;
	}
}
