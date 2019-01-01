package com.nearby.shops.spring.dao;

import com.nearby.shops.spring.model.User;

public interface UserDAO {
	
	// Save the record
	long save(User user);
	
	// Get a single record
	User get(long id);
	
	// Login method
	User login(User user);

}
