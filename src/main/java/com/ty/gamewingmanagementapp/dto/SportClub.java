package com.ty.gamewingmanagementapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class SportClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String location;
    @OneToOne
    private User owner;
    @OneToMany(mappedBy = "sportClub")
    @JsonIgnore
    private List<PlayArea> playAreas;
    private int slots;
    @OneToMany(mappedBy = "sportClub")
    @JsonIgnore
    private List<Slots> slotsList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<PlayArea> getPlayAreas() {
        return playAreas;
    }

    public void setPlayAreas(List<PlayArea> playAreas) {
        this.playAreas = playAreas;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public List<Slots> getSlotsList() {
        return slotsList;
    }

    public void setSlotsList(List<Slots> slotsList) {
        this.slotsList = slotsList;
    }

    
}
