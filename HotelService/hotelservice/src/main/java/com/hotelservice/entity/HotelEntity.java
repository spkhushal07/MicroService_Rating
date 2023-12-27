package com.hotelservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "hotel_data")
public class HotelEntity 
{
	@Id
	@Column(name="hotel_id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private String hotelId;
	private String name;
	private String location;
	@Column(name = "mobile_number")
	private String mobileNumber;
	private String about;
	private double price;
}
