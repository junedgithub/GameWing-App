package com.ty.gamewingmanagementapp.dao;

import com.ty.gamewingmanagementapp.dto.Role;
import com.ty.gamewingmanagementapp.dto.Slots;
import com.ty.gamewingmanagementapp.dto.User;
import com.ty.gamewingmanagementapp.repository.SlotsRepository;
import com.ty.gamewingmanagementapp.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SlotsDao {
    @Autowired
    private SlotsRepository slotsRepository;
    @Autowired
    private UserRepository userRepository;

    public Slots saveSlots(Slots slot) {
        return slotsRepository.save(slot);
    }

	public  Slots deleteSlots(int slot) {
		// TODO Auto-generated method stub
		
		Optional<Slots> slot1=slotsRepository.findById(slot);
		
		if(slot1.isPresent())
		{
			slotsRepository.deleteById(slot);
		
			return slot1.get();
		}
		return null;
	}

}
