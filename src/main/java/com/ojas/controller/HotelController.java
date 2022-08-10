package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.entity.Hotel;
import com.ojas.service.HotelServiceImpl;

@RestController
public class HotelController {
	@Autowired
private HotelServiceImpl hotelService;
	@PostMapping("/addHotel")
public Hotel addHotel(@RequestBody Hotel hotel) {
	return hotelService.SaveOrUpdate(hotel);	
}
	@GetMapping("/allHotel")
	private List<Hotel> getAllHotels(){
		return hotelService.getAllHotels();
		
	}
}
