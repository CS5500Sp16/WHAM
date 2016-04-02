package com.neu.wham.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neu.wham.model.User;
import com.neu.wham.services.UserRegistrationService;

@Repository
public class UserRegistrationDAOImpl implements UserRegistrationDAO {
	
	@Override
	public User createNewUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User validateUser(String emailId, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
