package com.nearby.shops.spring.controller;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nearby.shops.spring.model.PreferredShop;
import com.nearby.shops.spring.service.PreferredShopService;

@RestController
@CrossOrigin
//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
public class PreferredShopController {
	
	@Autowired
	private PreferredShopService preferredShopService;
	
	// Get all preferred shops
	@GetMapping("/api/preferred-shops")
	public ResponseEntity<List<PreferredShop>> list() {
		List<PreferredShop> list = preferredShopService.list();
		return ResponseEntity.ok().body(list);
	}
	
	// Save a Preferred shop
	@PostMapping("/api/preferred-shops")
	public ResponseEntity<PreferredShop> save(@RequestBody PreferredShop preferredShop) {
		try {
			long id = preferredShopService.save(preferredShop);
			preferredShop.setId(id);
			return ResponseEntity.ok().body(preferredShop);
		} catch (ConstraintViolationException e) {
			return ResponseEntity.ok().body(null);
		}
	}
	
	// Delete a Preferred shop
	@DeleteMapping("/api/preferred-shops/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		preferredShopService.delete(id);
		return ResponseEntity.ok().body("Preferred shop has been deleted");
	}

}
