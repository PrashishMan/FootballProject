package com.footballproject.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.footballproject.dao.UserDao;
import com.footballproject.model.User;
import com.footballproject.services.UserService;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService{
	
	@Autowired 
	UserDao userDao;

	@Override
	public void adduser(User user) {
		userDao.addUser(user);
	}

	@Override
	public User getUser(String userId) {
		return userDao.getUser(userId);
	}

	@Override
	public List<User> getUser() {
		return userDao.getUser();
	}
	

}
