package com.nearby.shops.spring.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nearby.shops.spring.model.LoginRegisterResponse;
import com.nearby.shops.spring.model.User;
import com.nearby.shops.spring.service.UserService;

@RestController
@CrossOrigin
//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// Get a single user by id
	@GetMapping("/api/users/{id}")
	public ResponseEntity<User> get(@PathVariable("id") long id) {
		User user = userService.get(id);
		return ResponseEntity.ok().body(user);
	}
	
	// Sign-in
	@PostMapping("/api/auth/signin")
	public ResponseEntity<LoginRegisterResponse> login(@RequestBody User user) {
		
		LoginRegisterResponse loginRegisterResponse;
		
		if(userService.login(user) != null) {
			
			// Create a User object
			User _user = userService.login(user);
			// Delete the password
			_user.setPassword(null);
			
			// Return the Login response
			return ResponseEntity.ok().body(new LoginRegisterResponse(true, _user));
			
		} else {
			
			// Return the Login response
			return ResponseEntity.ok().body(new LoginRegisterResponse(false, null));
			
		}
			
	}
	
	// Sign-up
	@PostMapping("/api/auth/signup")
	public ResponseEntity<LoginRegisterResponse> register(@RequestBody User user) {
		
		LoginRegisterResponse registerResponse;
		
		try {
			
			long id = userService.save(user);

			// Create a User object
			User _user = new User();
			_user.setId(id);
			_user.setEmail(user.getEmail());
			_user.setPassword(null);
			
			// Create the Sign-up Response object
			registerResponse = new LoginRegisterResponse(true, _user);
			
			// Return the Register response
			return ResponseEntity.ok().body(registerResponse);
			
		} catch (ConstraintViolationException e) {
			
			// Create the Sign-up Response object
			registerResponse = new LoginRegisterResponse(false, null);
			
			// Return the Register response
			return ResponseEntity.ok().body(registerResponse);
			
		}
			
	}

}






