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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;


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
	
	int count = 1;
	@GetMapping("/{UserId}")
	@CircuitBreaker(name="RatingHotelServiceBreaker" , fallbackMethod = "ratingHotelServiceFallback")
	@RateLimiter(name="RatingHotelService" , fallbackMethod = "ratingHotelServiceFallback")
	ResponseEntity<User> GetUserById(@PathVariable String UserId){
		System.out.println("Rate Count : "+count);
		count++;
		User user1 = userServiceInterface.getSingleUser(UserId);
		return ResponseEntity.ok(user1);
	}
	
	ResponseEntity<User> ratingHotelServiceFallback(String userId , Exception ex){
		System.out.println("RATING AND HOTEL SERVICE IS DOWN");
		System.out.println("");
		new User();
		User user = User.builder()
					.email("dummy@gmail.com")
					.userName("Dummy USER")
					.userId("123")
					.build();
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers")
	ResponseEntity<List<User>> GetAllUsers(){
		List<User> user1 = userServiceInterface.getAllUsers();
		return ResponseEntity.ok(user1);
	}

}
