package com.ojas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.entity.Hotel;
import com.ojas.repo.HotelRepository;
@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepo;
	@Override
	public Hotel SaveOrUpdate(Hotel hotel) {
		
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		
		return hotelRepo.findAll();
	}

}
