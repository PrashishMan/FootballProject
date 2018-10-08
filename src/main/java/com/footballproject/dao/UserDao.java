package com.footballproject.dao;

import java.util.List;

import com.footballproject.model.User;

public interface UserDao {
	public void addUser(User user);
	public User getUser(String userId);
	public List<User> getUser();
	
}
