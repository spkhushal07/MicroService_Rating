package com.hotelservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelservice.entity.HotelEntity;
import com.hotelservice.repository.HotelRepo;
import com.hotelservice.service.HotelService;
import com.hotelservice.user_defined_exceptions.HotelExitsException;
import com.hotelservice.user_defined_exceptions.HotelNotFoundException;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	HotelRepo hotelRepo;
	
	@Override
	public HotelEntity addhotel(HotelEntity entity) {
		if(hotelRepo.existsByMobileNumber(entity.getMobileNumber()) && hotelRepo.existsByLocation(entity.getLocation()) && hotelRepo.existsByName(entity.getName()))
		{
			throw new HotelExitsException("Hotel with given details already exists in database");
		}
		return hotelRepo.save(entity);
	}

	@Override
	public List<HotelEntity> getHotel(String name) {
		List<HotelEntity> allEntities=getAllHotel();
		List<HotelEntity> entities=new ArrayList<>();
		if(hotelRepo.existsByName(name))
		{
			for(HotelEntity hotel :allEntities)
			{
				if(hotel.getName().equals(name))
				{
					entities.add(hotel);
				}
			}
			if(entities.isEmpty())
			{
				throw new HotelNotFoundException("Hotel not found with name: "+name);

			}
		}
		return entities;
	}

	@Override
	public List<HotelEntity> getAllHotel() {
		

		if(hotelRepo.findAll().isEmpty())
		{
			throw new HotelNotFoundException("Hotel yet to registers Please register!!!");
		}
		
		return hotelRepo.findAll();
	}

	@Override
	public String deleteHotel(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelEntity updateHotel(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelEntity getWithHotelId(String userId) {
		List<HotelEntity> allEntities=getAllHotel();
		HotelEntity entities=new HotelEntity();
		if(hotelRepo.existsById(userId))
		{
			for(HotelEntity hotel :allEntities)
			{
				if(hotel.getHotelId().equals(userId))
				{
					entities=hotel;
				}
			}
			if(allEntities.isEmpty())
			{
				throw new HotelNotFoundException("Hotel not found with id: "+userId);

			}
		}
		return entities;
	}

}
