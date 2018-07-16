package com.dong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dong.entity.User;
import com.dong.mapper.UserMapper;
import com.dong.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User findUserByName(String name) {
		
		return userMapper.findUserByName(name);
	}

	@Override
	public List<User> findUserById(String id) {
		return userMapper.findUsersById(id);
	}

	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	public User findById(String id) {
		User findById = userMapper.findById(id);
		return findById;
	}



}
