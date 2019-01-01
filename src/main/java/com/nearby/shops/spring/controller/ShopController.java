package com.nearby.shops.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nearby.shops.spring.model.Shop;
import com.nearby.shops.spring.service.ShopService;

@RestController
@CrossOrigin
//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	// Get all the shops
	@GetMapping("/api/shops/{user_id}")
	public ResponseEntity<List<Shop>> list(@PathVariable("user_id") long user_id) {
		List<Shop> list = shopService.list(user_id);
		return ResponseEntity.ok().body(list);
	}

}
