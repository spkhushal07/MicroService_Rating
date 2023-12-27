package com.hotelservice.service;

import java.util.List;

import com.hotelservice.entity.HotelEntity;

public interface HotelService 
{
	//create hotel
	public HotelEntity addhotel(HotelEntity entity);
	//get single hotel
	public List<HotelEntity> getHotel(String name);
	//get single hotel
	public HotelEntity getWithHotelId(String userId);
	//get all hotel
	public List<HotelEntity> getAllHotel();
	//delete hotel
	public String deleteHotel(String name);	
	//update particular hotel
	public HotelEntity updateHotel(String name);
}
