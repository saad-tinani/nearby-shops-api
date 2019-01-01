package com.nearby.shops.spring.service;

import java.util.List;

import com.nearby.shops.spring.model.PreferredShop;

public interface PreferredShopService {
	
	// Save the record
	long save(PreferredShop preferredShop);
	
	// Get a single record
	PreferredShop get(long id);
	
	// Get all records
	List<PreferredShop> list();
	
	// Update a record
	void update(long id, PreferredShop preferredShop);
	
	// Delete a record
	void delete(long id);

}
