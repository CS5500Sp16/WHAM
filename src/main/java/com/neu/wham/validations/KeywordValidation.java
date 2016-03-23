package com.neu.wham.validations;

public class KeywordValidation {
	public static String validateKeyword(String q) {
		// pass along q if null.  This is ok - it means the optional request
		// was omitted.
		if(null == q) {
			return q;
		}
		
		// let's replace the unwanted characters and trim the whitespace
		return q.replaceAll("[=*%@!$&^#+~`|]", "").trim();
	}
}
