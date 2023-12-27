package com.userservice.entity;

import lombok.Data;

@Data
public class Ratings 
{
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	private HotelEntity hotel;
}
