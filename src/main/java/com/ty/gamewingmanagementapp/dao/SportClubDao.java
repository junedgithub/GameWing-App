package com.ty.gamewingmanagementapp.dao;

import com.ty.gamewingmanagementapp.dto.Role;
import com.ty.gamewingmanagementapp.dto.SportClub;
import com.ty.gamewingmanagementapp.dto.User;
import com.ty.gamewingmanagementapp.repository.SportClubRepository;
import com.ty.gamewingmanagementapp.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SportClubDao {
    @Autowired
    private SportClubRepository sportClubRepository;
    @Autowired
    private UserRepository userRepository;
    public SportClub addSportClub(SportClub sportClub) {
        User user = userRepository.findByRole(Role.Owner);
        sportClub.setOwner(user);
        user.setSportClubs(sportClub);
        if (user!=null) {
        	
            SportClub receivedSportClub = sportClubRepository.save(sportClub);
            userRepository.save(user);
            return receivedSportClub;
        }else
            return null;
    }
	public SportClub findSportClubById(int sportclubId) {
		Optional<SportClub> club = sportClubRepository.findById(sportclubId);
		
		if(club.isPresent())
		{
			return club.get();
		}
		return  null;
	}
}
