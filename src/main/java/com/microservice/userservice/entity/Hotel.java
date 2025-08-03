package com.microservice.userservice.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Hotel {
	
	private String hotelId;
	
	private String hotelName;
	
	private String hotelContact;
	
	private String hotelLocation;
	
	private String hotelEmail;
	
}
