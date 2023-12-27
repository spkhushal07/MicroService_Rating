package com.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.dto.userDto;
import com.userservice.entity.UserEntity;
import com.userservice.service.userService;

@RestController
@RequestMapping("/users")
public class userController
{
	@Autowired
	private userService service;
	
	//Registering user
	@PostMapping("/register")
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity entity)
	{
		UserEntity data=service.createUser(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(data);
	}
	
	//Get Users
	@GetMapping("/alluser")
	public ResponseEntity<List<UserEntity>> getListOfUsers()
	{
		List<UserEntity> allUser=service.getUsers();
		return ResponseEntity.ok(allUser);
	}
	
	//Get a particular user by id
	@GetMapping("{userId}")
	public ResponseEntity<UserEntity> getUser(@PathVariable String userId)
	{
		UserEntity user=service.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	//Delete User by id
	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId)
	{
		String message=service.deleteUser(userId);
		return ResponseEntity.ok(message);
	}
	
	//Update user by id
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable String userId,@RequestBody userDto dto)
	{
		UserEntity data=service.updateUser(userId, dto);
		return ResponseEntity.ok(data);
	}
	
}
