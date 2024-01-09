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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BookingController 
{
	@Autowired
	private BookingService bookingService;
	
	@Operation(description = "Make Booking",summary = "Booking got created ")
    @ApiResponses(value = {@ApiResponse(description = "Booking created",responseCode = "302"),@ApiResponse(description = "Booking Failed",responseCode = "404")})
	 @PostMapping("/booking/slotId/{slotId}/customerId/{customerId}")
	    public ResponseEntity<ResponseStructure<Booking>> booking(@RequestBody  Booking booking ,@PathVariable int slotId ,@PathVariable int customerId)
	    {
	    	return bookingService.booking(booking,slotId,customerId);
	    }
	 
	@Operation(description = "Cancel Booking",summary = "Booking got cancelled")
    @ApiResponses(value = {@ApiResponse(description = "Booking Cancel",responseCode = "302"),@ApiResponse(description = "Not Deleted",responseCode = "404")})
	 @DeleteMapping("/cancelBooking/BookingId/{bookingId}")
	 public ResponseEntity<ResponseStructure<Booking>>  cancelBooking(@PathVariable int bookingId)
	 {
		 return bookingService.cancelBooking(bookingId);
	 }
}
