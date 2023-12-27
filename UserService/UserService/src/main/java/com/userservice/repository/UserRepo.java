package com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, String>{

	boolean existsUserEntityByEmail(String email);
	boolean existsUserEntityByPhoneNumber(String number);

}
