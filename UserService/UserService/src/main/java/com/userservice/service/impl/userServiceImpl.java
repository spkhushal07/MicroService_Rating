package com.userservice.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.controller.user_defined_exception.ResourceAlreadyExitsException;
import com.userservice.controller.user_defined_exception.ResourceNotFoundException;
import com.userservice.dto.userDto;
import com.userservice.entity.HotelEntity;
import com.userservice.entity.Ratings;
import com.userservice.entity.UserEntity;
import com.userservice.external.service.HotelServiceFeign;
import com.userservice.external.service.RatingServiceFeign;
import com.userservice.repository.UserRepo;
import com.userservice.service.userService;
@Service
public class userServiceImpl implements userService{
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HotelServiceFeign feign;
	
	@Autowired
	RatingServiceFeign feign2;

	//Create User

	@Override
	public UserEntity createUser(UserEntity user) {
		if(repo.existsUserEntityByEmail(user.getEmail())|| repo.existsById(user.getUserId())||repo.existsUserEntityByPhoneNumber(user.getPhoneNumber()))
		{
			throw new ResourceAlreadyExitsException("User alreay Exist");
		}
		else
		{
			return repo.save(user);
		}
		
	}

	
	//Get Users

	@Override
	public List<UserEntity> getUsers() {
		if(repo.findAll().isEmpty())
		{
			throw new ResourceNotFoundException("User are yet to Register");
		}
		return repo.findAll();
	}
	//Get a particular user by id

	@Override
	public UserEntity getUser(String id) {
		UserEntity entity= repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found on server with given user id :"+id));
		System.out.println("in get user method");
		Ratings[] ratings= restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+entity.getUserId(),Ratings[].class);
		List<Ratings> listOfRatings=Arrays.stream(ratings).toList();
		
		List<Ratings> ratingList=listOfRatings.stream().map(rating ->{
			
		/** Calling rest service using restTemplet
		ResponseEntity<HotelEntity> data=	restTemplate.getForEntity("http://HOTEL/hotel/"+rating.getHotelId(), HotelEntity.class);**/	
			
			//Calling rest service using Feign client
			HotelEntity details=feign.getHotelByUserId(rating.getHotelId());
			
			rating.setHotel(details);
			return(rating);
		}).collect(Collectors.toList());
		entity.setRating(ratingList);
		return entity;
	}

	//Delete User by id

	@Override
	public String deleteUser(String id) {
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return "Associted user with user id: "+id+" is deleted";
		}else
			throw new ResourceNotFoundException("user not exist on the server with user id: "+id);
	}

	//Update user by id

	@Override
	public UserEntity updateUser(String id,userDto dto) {
		
		Optional<UserEntity> data=repo.findById(id);
		if(data.isPresent())
		{
			UserEntity entity=data.get();
			System.out.print(entity);
			entity.setUserId(id);
			entity.setName(entity.getName());
			entity.setLastName(entity.getLastName());
			entity.setEmail(dto.getEmail());
			entity.setPhoneNumber(dto.getPhoneNumber());
			entity.setAge(dto.getAge());
			return repo.save(entity);
			
			
		}
		
		throw new ResourceNotFoundException("user not exist on the server with user id: "+id);
	}

}
