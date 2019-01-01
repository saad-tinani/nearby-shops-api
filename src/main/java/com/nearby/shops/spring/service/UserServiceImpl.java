package com.nearby.shops.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nearby.shops.spring.dao.UserDAO;
import com.nearby.shops.spring.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public long save(User user) {
		return userDAO.save(user);
	}

	@Override
	@Transactional
	public User get(long id) {
		return userDAO.get(id);
	}
	
	@Override
	@Transactional
	public User login(User user) {
		return userDAO.login(user);
	}

}
