package com.neu.wham.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.wham.dao.UserRegistrationDAO;
import com.neu.wham.exceptions.RegistrationFailedException;
import com.neu.wham.model.User;
@Service

public class UserRegistrationImpl implements UserRegistrationService{

	@Autowired
	private UserRegistrationDAO registrationDAO;
	
	@Override
	public User registerUser(User user) throws RegistrationFailedException {
		// TODO Auto-generated method stub
		return null;
	}

}
