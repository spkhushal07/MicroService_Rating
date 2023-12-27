package com.hotelservice.user_defined_exceptions;

public class HotelExitsException extends RuntimeException
{
	public HotelExitsException() {
		super("Hotel exists");
	}
	public HotelExitsException(String message)
	{
		super(message);
	}
}
