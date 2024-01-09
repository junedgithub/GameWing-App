package com.ty.gamewingmanagementapp.repository;

import com.ty.gamewingmanagementapp.dto.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
