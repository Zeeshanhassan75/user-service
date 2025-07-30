package com.microservice.userservice.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.userservice.Interface.UserServiceInterface;
import com.microservice.userservice.entity.User;
import com.microservice.userservice.exception.ResourceNotFoundException;
import com.microservice.userservice.repository.UserServiceRepository;

@Service
public class UserServiceImpl implements UserServiceInterface {
	
	@Autowired
	UserServiceRepository userServiceRepository;
	
	@Override
	public User createUser(User user) {
		
		User userdetails = new User();
		userdetails.setUserId(UUID.randomUUID().toString());
		userdetails.setUserName(user.getUserName());
		userdetails.setPhoneNumber(user.getPhoneNumber());
		userdetails.setEmail(user.getEmail());
		userdetails.setAbout(user.getAbout());		
		return userServiceRepository.save(userdetails);
	}
	

	@Override
	public User getSingleUser(String id) {
		return userServiceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException()) ;
	}

	@Override
	public List<User> getAllUsers() {
		return userServiceRepository.findAll();
	}
	
}
