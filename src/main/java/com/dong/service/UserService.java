package com.dong.service;

import java.util.List;

import com.dong.entity.User;

public interface UserService {

	public User findUserByName(String name);
	
	public List<User> findUserById(String id);
	
	public List<User> findAll();
	
	public User findById(String id);
}
