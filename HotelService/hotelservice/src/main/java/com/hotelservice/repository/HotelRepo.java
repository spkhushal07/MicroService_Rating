package com.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelservice.entity.HotelEntity;
@Repository
public interface HotelRepo extends JpaRepository<HotelEntity, String> {

	boolean existsByMobileNumber(String number);

	boolean existsByLocation(String location);

	boolean existsByName(String name);

}
