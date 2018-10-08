package com.footballproject.services;

import java.util.List;

import com.footballproject.model.User;

public interface UserService {
	
	public void adduser(User user);
	public User getUser(String userId);
	public List<User> getUser();

}
