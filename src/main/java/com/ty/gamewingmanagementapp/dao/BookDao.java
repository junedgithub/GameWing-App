package com.ty.gamewingmanagementapp.dao;

import java.util.Optional;

import org.aspectj.weaver.patterns.ConcreteCflowPointcut.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.ty.gamewingmanagementapp.dto.Booking;
import com.ty.gamewingmanagementapp.dto.Role;
import com.ty.gamewingmanagementapp.dto.SlotStatus;
import com.ty.gamewingmanagementapp.dto.Slots;
import com.ty.gamewingmanagementapp.dto.User;
import com.ty.gamewingmanagementapp.exception.IdNotFoundException;
import com.ty.gamewingmanagementapp.exception.SlotIdNotFoundException;
import com.ty.gamewingmanagementapp.repository.BookingRepository;
import com.ty.gamewingmanagementapp.repository.SlotsRepository;
import com.ty.gamewingmanagementapp.repository.UserRepository;

@Repository
public class BookDao {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private SlotsRepository slotRepository;
	
	@Autowired
	private UserRepository userRepository;

	public Booking makeBooking(Booking booking, int slotId, int customerId) {
		User manager = userRepository.findByRole(Role.Manager);
		System.out.println(manager);
		if(manager != null)
		{
		Optional<User> optCustomer = userRepository.findById(customerId);
		
		if(optCustomer.isPresent())
		{
			User  customer = optCustomer.get();
			Optional<Slots> optSlot =  slotRepository.findById(slotId);
			if(optSlot.isPresent())
			{
				Slots slot = optSlot.get();
				if(slot.getSlotStatus().equals(SlotStatus.Available))
				{
					booking.setCustomer_id(customer);
					booking.setSlot_id(slot);
					
					
					slot.setBooking(booking);
					slot.setSlotStatus(SlotStatus.Booked);
					customer.setBooking(booking);
					
					//saving booking
					bookingRepository.save(booking);
					
					//updating slot
					slotRepository.save(slot);
					
					//updating customer
					userRepository.save(customer);
					return booking;
				}
			}else
			{
				throw new SlotIdNotFoundException();
			}
		}
		else
		{
			throw new IdNotFoundException("Custome Id not Found");
		}
		}
		return  null;
	}

	public Booking cancelbooking(int bookingId) {
		
		Optional<Booking> optBooking = bookingRepository.findById(bookingId);
		
		if(optBooking.isPresent())
		{
			Booking booking = optBooking.get();
			
			//fethcing slot from booking
			Slots slot = booking.getSlot_id();
			slot.setBooking(null);
			slot.setSlotStatus(SlotStatus.Available);
			
			//fetching customer from booking
			User customer = booking.getCustomer_id();
			customer.setBooking(null);
			
			booking.setCustomer_id(null);
			booking.setSlot_id(null);
			
			//saving updated slot
			slotRepository.save(slot);
			
			//saving updated customer
			userRepository.save(customer);
			
			bookingRepository.delete(booking);
			
			return booking;
//			return bookingRepository.findById(bookingId).get();
		}else
		{
			return null;
		}
	}
}
