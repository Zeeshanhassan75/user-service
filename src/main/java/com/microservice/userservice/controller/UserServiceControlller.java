package com.microservice.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.userservice.Interface.UserServiceInterface;
import com.microservice.userservice.entity.User;

@RestController
@RequestMapping("/userService")
public class UserServiceControlller {
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
	@PostMapping("/register")
	ResponseEntity<User> RegisterUser(@RequestBody User user){		
		
		User user1 = userServiceInterface.createUser(user);		
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	@GetMapping("/{UserId}")
	ResponseEntity<User> GetUserById(@PathVariable String UserId){
		User user1 = userServiceInterface.getSingleUser(UserId);
		return ResponseEntity.ok(user1);
	}
	
	@GetMapping("/getAllUsers")
	ResponseEntity<List<User>> GetAllUsers(){
		List<User> user1 = userServiceInterface.getAllUsers();
		return ResponseEntity.ok(user1);
	}

}
