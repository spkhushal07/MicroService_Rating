package com.userservice.service;

import java.util.List;

import com.userservice.dto.userDto;
import com.userservice.entity.UserEntity;

public interface userService {
	
	//Create User
	
	UserEntity createUser(UserEntity user);
	
	//Get Users
	List<UserEntity> getUsers();
	
	//Get a particular user by id
	UserEntity getUser(String id);
	
	//Delete User by id
	
	String deleteUser(String id);
	
	//Update user by id
	
	UserEntity updateUser(String id,userDto dto);
	
	

}
