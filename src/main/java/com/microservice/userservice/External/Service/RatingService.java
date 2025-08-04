package com.microservice.userservice.External.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.microservice.userservice.entity.Rating;

@FeignClient("RATING-SERVICE")
public interface RatingService {
	
	@PostMapping("/ratingService/makeHotelRating")
	Rating createRating(Rating rating);
}
