package com.hotelservice.user_defined_exceptions;

public class HotelNotFoundException extends RuntimeException
{
	public HotelNotFoundException() {
		super("Hotel not found");
	}
	public HotelNotFoundException(String message)
	{
		super(message);
	}
}
