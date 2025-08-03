package com.microservice.userservice.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.userservice.Interface.UserServiceInterface;
import com.microservice.userservice.entity.Rating;
import com.microservice.userservice.entity.User;
import com.microservice.userservice.exception.ResourceNotFoundException;
import com.microservice.userservice.repository.UserServiceRepository;

@Service
public class UserServiceImpl implements UserServiceInterface {
	
	@Autowired
	private UserServiceRepository userServiceRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
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
		User user =  userServiceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException()) ;
		ResponseEntity<List<Rating>> rating = restTemplate.exchange("http://localhost:8088/ratingService/getRatingsByUserId/" + user.getUserId(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Rating>>() {});
		
		user.setRate(rating.getBody());		
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userServiceRepository.findAll();
	}
	
}
