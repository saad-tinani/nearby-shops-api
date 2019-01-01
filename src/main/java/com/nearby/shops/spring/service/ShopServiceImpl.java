package com.nearby.shops.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nearby.shops.spring.dao.ShopDAO;
import com.nearby.shops.spring.model.Shop;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDAO shopDAO;
	
	@Override
	public long save(Shop shop) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Shop get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Shop> list(long user_id) {
		return shopDAO.list(user_id);
	}

	@Override
	public void update(long id, Shop shop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
