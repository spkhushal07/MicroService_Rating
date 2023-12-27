package com.ratingservice.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingservice.entity.RatingEntity;
import com.ratingservice.reposityory.RatingRepo;
import com.ratingservice.service.RatingSevice;

@Service
public class RatingServiceImpl implements RatingSevice{

	@Autowired
	private RatingRepo ratingRepo;
	
	@Override
	public RatingEntity giveRating(RatingEntity entity) {
		
		return ratingRepo.save(entity);
	}

	@Override
	public List<RatingEntity> getAllRating() {
		return ratingRepo.findAll();
	}

	@Override
	public List<RatingEntity> getAllRatingFromUser(String UserId) {
		// TODO Auto-generated method stub
		System.out.println("inside rating method");
		return ratingRepo.findByUserId(UserId);
	}

	@Override
	public List<RatingEntity> getAllRatingByHotelName(String name) {
		// TODO Auto-generated method stub
		return ratingRepo.findByHotelId(name);
	}

}
