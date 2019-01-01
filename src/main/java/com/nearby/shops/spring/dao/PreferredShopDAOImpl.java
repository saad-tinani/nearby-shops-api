package com.nearby.shops.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nearby.shops.spring.model.PreferredShop;

@Repository
public class PreferredShopDAOImpl implements PreferredShopDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(PreferredShop preferredShop) {
		sessionFactory.getCurrentSession().save(preferredShop);
		return preferredShop.getId();
	}

	@Override
	public PreferredShop get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PreferredShop> list() {
		List<PreferredShop> list = sessionFactory.getCurrentSession().createQuery("FROM PreferredShop").list();
		return list;
	}

	@Override
	public void update(long id, PreferredShop preferredShop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		PreferredShop preferredShop = session.byId(PreferredShop.class).load(id);
		session.delete(preferredShop);
	}
	
}
