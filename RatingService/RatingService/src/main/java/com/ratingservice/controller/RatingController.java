package com.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingservice.entity.RatingEntity;
import com.ratingservice.serviceimp.RatingServiceImpl;

@RestController
@RequestMapping("/rating")
public class RatingController 
{
	@Autowired
	private RatingServiceImpl impl;
	
	
	@PostMapping("")
	public ResponseEntity<RatingEntity> giveRating(@RequestBody RatingEntity entity)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(impl.giveRating(entity));
	}
	
	@GetMapping("/allRating")
	public ResponseEntity<List<RatingEntity>> getAllRating()
	{
		return ResponseEntity.ok(impl.getAllRating());
	}
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<RatingEntity>> getRatingByUserId(@PathVariable String userId)
	{
		return ResponseEntity.ok(impl.getAllRatingFromUser(userId));
	}
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<RatingEntity>> getRatingByHotelId(@PathVariable String hotelId)
	{
		return ResponseEntity.ok(impl.getAllRatingByHotelName(hotelId));
	}
	
	
}
