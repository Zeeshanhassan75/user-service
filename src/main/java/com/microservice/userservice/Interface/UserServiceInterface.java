package com.microservice.userservice.Interface;

import java.util.List;

import com.microservice.userservice.entity.User;

public interface UserServiceInterface {
	
	 public User createUser(User user);
	 
	 public User getSingleUser(String id);
	 
	 public List<User> getAllUsers();
}
