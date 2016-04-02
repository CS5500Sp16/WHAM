package com.neu.wham.dao;

import com.neu.wham.model.User;

public interface UserRegistrationDAO {
	public User createNewUser(User user);
	public User validateUser(String emailId, String password);
}
