package com.microservice.userservice.External.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.microservice.userservice.entity.Hotel;

@Service
@FeignClient("HOTEL-SERVICE")
public interface HotelService {

	
	//Tested through JUnit
	
	@GetMapping("/hotelService/getHotelById/{hotelId}")
	Hotel getHotel(@PathVariable String hotelId);
	
	@PutMapping("/hotelService/UpdateHotelById/{hotelId}")
	Hotel updateHotel(@PathVariable String hotelId , Hotel hotel);
	
	@PostMapping("/hotelService/registerHotel")
	Hotel createHotel(Hotel hotel);
	
	@DeleteMapping("/hotelService/RemoveHotelById/{hotelId}")
	void deleteHotel(@PathVariable String hotelId);
	
	
}




