package com.nearby.shops.spring.service;

import com.nearby.shops.spring.model.User;

public interface UserService {
	
	// Save the record
	long save(User user);
	
	// Get a single record
	User get(long id);
	
	// Login method
	User login(User user);

}
