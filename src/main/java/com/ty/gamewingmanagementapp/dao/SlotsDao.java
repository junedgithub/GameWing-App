package com.ty.gamewingmanagementapp.dao;

import com.ty.gamewingmanagementapp.dto.PlayArea;
import com.ty.gamewingmanagementapp.dto.Role;
import com.ty.gamewingmanagementapp.dto.Slots;
import com.ty.gamewingmanagementapp.dto.User;
import com.ty.gamewingmanagementapp.repository.PlayAreaRepository;
import com.ty.gamewingmanagementapp.repository.SlotsRepository;
import com.ty.gamewingmanagementapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SlotsDao {
    @Autowired
    private SlotsRepository slotsRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayAreaRepository playAreaRepository;

    public Slots saveSlots(Slots slot, int playAreaId) {
        Optional<PlayArea> optPlayArea = playAreaRepository.findById(playAreaId);
        if (optPlayArea.isPresent()){
            PlayArea playArea = optPlayArea.get();
            List<Slots> slots = playArea.getSlotsList();
            if (slots==null){
                slots=new ArrayList<>();
            }
            slots.add(slot);
            playArea.setSlotsList(slots);
            slot.setPlayArea(playArea);
            slotsRepository.save(slot);
            playAreaRepository.save(playArea);
            return slot;
        }else
            return null;

    }

    public Slots addSlotToPlayArea(int slotId, int playAreaId) {
        User owner = userRepository.findByRole(Role.Owner);
        if (owner!=null) {
            Optional<Slots> optSlot = slotsRepository.findById(slotId);
            Optional<PlayArea> optPlayArea = playAreaRepository.findById(playAreaId);
            if (optSlot.isPresent() && optPlayArea.isPresent()) {
                Slots slot = optSlot.get();
                PlayArea playArea = optPlayArea.get();
                List<Slots> slots = playArea.getSlotsList();
                if (slots == null) {
                    slots = new ArrayList<>();
                }
                slots.add(slot);
                playArea.setSlotsList(slots);
                slot.setPlayArea(playArea);
                slotsRepository.save(slot);
                playAreaRepository.save(playArea);
                return slot;
            }else
                return null;
        }else
            return null;
    }
}
