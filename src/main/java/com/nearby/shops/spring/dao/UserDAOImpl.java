package com.nearby.shops.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.nearby.shops.spring.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(User user) {

		//String hashedPassword = ""+user.getPassword().hashCode();
		//user.setPassword(hashedPassword);
		
		sessionFactory.getCurrentSession().save(user);
		return user.getId();
	}

	@Override
	public User get(long id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public User login(User user) {

		//String hashedPassword = ""+user.getPassword().hashCode();
		//user.setPassword(hashedPassword);

		// Login query
		String query = "FROM User WHERE email = '" + user.getEmail() + "' AND password = '" + user.getPassword() + "'";
		List<User> users = sessionFactory.getCurrentSession().createQuery(query).list();
		/*
		 * if(users.size() > 0) { User response_user = new User(users.get(0).getId(),
		 * users.get(0).getEmail(), ""); }
		 */

		return users.size() > 0 ? users.get(0) : null;
	}

}
