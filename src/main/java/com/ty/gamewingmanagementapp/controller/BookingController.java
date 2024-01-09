package com.ty.gamewingmanagementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.gamewingmanagementapp.dto.Booking;
import com.ty.gamewingmanagementapp.dto.ResponseStructure;
import com.ty.gamewingmanagementapp.service.BookingService;

@RestController
public class BookingController 
{
	@Autowired
	private BookingService bookingService;
	
	 @PostMapping("/booking/slotId/{slotId}/customerId/{customerId}")
	    public ResponseEntity<ResponseStructure<Booking>> booking(@RequestBody  Booking booking ,@PathVariable int slotId ,@PathVariable int customerId)
	    {
	    	return bookingService.booking(booking,slotId,customerId);
	    }
	 
	 
	 @DeleteMapping("/cancelBooking/BookingId/{bookingId}")
	 public ResponseEntity<ResponseStructure<Booking>>  cancelBooking(@PathVariable int bookingId)
	 {
		 return bookingService.cancelBooking(bookingId);
	 }
}
