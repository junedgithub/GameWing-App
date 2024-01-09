package com.ty.gamewingmanagementapp.dao;

import com.ty.gamewingmanagementapp.dto.PlayArea;
import com.ty.gamewingmanagementapp.dto.Role;
import com.ty.gamewingmanagementapp.dto.SportClub;
import com.ty.gamewingmanagementapp.dto.User;
import com.ty.gamewingmanagementapp.repository.PlayAreaRepository;
import com.ty.gamewingmanagementapp.repository.SportClubRepository;
import com.ty.gamewingmanagementapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PlayAreaDao {
    @Autowired
    private PlayAreaRepository playAreaRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SportClubRepository sportClubRepository;
    public PlayArea addPlayArea(PlayArea playArea) {
        return playAreaRepository.save(playArea);
    }

    public PlayArea addPlayAreaToSportClub(int areaId, int clubId) {
        User owner = userRepository.findByRole(Role.Owner);
        if (owner!=null) {
            Optional<PlayArea> optPlayArea = playAreaRepository.findById(areaId);
            Optional<SportClub> optSportClub = sportClubRepository.findById(clubId);
            if (optPlayArea.isPresent() && optSportClub.isPresent()) {
                PlayArea playArea = optPlayArea.get();
                SportClub sportClub = optSportClub.get();
                playArea.setSportClub(sportClub);
                List<PlayArea> playAreas = sportClub.getPlayAreas();
                if (playAreas!=null){
                    playAreas = new ArrayList<>();
                }
                playAreas.add(playArea);
                sportClub.setPlayAreas(playAreas);
                owner.setSportClubs(sportClub);
                sportClub.setOwner(owner);
                playAreaRepository.save(playArea);
                sportClubRepository.save(sportClub);
                userRepository.save(owner);
                return playArea;
            }else
                return null;
        }else
            return null;
    }
}
