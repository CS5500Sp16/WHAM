package com.neu.wham.validations;

public class UserIdValidation {
	public static String validateUserId(String userId) {
		try {
			Integer.parseInt(userId);
			return userId;
		} catch(NumberFormatException e) {
			return null;
		}
	}
}
