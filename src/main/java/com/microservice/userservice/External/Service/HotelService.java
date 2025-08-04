package com.microservice.userservice.External.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.userservice.entity.Hotel;

@FeignClient("HOTEL-SERVICE")
public interface HotelService {

	
	@GetMapping("/hotelService/getHotelById/{hotelId}")
	Hotel getHotel(@PathVariable String hotelId);
}
