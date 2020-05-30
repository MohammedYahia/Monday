package com.supercode.springdotsay.service;

import java.util.List;

import com.supercode.springdotsay.model.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User findById(int id );
	
	public void save (User theUser);
	
	public void deleteById(int id );
	
	
	

}
