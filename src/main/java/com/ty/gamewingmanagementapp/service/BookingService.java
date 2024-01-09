package com.ty.gamewingmanagementapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.gamewingmanagementapp.dao.BookDao;
import com.ty.gamewingmanagementapp.dto.Booking;
import com.ty.gamewingmanagementapp.dto.ResponseStructure;
import com.ty.gamewingmanagementapp.dto.User;

@Service
public class BookingService
{
	@Autowired
	private BookDao bookDao;

	public ResponseEntity<ResponseStructure<Booking>> booking(Booking booking, int slotId, int customerId) {
		
		Booking receivedbooking = bookDao.makeBooking(booking,slotId,customerId);
		
	        if (receivedbooking!=null) {
	            ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
	            responseStructure.setStatusCode(HttpStatus.OK.value());
	            responseStructure.setMessage("Booking Done");
	            responseStructure.setData(receivedbooking);
	            return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.OK);
	        }else{
	            ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
	            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
	            responseStructure.setMessage("Not Created");
	           
	            return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.BAD_REQUEST);
	        }
	}

	public ResponseEntity<ResponseStructure<Booking>> cancelBooking(int bookingId) {
		
		Booking receivedBooking = bookDao.cancelbooking(bookingId);
		
		if(receivedBooking != null)
		{
			ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.OK);
		}else
		{
			ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseStructure.setMessage("Not Deleted");
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.OK);
			
		}
	}
}
