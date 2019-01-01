package com.nearby.shops.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nearby.shops.spring.model.Shop;

@Repository
public class ShopDAOImpl implements ShopDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

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
	public List<Shop> list(long user_id) {
		List<Shop> list = sessionFactory.getCurrentSession().createQuery("FROM Shop s WHERE (SELECT COUNT(p.id) FROM PreferredShop p WHERE (s.id = shop) AND (user = '"+ user_id +"')) = 0").list();
		return list;
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
