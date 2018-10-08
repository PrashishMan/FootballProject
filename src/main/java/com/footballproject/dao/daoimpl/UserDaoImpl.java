package com.footballproject.dao.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footballproject.dao.UserDao;
import com.footballproject.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addUser(User user) {
		getSession().saveOrUpdate(user);
	}

	@Override
	public User getUser(String userId) {
		return (User)getSession().get(User.class, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUser() {
		return (List<User>)getSession().createCriteria(User.class).list();
	}

}
