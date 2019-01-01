package com.nearby.shops.spring.service;

import java.util.List;

import com.nearby.shops.spring.model.Shop;

public interface ShopService {
	
	// Save the record
	long save(Shop shop);
	
	// Get a single record
	Shop get(long id);
	
	// Get all records
	List<Shop> list(long user_id);
	
	// Update a record
	void update(long id, Shop shop);
	
	// Delete a record
	void delete(long id);

}
