package com.nearby.shops.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nearby.shops.spring.dao.PreferredShopDAO;
import com.nearby.shops.spring.model.PreferredShop;

@Service
public class PreferredShopServiceImpl implements PreferredShopService {
	
	@Autowired
	private PreferredShopDAO preferredShopDAO;

	@Override
	@Transactional
	public long save(PreferredShop preferredShop) {
		return preferredShopDAO.save(preferredShop);
	}

	@Override
	public PreferredShop get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<PreferredShop> list() {
		return preferredShopDAO.list();
	}

	@Override
	public void update(long id, PreferredShop preferredShop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void delete(long id) {
		preferredShopDAO.delete(id);
	}

}
