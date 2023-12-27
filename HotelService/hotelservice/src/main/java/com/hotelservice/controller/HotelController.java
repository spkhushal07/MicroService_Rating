package com.hotelservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelservice.entity.HotelEntity;
import com.hotelservice.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	HotelService hotelService;
	
	@PostMapping("/add")
	public ResponseEntity<HotelEntity> addHotel(@RequestBody HotelEntity entity)
	{
		return  ResponseEntity.status(HttpStatus.CREATED).body(hotelService.addhotel(entity));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<HotelEntity>> getHotelByName(@PathVariable String name)
	{
		List<HotelEntity> data=hotelService.getHotel(name);
		return ResponseEntity.ok(data);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<HotelEntity> getHotelByUserId(@PathVariable String userId)
	{
		HotelEntity data=hotelService.getWithHotelId(userId);
		return ResponseEntity.ok(data);
	}
	@GetMapping("")
	public ResponseEntity<List<HotelEntity>> getHotelByName()
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotel());
	}

}
