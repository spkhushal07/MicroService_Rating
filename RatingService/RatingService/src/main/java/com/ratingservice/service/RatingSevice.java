package com.ratingservice.service;

import java.util.List;

import com.ratingservice.entity.RatingEntity;

public interface RatingSevice 
{
	//create
	public RatingEntity giveRating(RatingEntity entity);
	
	//get all rating
	public List<RatingEntity> getAllRating();
	
	//get rating by user
	public List<RatingEntity> getAllRatingFromUser(String UserId);
	
	//get rating by hotel name
	public List<RatingEntity> getAllRatingByHotelName(String name);

}
