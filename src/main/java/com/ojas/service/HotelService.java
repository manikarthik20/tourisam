package com.ojas.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.ojas.entity.Hotel;


@Service
public interface HotelService {

	public Hotel SaveOrUpdate(Hotel hotel);
	public List<Hotel> getAllHotels();
}
