package com.userservice.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userservice.entity.HotelEntity;


@FeignClient(name = "HOTEL-SERVICE")
public interface HotelServiceFeign 
{
	@GetMapping("/hotel/{userId}")
	HotelEntity getHotelByUserId(@PathVariable String userId);
}
