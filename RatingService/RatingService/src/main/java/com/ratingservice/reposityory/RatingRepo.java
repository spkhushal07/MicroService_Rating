package com.ratingservice.reposityory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ratingservice.entity.RatingEntity;

public interface RatingRepo extends MongoRepository<RatingEntity, String> {
	
	List<RatingEntity> findByUserId(String userId);
	List<RatingEntity> findByRatingId(String ratingId);
	List<RatingEntity> findByHotelId(String name);

}
