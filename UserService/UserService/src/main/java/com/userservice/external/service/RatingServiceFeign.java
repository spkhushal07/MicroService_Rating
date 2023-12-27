package com.userservice.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userservice.entity.Ratings;

@FeignClient(name = "RATING-SERVICE")
public interface RatingServiceFeign {

	@GetMapping("/rating/user/{userId}")
	Ratings getRating(@PathVariable String userId);
}
