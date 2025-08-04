package com.microservice.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.microservice.userservice.External.Service.HotelService;
import com.microservice.userservice.entity.Hotel;


@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	 private HotelService hotelservice;
	
	
	//CREATING THE HOTEL
	@Test
	void createHotel() {
		new Hotel();
		Hotel hotel = Hotel.builder()
								.hotelName("LineHotel")
								.hotelLocation("National Highway")
								.hotelContact("963258741")
								.hotelEmail("pehlwan03@gmail.com")
								.build();
		
		Hotel saveHotel = hotelservice.createHotel(hotel);
		
		System.out.println("HOTEL CREATED INSIDE TEST CLASS\n"+saveHotel);
	}
	
	
	
	//UPDATING THE HOTEL
	/*@Test
	void updateHotel() {
		new Hotel();
		Hotel hotel = Hotel.builder()
								.hotelName("Pehelwan Dhabha")
								.hotelLocation("National Highway")
								.hotelContact("963258741")
								.hotelEmail("pehlwan03@gmail.com")
								.build();
		
		Hotel saveHotel = hotelservice.updateHotel("1a98d43b-ad1d-4566-a869-8cb1b49fb872", hotel);
		
		System.out.println("HOTEL UPDATED INSIDE TEST CLASS\n"+saveHotel);
	}*/
	
	
	//DELETE THE HOTEL
	/*@Test
	void deleteHotel() {
		hotelservice.deleteHotel("1a98d43b-ad1d-4566-a869-8cb1b49fb872");
		System.out.println("HOTEL DELETED");
	}*/

}
