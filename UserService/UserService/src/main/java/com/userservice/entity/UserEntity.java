package com.userservice.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Table(name = "hotel_user")
@Entity
public class UserEntity {
	
	@Id
	@Column(name="user_id")
	private String userId;
	private String name;
	@Column(name = "last_name")
	private String lastName;
	private String email;
	@Column(name = "phone_number")
	private String phoneNumber;
	private Integer age;
	 
	@Transient
	private List<Ratings> rating= new ArrayList<>();
}
