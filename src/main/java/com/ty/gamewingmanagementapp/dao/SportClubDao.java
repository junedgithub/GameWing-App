package com.ty.gamewingmanagementapp.dao;

import com.ty.gamewingmanagementapp.dto.Role;
import com.ty.gamewingmanagementapp.dto.SportClub;
import com.ty.gamewingmanagementapp.dto.User;
import com.ty.gamewingmanagementapp.repository.SportClubRepository;
import com.ty.gamewingmanagementapp.repository.UserRepository;
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
        if (user!=null) {
            user.setSportClubs(sportClub);
            sportClub.setOwner(user);
            sportClubRepository.save(sportClub);
            userRepository.save(user);
            return sportClub;
        }else
            return null;
    }
}
